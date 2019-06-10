package com.rmit.multi.ifwhile.threads;

import com.rmit.multi.ifwhile.services.Add;

public class ThreadAdd extends Thread {

    private Add p;

    public ThreadAdd(Add p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        p.add();
    }
}