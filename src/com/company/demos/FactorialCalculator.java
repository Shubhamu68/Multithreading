package com.company.demos;

import java.math.BigInteger;

public class FactorialCalculator extends Thread{

    private long input;
    private boolean isCompleted = false;
    private BigInteger result = BigInteger.ZERO;

    public boolean isCompleted() {
        return isCompleted;
    }

    public BigInteger getResult() {
        return result;
    }

    public FactorialCalculator(Long inp) {
        this.input = inp;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " has started execution..!!!");
        calculate();
    }

    private void calculate() {
        BigInteger temp = BigInteger.ONE;

        for(long i=1;i<=input;i++){
            temp = temp.multiply(new BigInteger(Long.toString(i)));
        }
        this.result = temp;
        this.isCompleted = true;
    }
}
