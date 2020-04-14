package com.jdk.wangwenjun.chapter2.c04_observer.multiThread;

/**
 * @author taobaibai
 * @create 2020-04-14 15:08
 */
public abstract class ObserverRunnable implements Runnable {
    final protected LifeCycleListener listener;

    public ObserverRunnable(LifeCycleListener listener) {
        this.listener = listener;
    }

    protected void notifyChange(final RunnableEvent event){
        listener.onEvent(event);
    }

    @Override
    public void run() {

    }

    public enum RunnableState{
        RUNNING, ERROR, DONE;
    }

    public static class RunnableEvent{
        private final RunnableState state;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }
}
