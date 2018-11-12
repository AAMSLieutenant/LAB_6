package Model;


import java.util.ArrayList;

public class Help {

    public void portWorking(){

        Port port=new Port(3000);
        for(int i=0;i<4;i++){
            Thread t=new Thread(new Ship(port.getDock1()));
            t.setName("Ship № "+i);
            t.start();

            Thread t2=new Thread(new Ship(port.getDock2()));
            t2.setName("Ship № "+i+10);
            t2.start();
        }

//        Thread t=new Thread(new Ship(port.getDock1()));
//        t.setName("Ship № "+1);
//        t.start();

    }
}
