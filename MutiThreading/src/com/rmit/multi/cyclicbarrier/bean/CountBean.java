package com.rmit.multi.cyclicbarrier.bean;

public class CountBean {
    private int sum = 0;

    public CountBean(){
        sum = 0;
    }

    public void add(){
        sum++;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
