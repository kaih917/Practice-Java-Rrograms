package com.rmit.multi.ifwhile.threads;

import com.rmit.multi.ifwhile.services.Subtract;

public class ThreadSubtract extends Thread {

    private Subtract r;

    public ThreadSubtract(Subtract r) {
        super();
        this.r = r;
    }

    @Override
    public void run() {
        r.subtract();
    }
}