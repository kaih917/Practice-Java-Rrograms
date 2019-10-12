package com.rmit.multi.reentrantlock.rwlock.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteLockDemo {
    private ReadWriteLock rwLock;
    private int value;

    public ReadWriteLockDemo(ReadWriteLock rwLock){this.rwLock = rwLock;}

    public int handleRead() throws InterruptedException{
        try {
            getReadLock().lock();
            Thread.sleep(2000);
            System.out.println("Read in progress, value is " + value);
            return value;
        } finally {
            getReadLock().unlock();
        }
    }

    public void handleWrite(int index){
        try {
            getWriteLock().lock();
            Thread.sleep(2000);
            System.out.println("Before: Existing Value is " + value);
            value = index;
            System.out.println("After : Write in progress, value is " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            getWriteLock().unlock();
        }

    }

    public ReadWriteLock getRwLock() {
        return rwLock;
    }

    public void setRwLock(ReadWriteLock rwLock) {
        this.rwLock = rwLock;
    }

    public Lock getReadLock() {
        return rwLock.readLock();
    }

    public Lock getWriteLock() {
        return rwLock.writeLock();
    }
}
