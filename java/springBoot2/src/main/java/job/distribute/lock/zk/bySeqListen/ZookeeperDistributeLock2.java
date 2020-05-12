package job.zk;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author taobaibai
 * @create 2020-05-06 22:24
 */
public class ZookeeperDistributeLock2 extends ZookeeperAbstractLock {
    private String beforePath;  //当前请求的节点前一个节点
    private String currentPath; //当前请求的节点
    private CountDownLatch countDownLatch;

    public ZookeeperDistributeLock2() {
        if (!zkClient.exists(PATH2)) {
            zkClient.createPersistent(PATH2);
        }
    }

    @Override
    protected void waitLock() {
        IZkDataListener listener = new IZkDataListener() {
            public void handleDataDeleted(String datapath) throws Exception {
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
            public void handleDataChange(String datapath, Object data) throws Exception {}
        };
        //给排在前面的的芳点增加数据删除watcher,本质是启动另外-个线程去监听前置 节点
        zkClient.subscribeDataChanges(beforePath, listener);
        if (this.zkClient.exists(beforePath)) {
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                this.zkClient.unsubscribeDataChanges(beforePath, listener);
            }
        }
    }

    @Override
    protected boolean tryLock() {
        //如果currentPath为空则为第一次尝试加锁， 第-“次加锁赋值currentpath
        if (currentPath == null || currentPath.length() <= 0) {
            //创建一个临时顺序 节点
            currentPath = this.zkClient.createEphemeralSequential(PATH2 + '/', "lock");
        }
        //获取所有临时节点并排序，临时节点名称为自增长的字符串如: 0000004000
        List<String> childrens = this.zkClient.getChildren(PATH2);
        Collections.sort(childrens);
        if (currentPath.equals(PATH2 + '/' + childrens.get(0))) {//如果当前节点在所有节点中排名第-则获取锁成功
            return true;
        } else {//如果当前节点在所有节点中排名中不是排名第一，则获取前面的节点名称，并赋值给beforePath
            int wz = Collections.binarySearch(childrens, currentPath.substring(7));
            beforePath = PATH2 + '/' + childrens.get(wz - 1);
            return false;
        }
    }

    public void unLock() {
        if (zkClient != null) {
            zkClient.delete(PATH);
            System.out.println("释放锁资源...");
        }
    }

}
