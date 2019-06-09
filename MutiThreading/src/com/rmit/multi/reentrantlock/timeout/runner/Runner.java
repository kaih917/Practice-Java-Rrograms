package com.rmit.multi.reentrantlock.timeout.runner;

import com.rmit.multi.reentrantlock.timeout.timelock.TimeLock;

import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args){
        ReentrantLock rl = new ReentrantLock();
        TimeLock tl = new TimeLock();
        tl.setLock(rl);

        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);

        t1.start();
        t2.start();
    }
}
