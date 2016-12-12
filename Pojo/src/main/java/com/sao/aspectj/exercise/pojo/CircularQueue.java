package com.sao.aspectj.exercise.pojo;

/**
 * Created by saoprb on 12/12/2016.
 */
public class CircularQueue<T> {

    final private int bufferSize;
    private int count;

    public CircularQueue(int bufferSize) {
        this.bufferSize = bufferSize;
        count = 0;
    }

    public void add(T t) throws ExceptionQueueFull {
        if (count > bufferSize)
            throw new ExceptionQueueFull();
        count++;
    }

    public T remove() throws ExceptionQueueEmpty {
        if (count <= 0)
            throw new ExceptionQueueEmpty();

        count--;
        T t = null;
        return t;
    }

    public boolean isFull() {
      return count == bufferSize;
    }

    public boolean isEmpty() {
        return count <= 0;
    }

    public void clear() {
        count = 0;
    }
}
