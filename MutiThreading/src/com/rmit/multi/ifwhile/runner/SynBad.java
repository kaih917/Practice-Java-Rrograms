package com.rmit.multi.ifwhile.runner;

import java.util.HashMap;

public class SynBad implements Runnable {
    static int i = 0;

    public static synchronized void increase(){
        i++;
    }

    public void run(){
        for(int j = 0 ; j < 10000; j++){
            increase();
        }
    }

    public static void main (String[] args) throws InterruptedException{
        Thread t1 = new Thread(new SynBad());
        Thread t2 = new Thread(new SynBad());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("HaHa",100);
    }
}
