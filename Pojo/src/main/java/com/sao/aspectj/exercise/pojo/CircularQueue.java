package com.sao.aspectj.exercise.pojo;

import java.lang.reflect.Array;

/**
 * Created by saoprb on 12/12/2016.
 */
public class CircularQueue<T> {

    final private int bufferSize;
    private int nextAdd;
    private int nextRemove;
    private T[] queue;

    public CircularQueue(T t, int bufferSize) {
        this.bufferSize = bufferSize;
        queue = (T[]) Array.newInstance(t.getClass(), bufferSize);
        nextAdd = 0;
        nextRemove = 0;
    }

    public void add(T t) throws ExceptionQueueFull {
        if (isFull())
            throw new ExceptionQueueFull();
        queue[nextAdd % bufferSize] = t;
        ++nextAdd;
    }

    public T remove() throws ExceptionQueueEmpty {
        if (isEmpty())
            throw new ExceptionQueueEmpty();

        T removed = queue[nextRemove % bufferSize];
        ++nextRemove;
        return removed;
    }

    public boolean isFull() {
      return (nextAdd - nextRemove) == bufferSize;
    }

    public boolean isEmpty() {
        return nextAdd - nextRemove == 0;
    }

    public void clear() {
        nextAdd = nextRemove = 0;
    }
}
