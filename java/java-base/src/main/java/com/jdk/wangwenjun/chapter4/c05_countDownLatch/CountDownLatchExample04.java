package com.jdk.wangwenjun.chapter4.c05_countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author taobaibai
 * @create 2020-04-18 15:13
 */
public class CountDownLatchExample04 {
    private static Random random = new Random(System.currentTimeMillis());
    static class Event{
        int id = 0;

        public Event(int id) {
            this.id = id;
        }
    }

    interface Watcher{
//        void startWatch();
        void done(Table table);
    }

    static class TaskBatch implements Watcher{
        private CountDownLatch latch;
        private TaskGroup taskGroup;
        public TaskBatch(TaskGroup taskGroup, int size){
            this.taskGroup = taskGroup;
            this.latch = new CountDownLatch(size);
        }

        @Override
        public void done(Table table) {
            latch.countDown();
            if(latch.getCount()==0){
                System.out.println("The table " + table.tableName + " finished work, [" + table + "]");
                taskGroup.done(table);
            }
        }
    }

    static class TaskGroup implements Watcher{
        private CountDownLatch latch;
        private Event event;
        public TaskGroup(int size, Event e){
            this.event = e;
            this.latch = new CountDownLatch(size);
        }

        @Override
        public void done(Table table) {
            latch.countDown();
            if(latch.getCount()==0){
                System.out.println("=============All table done in event: "+event.id);
            }
        }
    }

    static class Table{
        String tableName;
        long srcRecordCount = 10;
        long targetCount;
        String srcColumnSchema="<table name='a'><column name='col1' type='varchar2' />";
        String targetColumnSchema = "";

        public Table(String tableName, long srcRecordCount) {
            this.tableName = tableName;
            this.srcRecordCount = srcRecordCount;
        }

        @Override
        public String toString() {
            return "Table{" +
                    "tableName='" + tableName + '\'' +
                    ", srcRecordCount=" + srcRecordCount +
                    ", targetCount=" + targetCount +
                    ", srcColumnSchema='" + srcColumnSchema + '\'' +
                    ", targetColumnSchema='" + targetColumnSchema + '\'' +
                    '}';
        }
    }

    static class TrustSrcRecordCount implements Runnable{
        private final Table table;
        private final TaskBatch taskBatch;

        public TrustSrcRecordCount(Table table, TaskBatch taskBatch) {
            this.table = table;
            this.taskBatch = taskBatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            table.targetCount = table.srcRecordCount;
//            System.out.println("The table " + table.tableName + " target record count capture done and update the data.");
            taskBatch.done(table);
        }
    }

    static class TrustSrcColumns implements Runnable{
        private final Table table;
        private final TaskBatch taskBatch;

        public TrustSrcColumns(Table table, TaskBatch taskBatch) {
            this.table = table;
            this.taskBatch = taskBatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            table.targetColumnSchema = table.srcColumnSchema;
//            System.out.println("The table " + table.tableName + " target columns capture done and update the data.");
            taskBatch.done(table);
        }
    }

    private static List<Table> capture(Event event){
        List<Table> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Table("table-"+i, i*1000));
        }
        return list;
    }

    public static void main(String[] args) {
        Event[] events = {new Event(1), new Event(2)};
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(Event event : events){
            List<Table> tables = capture(event);
            TaskGroup taskGroup = new TaskGroup(tables.size(), event);
            for(Table table : tables){
                TaskBatch taskBatch = new TaskBatch(taskGroup, 2);
                TrustSrcColumns trustSrcColumns = new TrustSrcColumns(table, taskBatch);
                TrustSrcRecordCount trustSrcRecordCount = new TrustSrcRecordCount(table, taskBatch);
                executorService.submit(trustSrcColumns);
                executorService.submit(trustSrcRecordCount);
            }
        }
    }
}
