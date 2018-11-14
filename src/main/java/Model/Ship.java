package Model;

import java.util.concurrent.locks.ReentrantLock;
import java.math.*;

public class Ship implements Runnable {


    private static int i=0;
     private Dock dock;
     private ReentrantLock locker;
     private int containers=100;

    public void run() {
        locker.lock();
        try {
            dock.x = 1;
            for (int i = 1; i < 5; i++) {
//                System.out.printf("%s %d \n", Thread.currentThread().getName(), dock.x);
//                dock.x++;
//                Thread.sleep(100);


                System.out.println("--------------------");
                double choice = (Math.random()) * 10;
                int rand = 0;
//            System.out.println(choice);
                System.out.println("Ship " + Thread.currentThread().getName() + " is started");
//            Thread.sleep(1000);

                if ((choice > 0) && (choice <= 3)) {
                    Thread.sleep(1000);
                    rand = (int) ((Math.random()) * 10 + 30);
//                System.out.println("Ship "+this.getName()+" is loading "+rand+" containers");
                    System.out.println("Ship " + Thread.currentThread().getName() + " is loading " + rand + " containers");
                    load(rand);

                }
                if ((choice > 3) && (choice <= 6)) {
                    Thread.sleep(1000);
                    rand = (int) ((Math.random()) * 10 + 30);
//                System.out.println("Ship "+this.getName()+" is unloading "+rand+" containers");
                    System.out.println("Ship " + Thread.currentThread().getName() + " is loading " + rand + " containers");
                    unload(rand);

                }
                if ((choice > 6) && (choice <= 10)) {
                    Thread.sleep(1000);
                    rand = (int) ((Math.random()) * 10 + 30);
//                System.out.println("Ship "+this.getName()+" is loading "+rand+" containers");
                    System.out.println("Ship " + Thread.currentThread().getName() + " is loading " + rand + " containers");
                    load(rand);

                    rand = (int) ((Math.random()) * 10 + 30);
                    System.out.println("Ship " + Thread.currentThread().getName() + " is unloading " + rand + " containers");
//                System.out.println("Ship "+this.getName()+" is unloading "+rand+" containers");
                    unload(rand);
                }


            }
        }
        catch(InterruptedException e){
                e.printStackTrace();
            }
        finally{
                System.out.println("Ship " + Thread.currentThread().getName() + " is finished");
                locker.unlock();
            }

    }




    public Ship(Dock dock, ReentrantLock locker){
//        System.out.println("FROM CONSTRUCTOR "+Thread.currentThread().getName());
        this.dock=dock;
        this.locker=locker;
//        this.locker=new ReentrantLock();
        Thread t=new Thread(this);
        t.setName("Ship "+i);
        System.out.println("iterator before "+i);
        i++;
        System.out.println("iterator after "+i);
        t.start();



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
