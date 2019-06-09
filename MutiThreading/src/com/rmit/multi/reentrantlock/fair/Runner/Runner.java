package com.rmit.multi.reentrantlock.fair.Runner;

import com.rmit.multi.reentrantlock.fair.FairLock.FairLock;

import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock(true);

        FairLock f1 = new FairLock();
        f1.setLock(lock);

        Thread t1 = new Thread(f1, "Thread-One");
        Thread t2 = new Thread(f1, "Thread-Two");

        t1.start();
        t2.start();
    }
}
