package com.jdk.wangwenjun.chapter1.c05_simpleAPI;

/**
 * 采用优雅的方式结束线程生命周期
 *      1) 通过开关
 *      2）通过 interrupt 方法触发
 * @author taobaibai
 * @create 2020-04-12 14:36
 */
public class SimpleAPI_06_closeForce {
    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(()->{
            //load a very heavy resource.
//            while (true){
//
//            }
            try {
                Thread.sleep(5_000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        service.shutdown(10_000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 通过开关
     */
    private static class ThreadService{
        private Thread executeThread;
        private boolean finished = false;

        public void execute(Runnable task){
            executeThread = new Thread(){
                @Override
                public void run() {
                    Thread runner = new Thread(task);
                    runner.setDaemon(true);
                    runner.start();
                    try {
                        runner.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            executeThread.start();
        }
        public void shutdown(long mills){
            long currentTime = System.currentTimeMillis();
            while (!finished){
                if (System.currentTimeMillis()-currentTime>=mills){
                    System.out.println("任务超时，需要结束！");
                    executeThread.interrupt();
                    break;
                }
                try {
                    executeThread.sleep(1);
                } catch (Exception e) {
                    System.out.println("执行线程被打断");
                    break;
                }
            }
        }
    }
}
