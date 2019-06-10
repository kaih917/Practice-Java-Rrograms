package com.rmit.multi.reentrantlock.fair.FairLock;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {
    private ReentrantLock lock;

    @Override
    public void run() {
        while(true){
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getId() + "Lock acquired.");
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                System.out.println(Thread.currentThread().getId() + "Lock released.");
                lock.unlock();
            }
        }
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }
}
