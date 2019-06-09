package com.rmit.multi.ifwhile.services;

import com.rmit.multi.ifwhile.infra.ValueObject;

public class Subtract {

    private String lock;

    public Subtract(String lock) {
        super();
        this.lock = lock;
    }

    public void subtract() {
        try {
            while(true){
                synchronized (lock) {
                    while (ValueObject.list.size() == 0) {
                        System.out.println("wait begin ThreadName="
                                + Thread.currentThread().getName());
                        lock.wait();
                        System.out.println("wait   end ThreadName="
                                + Thread.currentThread().getName());
                    }

                }

                synchronized (ValueObject.list) {
                    ValueObject.list.remove(0);
                    System.out.println("list size=" + ValueObject.list.size());
                }
//                Thread.yield();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
