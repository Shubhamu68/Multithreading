package com.company.demos.MultithreadingDemo;

import java.util.Scanner;

public class MultithreadingDemo implements Runnable{
    static CustomThreadSpawnImpl ob = new CustomThreadSpawnImpl();
    static long startTime;
    Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        System.out.println("\n\nDo you want to use multithreading concept..?? (y/n)");
        char flg = sc.nextLine().charAt(0);
        startTime = System.currentTimeMillis();
        if(flg=='y')
            withMultithreading();       //  flg=1
        else if(flg=='n')
            withoutMultithreading();    //  flg=2

        int counts;// = Thread.activeCount();
        while(true){
            counts = Thread.activeCount();
            if(counts <= 4)
                break;
        }
        printTotalTime();
    }

    private static void printTotalTime() {
        long endTime = System.currentTimeMillis();
        System.out.println(new StringBuilder().append("Total time taken is : ").append(endTime - startTime).append(" seconds.").toString());
    }

    private static void withoutMultithreading() {
        System.out.println("This will NOT make use of multithreading concept..!!!");

        ComplexService service = new ComplexService();
        service.invokeFirstService();
        service.invokeSecondService();
        service.invokeThirdService();
    }

    private static void withMultithreading() {
        System.out.println("\n\nThis will make use of multithreading concept..!!!");
        ob.invokeServices();
    }
}
