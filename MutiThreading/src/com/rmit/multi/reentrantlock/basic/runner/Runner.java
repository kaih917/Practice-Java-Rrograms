package com.rmit.multi.reentrantlock.basic.runner;

import com.rmit.multi.reentrantlock.basic.IntLock.IntLock;

import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock r1 = new ReentrantLock();
        ReentrantLock r2 = new ReentrantLock();

        IntLock il1 = new IntLock(1,r1,r2);
        IntLock il2 = new IntLock(1,r1,r2);

        Thread t1 = new Thread(il1);
        Thread t2 = new Thread(il2);

        t1.start();
        t2.start();

        Thread.sleep(5000);
        t2.interrupt();
    }
}
