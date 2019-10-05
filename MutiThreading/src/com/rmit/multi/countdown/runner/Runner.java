package com.rmit.multi.countdown.runner;

import com.rmit.multi.countdown.countdowndemo.CdlDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(10);
        CdlDemo demo = new CdlDemo();

        demo.setCdl(cdl);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++){
            executorService.submit(demo);
        }

        cdl.await();

        System.out.println("Checking all done.");
        executorService.shutdown();
    }
}
