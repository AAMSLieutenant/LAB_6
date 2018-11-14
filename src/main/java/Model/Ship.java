package Model;

import Controller.Controller;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.concurrent.locks.ReentrantLock;
import java.math.*;

public class Ship implements Runnable {


     public boolean isTest=false;
     private Dock dock;
     private ReentrantLock locker;
     private int containers=100;

    private static final Logger log=Logger.getLogger(Ship.class);
    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    public void run() {
        log.info("Monitor locked");
        locker.lock();
        try {
            System.out.println("--------------------");
            double choice = (Math.random()) * 10;
            int rand = 0;
            log.info("Thread " + Thread.currentThread().getName() + " is started");
            System.out.println("Ship " + Thread.currentThread().getName() + " is started");

            if ((choice > 0) && (choice <= 3)) {
                Thread.sleep(1000);
                rand = (int) ((Math.random()) * 10 + 30);
                System.out.println("Ship " + Thread.currentThread().getName() + " is loading " + rand + " containers");
                load(rand);

            }
            if ((choice > 3) && (choice <= 6)) {
                Thread.sleep(1000);
                rand = (int) ((Math.random()) * 10 + 30);
                System.out.println("Ship " + Thread.currentThread().getName() + " is loading " + rand + " containers");
                unload(rand);

            }
            if ((choice > 6) && (choice <= 10)) {
                Thread.sleep(1000);
                rand = (int) ((Math.random()) * 10 + 30);
                System.out.println("Ship " + Thread.currentThread().getName() + " is loading " + rand + " containers");
                load(rand);

                rand = (int) ((Math.random()) * 10 + 30);
                System.out.println("Ship " + Thread.currentThread().getName() + " is unloading " + rand + " containers");
                unload(rand);
            }

        }
        catch(InterruptedException e){
                e.printStackTrace();
            }
        finally{
                System.out.println("Ship " + Thread.currentThread().getName() + " is finished");
                log.info("Thread "+Thread.currentThread().getName()+" is finished");
                locker.unlock();
                log.info("Monitor unlocked");

            }

    }




    public Ship(Dock dock, ReentrantLock locker){
        this.dock=dock;
        this.locker=locker;
        Thread t=new Thread(this);
    }


    public void load(int containers){
        System.out.println("Working with dock "+this.dock.getName()+": loading "+containers+" containers");
        this.containers+=containers;
        this.dock.setContainers(this.dock.getContainers()-containers);
        System.out.println(this.containers+" are aboard");
        System.out.println(this.dock.getContainers()+" are in dock");

    }

    public void unload(int containers){
        System.out.println("Working with dock "+this.dock.getName()+": loading "+containers+" containers");
        this.containers-=containers;
        this.dock.setContainers(this.dock.getContainers()+containers);
        System.out.println(this.containers+" are aboard");
        System.out.println(this.dock.getContainers()+" are in dock");
    }
}
