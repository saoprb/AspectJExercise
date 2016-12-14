package com.sao.aspectj.exercise.pojo;

/**
 * Created by saoprb on 12/14/2016.
 */
public class AppMain {

    public static void main(String[] args) {
        Foo foo = new Foo();
        Bar bar = new Bar();

        foo.printHelloWorld();
        bar.printHiThere();
    }
}
