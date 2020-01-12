package sample.GalaxyData;

import sample.Enums.Tech;

import java.util.ArrayList;

public class Technology {
    private String name;
    private Tech tech;
    private ArrayList<Technology> prereqs = new ArrayList<>();

    public Technology(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tech getTech() {
        return tech;
    }

    public void setTech(Tech tech) {
        this.tech = tech;
    }

    public ArrayList<Technology> getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(ArrayList<Technology> prereqs) {
        this.prereqs = prereqs;
    }
}
