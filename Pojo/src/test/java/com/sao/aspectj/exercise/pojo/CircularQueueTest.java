package com.sao.aspectj.exercise.pojo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by saoprb on 12/12/2016.
 */
public class CircularQueueTest {
    private CircularQueue<Integer> circularQueue;

    @Before
    public void beforeTest() {
        circularQueue = new CircularQueue(new Integer(0), 10);
        Assert.assertNotNull(circularQueue);
    }

    @Test(expected = com.sao.aspectj.exercise.pojo.ExceptionQueueFull.class)
    public void testAddingToQueueUntilFull() throws ExceptionQueueEmpty, ExceptionQueueFull {
        Random random = new Random();

        circularQueue.clear();

        while (true) {
            circularQueue.add(new Integer(random.nextInt(20)));
        }
    }

    @Test(expected = com.sao.aspectj.exercise.pojo.ExceptionQueueEmpty.class)
    public void testRemovingFromQueueUntilEmpty() throws ExceptionQueueEmpty, ExceptionQueueFull {
        clearAndPopulateQueue(new int[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 });

        while (true) {
            Integer item = circularQueue.remove();
            System.out.format("Item removed from queue: %s%n", item);
        }
    }

    @Test
    public void testQueueOrder() throws ExceptionQueueEmpty, ExceptionQueueFull {
        clearAndPopulateQueue(new int[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 });

        for (int i = 10; i <= 100; i+=10) {
            Assert.assertEquals(new Integer(i), circularQueue.remove());
        }
    }

    @Test
    public void testQueueIsNotEmpty() throws ExceptionQueueFull {
        circularQueue.clear();
        Assert.assertFalse(circularQueue.isFull());
        Assert.assertTrue(circularQueue.isEmpty());

        circularQueue.add(new Integer(1));
        Assert.assertFalse(circularQueue.isFull());
        Assert.assertFalse(circularQueue.isEmpty());
    }

    @Test
    public void testQueueIsFull() throws ExceptionQueueFull {
        clearAndPopulateQueue(new int[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 });

        Assert.assertTrue(circularQueue.isFull());
        Assert.assertFalse(circularQueue.isEmpty());
    }

    @Test(expected = com.sao.aspectj.exercise.pojo.ExceptionQueueEmpty.class)
    public void testQueueIsEmpty() throws ExceptionQueueEmpty {
        circularQueue.clear();
        Assert.assertFalse(circularQueue.isFull());
        Assert.assertTrue(circularQueue.isEmpty());

        circularQueue.remove();
    }

    @Test
    public void testQueueIsCircular() throws ExceptionQueueEmpty, ExceptionQueueFull {
        testQueueIsFull();

        Assert.assertEquals(new Integer(10), circularQueue.remove());

        circularQueue.add(new Integer(110));

        Assert.assertTrue(circularQueue.isFull());
        Assert.assertFalse(circularQueue.isEmpty());
    }

    private void clearAndPopulateQueue(int[] queueData) throws ExceptionQueueFull {
        circularQueue.clear();

        for (int data : queueData) {
            circularQueue.add(new Integer(data));
        }
    }
}