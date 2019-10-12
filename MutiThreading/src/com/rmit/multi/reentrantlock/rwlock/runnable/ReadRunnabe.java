package com.rmit.multi.reentrantlock.rwlock.runnable;

import com.rmit.multi.reentrantlock.rwlock.demo.ReadWriteLockDemo;

public class ReadRunnabe implements Runnable{

    private ReadWriteLockDemo demo;

    @Override
    public void run() {
        try {
            demo.handleRead();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ReadWriteLockDemo getDemo() {
        return demo;
    }

    public void setDemo(ReadWriteLockDemo demo) {
        this.demo = demo;
    }
}
