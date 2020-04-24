package com.jdk.wangwenjun.chapter6.c02_concurrencyCollection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author taobaibai
 * @create 2020-04-22 11:02
 */
public class ArrayBlockingQueueExampleTest {
    private ArrayBlockingQueueExample example;

    @Before
    public void setup(){
        example = new ArrayBlockingQueueExample();
    }

    @After
    public void tearDown(){
        example = null;
    }

    @Test
    public void testAdd_NotExceedCapacity(){
        ArrayBlockingQueue<String> queue = example.createQueue(5);
        assertThat(queue.add("Hello1"), equalTo(true));
        assertThat(queue.add("Hello2"), equalTo(true));
        assertThat(queue.add("Hello3"), equalTo(true));
        assertThat(queue.add("Hello4"), equalTo(true));
        assertThat(queue.add("Hello5"), equalTo(true));
        assertThat(queue.size(), equalTo(5));
    }

    @Test(expected = IllegalStateException.class)
    public void testAdd_ExceedCapacity(){
        ArrayBlockingQueue<String> queue = example.createQueue(5);
        assertThat(queue.add("Hello1"), equalTo(true));
        assertThat(queue.add("Hello2"), equalTo(true));
        assertThat(queue.add("Hello3"), equalTo(true));
        assertThat(queue.add("Hello4"), equalTo(true));
        assertThat(queue.add("Hello5"), equalTo(true));
        assertThat(queue.add("Hello6"), equalTo(true));
        fail("should not process to here");
    }

    @Test
    public void testOffer_NotExceedCapacity(){
        ArrayBlockingQueue<String> queue = example.createQueue(5);
        assertThat(queue.offer("Hello1"), equalTo(true));
        assertThat(queue.offer("Hello2"), equalTo(true));
        assertThat(queue.offer("Hello3"), equalTo(true));
        assertThat(queue.offer("Hello4"), equalTo(true));
        assertThat(queue.offer("Hello5"), equalTo(true));
        assertThat(queue.size(), equalTo(5));
    }

    @Test
    public void testOffer_ExceedCapacity(){
        ArrayBlockingQueue<String> queue = example.createQueue(5);
        assertThat(queue.offer("Hello1"), equalTo(true));
        assertThat(queue.offer("Hello2"), equalTo(true));
        assertThat(queue.offer("Hello3"), equalTo(true));
        assertThat(queue.offer("Hello4"), equalTo(true));
        assertThat(queue.offer("Hello5"), equalTo(true));
        assertThat(queue.offer("Hello5"), equalTo(false));
        assertThat(queue.size(), equalTo(5));
    }

    @Test
    public void testPut_NotExceedCapacity() throws InterruptedException {
        ArrayBlockingQueue<String> queue = example.createQueue(5);
        queue.put("Hello1");
        queue.put("Hello2");
        queue.put("Hello3");
        queue.put("Hello4");
        queue.put("Hello5");
        assertThat(queue.size(), equalTo(5));
    }

    @Test
    public void testPut_ExceedCapacity() throws InterruptedException {
        ArrayBlockingQueue<String> queue = example.createQueue(5);
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        Executors.newSingleThreadScheduledExecutor().schedule(()-> {
            try {
                assertThat(queue.take(), equalTo("Hello1"));   //先进先出
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, TimeUnit.SECONDS);
        queue.put("Hello1");
        queue.put("Hello2");
        queue.put("Hello3");
        queue.put("Hello4");
        queue.put("Hello5");
        queue.put("Hello6");    //超过size，会卡住
        executorService.shutdown();
    }

    @Test
    public void testPool(){
        ArrayBlockingQueue<String> queue = example.createQueue(2);
        queue.add("Hello1");
        queue.add("Hello2");
        //=====================================================
        assertThat(queue.poll(), equalTo("Hello1"));
        assertThat(queue.poll(), equalTo("Hello2"));
        assertThat(queue.poll(), nullValue());
    }

    @Test
    public void testPeek(){
        ArrayBlockingQueue<String> queue = example.createQueue(2);
        queue.add("Hello1");
        queue.add("Hello2");
        //=====================================================
        assertThat(queue.peek(), equalTo("Hello1"));
        assertThat(queue.peek(), equalTo("Hello1"));
        assertThat(queue.peek(), equalTo("Hello1"));
        assertThat(queue.peek(), equalTo("Hello1"));
        assertThat(queue.peek(), equalTo("Hello1"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testElement(){
        ArrayBlockingQueue<String> queue = example.createQueue(2);
        queue.add("Hello1");
        queue.add("Hello2");
        //=====================================================
        assertThat(queue.element(), equalTo("Hello1"));
        assertThat(queue.element(), equalTo("Hello1"));
        assertThat(queue.element(), equalTo("Hello1"));
        queue.clear();
        queue.element();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemove(){
        ArrayBlockingQueue<String> queue = example.createQueue(2);
        queue.add("Hello1");
        queue.add("Hello2");
        //=====================================================
        assertThat(queue.remove(), equalTo("Hello1"));
        assertThat(queue.remove(), equalTo("Hello2"));
        assertThat(queue.remove(), equalTo("Hello1"));
    }

    @Test
    public void testDrainTo(){
        ArrayBlockingQueue<String> queue = example.createQueue(5);
        queue.add("Hello1");
        queue.add("Hello2");
        queue.add("Hello3");
        //=====================================================
        assertThat(queue.size(), equalTo(3));
        assertThat(queue.remainingCapacity(), equalTo(2));
        assertThat(queue.remove(), equalTo("Hello1"));
        assertThat(queue.remainingCapacity(), equalTo(3));
        List<String> list = new ArrayList<>();
        queue.drainTo(list);
        assertThat(queue.remainingCapacity(), equalTo(5));
        assertThat(queue.size(), equalTo(0));
        assertThat(list.size(), equalTo(2));
    }
}
