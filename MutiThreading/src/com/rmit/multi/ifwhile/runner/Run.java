package com.rmit.multi.ifwhile.runner;

import com.rmit.multi.ifwhile.services.Add;
import com.rmit.multi.ifwhile.services.Subtract;
import com.rmit.multi.ifwhile.threads.ThreadAdd;
import com.rmit.multi.ifwhile.threads.ThreadSubtract;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        String lock = new String("");

        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        ThreadSubtract subtract1Thread = new ThreadSubtract(subtract);
        subtract1Thread.setName("subtract1Thread");
        subtract1Thread.start();

        ThreadSubtract subtract2Thread = new ThreadSubtract(subtract);
        subtract2Thread.setName("subtract2Thread");
        subtract2Thread.start();

        Thread.sleep(1000);

        ThreadAdd addThread1 = new ThreadAdd(add);
        ThreadAdd addThread2 = new ThreadAdd(add);

        addThread1.setName("addThread1");
        addThread1.start();

        addThread2.setName("addThread2");
        addThread2.start();

    }
}
