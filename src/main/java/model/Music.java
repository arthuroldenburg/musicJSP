package model;

public class Music {
    private int ID;
    private String name;
    private double duration;

    public Music(int ID, String name, double duration) {
        this.ID = ID;
        this.name = name;
        this.duration = duration;
    }

    public Music(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
