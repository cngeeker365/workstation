package job.distribute.lock.zk;

import org.I0Itec.zkclient.ZkClient;

/**
 * @author taobaibai
 * @create 2020-05-06 22:25
 */
public abstract class ZookeeperAbstractLock implements Lock{
    //zk连接地址
    private static final String CONNECT_STRING = "192.168.238.133:2181";
    //创建zk连接
    protected ZkClient zkClient = new ZkClient(CONNECT_STRING);
    protected static final String PATH = "/lock";
    protected static final String PATH2 = "/lock2";

    @Override
    public void getLock() {
        if(tryLock()){
            System.out.println("##获取 lock 锁的资源##");
        }else{
            //等待
            waitLock();
            //重新获取锁资源
            getLock();
        }
    }

    protected abstract void waitLock();

    protected abstract boolean tryLock();

    @Override
    public void unLock() {
        throw new UnsupportedOperationException("UnImplements unlock!");
    }
}
