package Model;

import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;


public class Help {

    public void portWorking(){

        Port port=new Port(3000);
        ReentrantLock locker = new ReentrantLock(); // создаем заглушку
        ReentrantLock locker2 = new ReentrantLock();
        for (int i = 0; i < 2; i++){
            Thread t = new Thread(new Ship(port.getDock1(), locker));

//            t.start();
            System.out.println("SECOND THREADS");
            Thread t2 = new Thread(new Ship(port.getDock2(), locker2));

//            t2.start();

        }
//            for (int i = 0; i < 2; i++) {
//                Thread t = new Thread(new Ship(port.getDock1()));
////            t.setName("Thread 1 Ship № "+i);
//                System.out.println("FROM MAIN "+t.getName());
//                t.join();
////                t.start();
//
////            Thread t2=new Thread(new Ship(port.getDock2()));
////            t2.setName("Thread 2 Ship № "+i);
////                t2.join();
////            t2.start();
////                System.out.println("------------------------------");
//            }



//        Thread t=new Thread(new Ship(port.getDock1()));
//        t.setName("Ship № "+1);
//        t.start();

    }
}
