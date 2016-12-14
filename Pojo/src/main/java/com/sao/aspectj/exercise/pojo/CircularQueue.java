package com.sao.aspectj.exercise.pojo;

import com.sao.aspectj.exercise.aspect.TraceAnnotation;

import java.lang.reflect.Array;

/**
 * Created by saoprb on 12/12/2016.
 */
public class CircularQueue<T> {

    final private int bufferSize;
    private int nextAdd;
    private int nextRemove;
    private int count;
    private T[] queue;

    public CircularQueue(T t, int bufferSize) {
        this.bufferSize = bufferSize;
        queue = (T[]) Array.newInstance(t.getClass(), bufferSize);
        nextAdd = 0;
        nextRemove = 0;
        count = 0;
    }

    @TraceAnnotation()
    public void add(T t) throws ExceptionQueueFull {
        if (isFull())
            throw new ExceptionQueueFull();
        queue[nextAdd] = t;
        nextAdd = ++nextAdd % bufferSize;
        count++;
    }

    @TraceAnnotation()
    public T remove() throws ExceptionQueueEmpty {
        if (isEmpty())
            throw new ExceptionQueueEmpty();

        T removed = queue[nextRemove];
        nextRemove = ++nextRemove % bufferSize;
        count--;
        return removed;
    }

    @TraceAnnotation()
    public boolean isFull() {
      return count == bufferSize;
    }

    @TraceAnnotation()
    public boolean isEmpty() {
        return count == 0;
    }

    @TraceAnnotation()
    public void clear() {
        nextAdd = nextRemove = count = 0;
    }
}
