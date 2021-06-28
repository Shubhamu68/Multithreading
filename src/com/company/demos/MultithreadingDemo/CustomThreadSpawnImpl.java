package com.company.demos.MultithreadingDemo;

public class CustomThreadSpawnImpl implements Runnable {

    private static int poolsize=1;
    ComplexService service = new ComplexService();

    public CustomThreadSpawnImpl() {
        System.out.println("Custom Thread spawn class is invoked..!!!");
    }

    public int getPoolsize() {
        return getSizeFromConfig();
    }

    private int getSizeFromConfig() {
        try{
            poolsize=3;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return poolsize;
    }

    public static void setPoolsize(int poolsize) {
        CustomThreadSpawnImpl.poolsize = poolsize;
    }

    public void invokeServices() {
        System.out.println("The thread spawning will now start to call different services. " +
                "\n Number of threads that will be spawned is : " + getPoolsize() + "" +
                "\n Threads will be spawned by : " + Thread.currentThread().getName());
        for(int iter=0;iter<poolsize;iter++){
            Thread t = new Thread(this);
            t.start();
        }
    }

    //      this method will ensure that Thread-1 executes service 1, thread-2 executes service 2 and thread-3 executes service 3.
    @Override
    public void run() {
        //System.out.println("Inside run method.." + Thread.currentThread().getName());
            switch (Thread.currentThread().getName()){
                case "Thread-1":
                    service.invokeFirstService();
                    break;
                case "Thread-2":
                    service.invokeSecondService();
                    break;
                case "Thread-3":
                    service.invokeThirdService();
        }
    }
}
