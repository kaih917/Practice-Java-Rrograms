package com.rmit.multi.countdown.countdowndemo;

import java.util.concurrent.CountDownLatch;

public class CdlDemo implements Runnable {
    private CountDownLatch cdl;

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " check completed.");
            cdl.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public CountDownLatch getCdl() {
        return cdl;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }
}
