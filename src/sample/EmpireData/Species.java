package sample.EmpireData;

import sample.Enums.TraitEnum;

import java.util.ArrayList;

public class Species {
    private String name;
    private ArrayList<TraitEnum> traits = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TraitEnum> getTraits() {
        return traits;
    }

    public void setTraits(ArrayList<TraitEnum> traits) {
        this.traits = traits;
    }
}
