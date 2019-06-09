package com.rmit.multi.wait.runner;

import com.rmit.multi.wait.threads.ChangeObjectThread;
import com.rmit.multi.wait.threads.ReadObjectThread;

public class runner {
    public static Object user = new Object();

    public static void main(String[] args) throws InterruptedException{

        ChangeObjectThread t1 = new ChangeObjectThread(user);
        ReadObjectThread t2 = new ReadObjectThread();

        t1.start();
        t2.start();

        Thread.sleep(20000);

        t1.suspendMe();

        System.out.println("T1 suspended");

        Thread.sleep(20000);

        System.out.println("Resume t1");

        t1.resumeMe();
    }
}
