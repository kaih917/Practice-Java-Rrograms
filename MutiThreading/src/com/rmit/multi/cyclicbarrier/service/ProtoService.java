package com.rmit.multi.cyclicbarrier.service;

import com.rmit.multi.cyclicbarrier.bean.CountBean;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ProtoService implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private String serviceName;
    private CountBean sum;

    public ProtoService (String serviceName, CyclicBarrier cyclicBarrier, CountBean sum) {
        this.serviceName = serviceName;
        this.cyclicBarrier = cyclicBarrier;
        this.sum = sum;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
            dowork();
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    public void dowork(){
//        try {
//            sum.add();
//            System.out.println(serviceName + " is going to start.");
//            Thread.sleep(Math.abs(10000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for(int i = 0; i < 5; i++){
            sum.add();
        }

//        System.out.println(serviceName + " completed. ");
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
