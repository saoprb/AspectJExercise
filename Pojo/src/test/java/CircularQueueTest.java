import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by saoprb on 12/12/2016.
 */
public class CircularQueueTest {
    final private CircularQueue<Integer> circularQueue;

    @Before
    public void beforeTest() {
        circularQueue = new CircularQueue<Integer>(10);
        Assert.assertNotNull(circularQueue);
    }

    @Test(expected = com.sao.aspectj.exercise.pojo.ExceptionQueueFull)
    public void testAddingToQueueUntilFull() {
        Random random = new Random();

        circularQueue.clear();

        while (true) {
            circularQueue.add(new Integer(random.nextInt(20)));
        }
    }

    @Test(expected = com.sao.aspectj.exercise.pojo.ExceptionQueueEmpty)
    public void testRemovingFromQueueUntilEmpty() {
        clearAndPopulateQueue(new int[]{ 10, 20, 30 });

        while (true) {
            Integer item = circularQueue.remove();
            System.out.format("Item removed from queue: %s%n", item);
        }
    }

    @Test
    public void testQueueOrder() {
        clearAndPopulateQueue(new int[]{ 10, 20, 30 });

        Assert.assertEquals(new Integer(10).equals(circularQueue.remove()));
        Assert.assertEquals(new Integer(20).equals(circularQueue.remove()));
        Assert.assertEquals(new Integer(30).equals(circularQueue.remove()));
    }

    @Test
    public void testQueueIsNotEmpty() {
        circularQueue.clear();
        Assert.assertFalse(circularQueue.isFull());
        Assert.assertTrue(circularQueue.isEmpty());

        circularQueue.add(new Integer(1));
        Assert.assertFalse(circularQueue.isFull());
        Assert.assertFalse(circularQueue.isEmpty());
    }

    @Test
    public void testQueueIsFull() {
        clearAndPopulateQueue(new int[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 });

        Assert.assertTrue(circularQueue.isFull());
        Assert.assertFalse(circularQueue.isEmpty());
    }

    @Test(expected = com.sao.aspectj.exercise.pojo.ExceptionQueueEmpty)
    public void testQueueIsEmpty() {
        circularQueue.clear();
        Assert.assertFalse(circularQueue.isFull());
        Assert.assertTrue(circularQueue.isEmpty());

        circularQueue.remove();
    }

    @Test
    public void testQueueIsCircular() {
        testQueueIsFull();

        Assert.assertEquals(new Integer(10).equals(circularQueue.remove()));

        circularQueue.add(new Integer(110));

        Assert.assertTrue(circularQueue.isFull());
        Assert.assertFalse(circularQueue.isEmpty());
    }

    private void clearAndPopulateQueue(int[] queueData) {
        circularQueue.clear();

        for (int data : queueData) {
            circularQueue.add(new Integer(data));
        }
    }
}