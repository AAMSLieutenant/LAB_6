package Model;

import java.util.concurrent.locks.ReentrantLock;
import java.math.*;

public class Ship extends Thread {



     private Dock dock;
     private ReentrantLock locker;
     private int containers=100;

    public void run(){
        locker.lock();
        try{
            double choice=(Math.random())*10;
            int rand=0;
            System.out.println(choice);
            System.out.println("Ship "+this.getName()+" is started");
            if((choice>0)&&(choice<=3)){
                rand=(int)((Math.random())*10+30);
                System.out.println("Ship "+this.getName()+" is loading "+rand+" containers");
                load(rand);
                Thread.sleep(1000);
            }
            if((choice>3)&&(choice<=6)){
                rand=(int)((Math.random())*10+30);
                System.out.println("Ship "+this.getName()+" is unloading "+rand+" containers");
                unload(rand);
                Thread.sleep(1000);
            }
            if((choice>6)&&(choice<=10)){
                rand=(int)((Math.random())*10+30);
                System.out.println("Ship "+this.getName()+" is loading "+rand+" containers");
                load(rand);

                rand=(int)((Math.random())*10+30);
                System.out.println("Ship "+this.getName()+" is unloading "+rand+" containers");
                unload(rand);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
            locker.unlock();
        }
    }

    public Ship(Dock dock){
        this.dock=dock;
        locker=new ReentrantLock();



    }


    public void load(int containers){
        this.containers+=containers;
        this.dock.setContainers(this.dock.getContainers()-containers);
        System.out.println(this.containers+" are aboard");
        System.out.println(this.dock.getContainers()+" are in dock");

    }

    public void unload(int containers){
        this.containers-=containers;
        this.dock.setContainers(this.dock.getContainers()+containers);
        System.out.println(this.containers+" are aboard");
        System.out.println(this.dock.getContainers()+" are in dock");
    }
}
