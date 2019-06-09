package com.rmit.multi.wait.threads;

public class ChangeObjectThread extends Thread {
    private volatile boolean suspendStatus = false;
    private final Object user;

    public ChangeObjectThread(Object user){
        super();
        this.user = user;
    }

    public void suspendMe(){
        this.suspendStatus = true;
    }

    public void resumeMe(){
        this.suspendStatus = false;

        synchronized (this) {
            notify();
        }
    }

    public void run(){
        while(true){

            synchronized (this){
                while(this.suspendStatus){
                    try{
                        wait();
                    }catch (InterruptedException e){
                        Thread.currentThread().interrupt(); // Here!
                        throw new RuntimeException(e);
                    }
                }
            }

            synchronized (user){
                System.out.println("In ChangeObjectThread");
            }

            Thread.yield();
        }
    }
}
