package job.zk;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * @author taobaibai
 * @create 2020-05-06 22:24
 */
public class ZookeeperDistributeLock extends ZookeeperAbstractLock {
    private CountDownLatch countDownLatch = null;

    @Override
    protected void waitLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                //唤醒被等待的线程
                if(countDownLatch != null){
                    countDownLatch.countDown();
                }
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {}
        };
        //注册事件
        zkClient.subscribeDataChanges(PATH, iZkDataListener);
        if(zkClient.exists(PATH)){
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //删除监听
        zkClient.unsubscribeDataChanges(PATH, iZkDataListener);
    }

    @Override
    protected boolean tryLock() {
        try {
            zkClient.createEphemeral(PATH);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void unLock() {
        if(zkClient!=null){
            zkClient.delete(PATH);
            System.out.println("释放锁资源...");
        }
    }
}
