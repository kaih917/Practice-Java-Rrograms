package com.rmit.multi.reentrantlock.basic.IntLock;

import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable{

    private ReentrantLock r1;
    private ReentrantLock r2;
    private int lock;

    public IntLock(int lock, ReentrantLock  r1, ReentrantLock r2){
        this.lock = lock;
        this.r1 = r1;
        this.r2 = r2;
    }

    public void run(){
        try{
            if(lock == 1){
                r1.lockInterruptibly();
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r2.lockInterruptibly();
            }else{
                r2.lockInterruptibly();
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(r1.isHeldByCurrentThread()){
                r1.unlock();
            }
            if(r2.isHeldByCurrentThread()){
                r2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + " is out ");
        }
    }

    public ReentrantLock getR1() {
        return r1;
    }

    public void setR1(ReentrantLock r1) {
        this.r1 = r1;
    }

    public ReentrantLock getR2() {
        return r2;
    }

    public void setR2(ReentrantLock r2) {
        this.r2 = r2;
    }
}
