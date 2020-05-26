package job.distribute.lock.zk;

/**
 * @author taobaibai
 * @create 2020-05-06 22:23
 */
public interface Lock {
    //获得锁
    void getLock();
    //释放锁
    void unLock();
}
