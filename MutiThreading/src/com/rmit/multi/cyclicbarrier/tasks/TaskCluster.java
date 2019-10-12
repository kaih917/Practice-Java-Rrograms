package com.rmit.multi.cyclicbarrier.tasks;

import com.rmit.multi.cyclicbarrier.bean.CountBean;

public class TaskCluster implements Runnable {
    private boolean flag;
    private int n;
    private CountBean sum;

    public TaskCluster(boolean flag, int n, CountBean bean){
        this.flag = flag;
        this.n = n;
        this.sum = bean;
    }

    @Override
    public void run() {
        if(flag){
            System.out.println(n + " tasks completed.");
            System.out.println("Sum is " + sum.getSum());
        }else{
            System.out.println("Sum is " + sum.getSum());
            System.out.println(n + " tasks assembled.");
            flag = true;
        }
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
