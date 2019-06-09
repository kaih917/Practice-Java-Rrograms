package com.rmit.multi.ifwhile.services;

import com.rmit.multi.ifwhile.infra.ValueObject;

public class Add {

    private String lock;
    public Add(String lock) {
        super();
        this.lock = lock;
    }

    public void add() {
        while(true){
            synchronized (lock) {
                while(ValueObject.list.size() == 0){
                    ValueObject.list.add("anyString");
                    lock.notifyAll();
                }
//                Thread.yield();
            }
        }

    }
}


