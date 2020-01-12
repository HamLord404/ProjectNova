package sample;

import sample.Enums.Ideology;

public class PoliticalParty {
    private String name;
    private Ideology ideology;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ideology getIdeology() {
        return ideology;
    }

    public void setIdeology(Ideology ideology) {
        this.ideology = ideology;
    }
}
