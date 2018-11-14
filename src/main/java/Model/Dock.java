package Model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dock dock = (Dock) o;
        return containers == dock.containers &&
                x == dock.x &&
                Objects.equals(name, dock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(containers, name, x);
    }
}
