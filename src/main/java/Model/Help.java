package Model;

import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;


public class Help {

    public void portWorking() {

        Port port = new Port(3000);
        ReentrantLock locker = new ReentrantLock();
        ReentrantLock locker2 = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Ship(port.getDock1(), locker));
            t.setName("Ship " + i);
            t.start();

            Thread t2 = new Thread(new Ship(port.getDock2(), locker2));
            t2.setName("Ship 1" + i);
            t2.start();
        }
    }
}
