package Model;

public class Port {

    private int containers;

    private Dock dock1;
    private Dock dock2;


    public Port(int containers){
        this.containers=containers;
        dock1=new Dock(containers/2, "Dock 1");
        dock2=new Dock(containers/2, "Dock 2");
    }

    public Dock getDock1() {
        return dock1;
    }

    public void setDock1(Dock dock1) {
        this.dock1 = dock1;
    }

    public Dock getDock2() {
        return dock2;
    }

    public void setDock2(Dock dock2) {
        this.dock2 = dock2;
    }
}
