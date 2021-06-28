package com.company.demos.MultithreadingDemo;

public class ComplexService {

    public ComplexService() {
        System.out.println("The constructor of ComplexService is initialized by " + Thread.currentThread().getName() + " thread.");
    }
    Long sleepTime = 5000L;
    public void invokeFirstService(){

        System.out.println("Service-1 is invoked by " + Thread.currentThread().getName() + " ..!!! will take approx " + sleepTime/1000 + " seconds to execute");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void invokeSecondService() {
        System.out.println("Service-2 is invoked by " + Thread.currentThread().getName() + " ..!!! will take approx " + sleepTime/1000 + " seconds to execute");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void invokeThirdService() {
        System.out.println("Service-3 is invoked by " + Thread.currentThread().getName() + " ..!!! will take approx " + sleepTime/1000 + " seconds to execute");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}