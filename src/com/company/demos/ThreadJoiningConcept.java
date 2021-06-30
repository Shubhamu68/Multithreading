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
        List<Long> li = Arrays.asList(1212122L,5L,10L,20L,500L);
        List<FactorialCalculator> threads = new ArrayList<>();
        //      creating separate thread for each case
        for(Long l: li){
            threads.add(new FactorialCalculator(l));
        }

        //      starting all the threads
        for(Thread t: threads){
            //  making all threads daemon so that program execution can stop even if a thread is still calculating on some big number
            t.setDaemon(true);
            t.start();
        }

        //  to ensure that all the factorial threads will finish their execution by the time main thread finishes below loop
        for(Thread t: threads){
            //  to ensure a max time of 5 seconds for any factorial calculation...else will proceed with next calculation
            t.join(5000);
        }

        //      checking if threads have finished execution
        for(int i=0;i<li.size();i++){
            FactorialCalculator factorialCalculator = threads.get(i);
            if(factorialCalculator.isCompleted()){
                System.out.println("Factorial of " + li.get(i) + " is " + factorialCalculator.getResult());
            }else{
                System.out.println("Calculation for " + li.get(i) + " is still in progress..!!!");
            }
        }
    }
}
