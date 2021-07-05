package com.company.demos.ThreadInterruption;

public class ThreadInterruptionConcept implements Runnable{

    int inp=0;
    public ThreadInterruptionConcept(int inp){
        this.inp = inp;
    }

    @Override
    public void run() {
        if(inp == 1)
            interruptOne();
        else
            interruptTwo();
    }

    private void interruptTwo() {
        //      a long task
        int j = Integer.MIN_VALUE;
        for(int i=Integer.MIN_VALUE;i<Integer.MAX_VALUE;i++){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Thread - " + Thread.currentThread().getName() + " is interrupted.Stopping the execution...");
                return;
            }
            j++;
        }
        System.out.println("Task is successfully completed.");
    }

    private void interruptOne() {
        try {
            Thread.sleep(200000000);
        } catch (InterruptedException e) {
            System.out.println("Sleep is interrupted. THread is going to exit.!!");
        }
    }
}
