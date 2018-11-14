package Model;

public class Dock {

    private int containers;
    private String name;
    public int x;


    public int getContainers() {
        return containers;
    }

    public void setContainers(int containers) {
        this.containers = containers;
    }

    public Dock(int containers, String name){
        this.containers=containers;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
