package com.company.demos.MultithreadingDemo;

public class Employee extends Thread{

    Long ID;
    StringBuffer Name;
    StringBuffer City;

    public Employee() {
    }

    public Employee(Long ID, StringBuffer name, StringBuffer city) {
        this.ID = ID;
        Name = name;
        City = city;
    }
    @Override
    public void run(){
        dispThreadInfo();
    }

    public void dispThreadInfo(){

        System.out.println("The thread that is executing this is :" + Thread.currentThread().getName());
        System.out.println("The thread that is executing this is :" + Thread.currentThread().getPriority());
        Thread.currentThread().setName("Worker thread");
        System.out.println("The thread that is executing this is :" + Thread.currentThread().getName());

    }

}
