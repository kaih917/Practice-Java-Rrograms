package com.rmit.multi.wait.threads;

public class ReadObjectThread extends Thread {
    public void run(){
        while(true) {
            synchronized (this){
                System.out.println("In ReadObjectThread");
            }
            Thread.yield();

        }
    }

}
