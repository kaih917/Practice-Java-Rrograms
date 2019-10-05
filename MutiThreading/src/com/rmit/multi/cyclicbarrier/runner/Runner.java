package com.rmit.multi.cyclicbarrier.runner;

import com.rmit.multi.cyclicbarrier.bean.CountBean;
import com.rmit.multi.cyclicbarrier.service.ProtoService;
import com.rmit.multi.cyclicbarrier.service.SecondServie;
import com.rmit.multi.cyclicbarrier.tasks.TaskCluster;

import java.util.concurrent.CyclicBarrier;

public class Runner {

    static int sum = 0;

    public static void main(String[] args){
        CountBean beam = new CountBean();

        int n = 100000;
        Thread[] allTasks = new Thread[n];

        boolean flag = false;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(n, new TaskCluster(flag, n, beam));

        System.out.println("Tasks start in progress.");

        for(int i = 0; i < 100000 ; i++){
            allTasks[i] = new Thread(new ProtoService("Servie " + i ,cyclicBarrier, beam));
            allTasks[i].start();
        }

//        allTasks[99999] = new Thread(new SecondServie("Servie " + 9 ,cyclicBarrier, beam));
//        allTasks[99999].start();

        System.out.println("Sum is " + beam.getSum());
    }
}
