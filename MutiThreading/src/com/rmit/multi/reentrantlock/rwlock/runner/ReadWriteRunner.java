package com.rmit.multi.reentrantlock.rwlock.runner;

import com.rmit.multi.reentrantlock.rwlock.demo.ReadWriteLockDemo;
import com.rmit.multi.reentrantlock.rwlock.runnable.ReadRunnabe;
import com.rmit.multi.reentrantlock.rwlock.runnable.WriteRunnable;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteRunner {

    public static void main(String[] args){
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReadWriteLockDemo rwDemo = new ReadWriteLockDemo(lock);

        for(int j = 0; j < 20; j++){
            WriteRunnable w = new WriteRunnable();
            w.setDemo(rwDemo);
            new Thread(w).start();
        }

        for(int i = 0; i < 18; i++){
            ReadRunnabe r = new ReadRunnabe();
            r.setDemo(rwDemo);
            new Thread(r).start();
        }

    }
}
