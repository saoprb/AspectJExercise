package com.sao.aspectj.exercise.pojo;

/**
 * Created by saoprb on 12/13/2016.
 */
public class MainApp {
    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(new Integer(0), 20);

        try {
            circularQueue.add(new Integer(10));
        } catch (ExceptionQueueFull ex) {
            ex.printStackTrace();
        }
    }
}
