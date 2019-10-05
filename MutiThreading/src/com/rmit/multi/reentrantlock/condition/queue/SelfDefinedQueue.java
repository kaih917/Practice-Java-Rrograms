package com.rmit.multi.reentrantlock.condition.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SelfDefinedQueue{
    Object[] items = new Object[10];

    private ReentrantLock lock;
    private Condition notEmpty;
    private Condition notFull;
    private int count;

    private int takeIndex;
    private int putIndex;

    public void add(Object obj) throws InterruptedException {
        if(obj == null)
            throw new NullPointerException();

        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;

        lock.lockInterruptibly();
        try {
            try {
                while (this.count == items.length)
                    notFull.await();
            } catch (InterruptedException e) {
                notFull.signal();
                e.printStackTrace();
            }
            insert(obj);
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();

        try{
            try{
                while(this.count == 0)
                    notEmpty.await();
            } catch (InterruptedException e) {
                notEmpty.signal();
                e.printStackTrace();
            }
            Object obj = extract();
            return obj;
        }finally {
            lock.unlock();
        }
    }

    public Object extract(){
        final Object[] items = this.items;
        Object obj = items[takeIndex];
        takeIndex--;
        count--;
        notFull.signal();
        return obj;
    }

    public void insert(Object object){
        items[putIndex] = object;
        putIndex++;
        count++;
        notFull.signal();
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public Condition getNotEmpty() {
        return notEmpty;
    }

    public void setNotEmpty(Condition notEmpty) {
        this.notEmpty = notEmpty;
    }

    public Condition getNotFull() {
        return notFull;
    }

    public void setNotFull(Condition notFull) {
        this.notFull = notFull;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPutIndex() {
        return putIndex;
    }

    public void setPutIndex(int putIndex) {
        this.putIndex = putIndex;
    }

    public int getTakeIndex() {
        return takeIndex;
    }

    public void setTakeIndex(int takeIndex) {
        this.takeIndex = takeIndex;
    }
}
