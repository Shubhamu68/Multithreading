package com.company;

import com.company.demos.MultithreadingDemo.MultithreadingDemo;
import com.company.demos.ThreadInterruption.ThreadInterruptionConcept;
import com.company.demos.ThreadJoiningConcept;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose the topic..!!!");
        System.out.println("1. Multithreading Demo.\n2. Thread Interruption Concepts.");
        int choice = sc.nextInt();
        Thread t;
        switch (choice) {
            case 1:
                t = new Thread(new MultithreadingDemo());
                t.setName("DemoThread");
                t.start();
                break;
            case 2:
                t = new Thread(new ThreadInterruptionConcept(2));
                t.start();
                t.interrupt();
                break;
            case 3:
                t= new Thread(new ThreadJoiningConcept());
                t.start();
                t.interrupt();
                break;
        }
    }
}