package job.zk;

import job.distribute.lock.zk.Lock;
import job.distribute.lock.zk.byException.ZookeeperDistributeLock;
import job.distribute.lock.zk.bySeqListen.ZookeeperDistributeLock2;

import java.util.Random;

/**
 * @author taobaibai
 * @create 2020-05-07 10:48
 */
public class OrderService implements Runnable {
//    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
    //使用 Lock
//    private Lock lock = new ZookeeperDistributeLock();
    private Lock lock = new ZookeeperDistributeLock2();

    @Override
    public void run() {
        getNumber();
    }

    private void getNumber() {
        try {
            lock.getLock();
//            String number = orderNumGenerator.getNumber();
            String number = String.valueOf(new Random(System.currentTimeMillis()).nextLong());
            System.out.println(Thread.currentThread().getName()+": 生成订单ID["+number+"].");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }
    }

    public static void main(String[] args) {
        System.out.println("===========生成唯一订单编号===========");
        for (int i = 0; i < 50; i++) {
            new Thread(new OrderService()).start();
        }
    }
}
