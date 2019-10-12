package com.rmit.multi.reentrantlock.rwlock.runnable;

import com.rmit.multi.reentrantlock.rwlock.demo.ReadWriteLockDemo;

import java.util.Random;

public class WriteRunnable implements Runnable {
    private ReadWriteLockDemo demo;

    @Override
    public void run() {
        demo.handleWrite(new Random().nextInt());
    }

    public ReadWriteLockDemo getDemo() {
        return demo;
    }

    public void setDemo(ReadWriteLockDemo demo) {
        this.demo = demo;
    }
}
