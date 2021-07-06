package com.company.demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadJoiningConcept implements Runnable {
    @Override
    public void run() {
        System.out.println("This will demonstrate the concept of Thread joining..!!");
        try {
            calculateFactorial();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void calculateFactorial() throws InterruptedException {
        //      calculate factorials of below integers
        List<Long> li = Arrays.asList(1212122L,5L,10L,20L,500L);
        //      each factorial will be calculated in a new thread
        List<FactorialCalculator> threads = new ArrayList<>();
        for(Long l: li){
            threads.add(new FactorialCalculator(l));
        }

        //      starting all the threads
        for(Thread t: threads){
            //  making all threads daemon so that program execution can stop even if a thread is still calculating on some big number
            t.setDaemon(true);
            t.start();
        }

        System.out.println("Current thread which is executing is " + Thread.currentThread().getName());
        System.out.println("This thread will wait a max of 5 seconds for each number's factorial calculation.");
        for(Thread t: threads){
            //  to ensure a max time of 5 seconds for any factorial calculation...else will proceed with next calculation
            //  if used without line - "t.setDaemon(true);" and 5 seconds has passed, next instruction will start to execute
            //  but the thread will keep running in background and will prevent the application from shutting down.
            t.join(5000);
        }

        //      checking if threads have finished execution
        for(int i=0;i<li.size();i++){
            FactorialCalculator factorialCalculator = threads.get(i);
            if(factorialCalculator.isCompleted()){
                System.out.println("Factorial of " + li.get(i) + " is " + factorialCalculator.getResult());
            }else{
                System.err.println("Calculation for " + li.get(i) + " is taking more time than allowed.. Exiting !!!");
            }
        }
    }
}
