package sample.EmpireData;

import javafx.scene.effect.ColorAdjust;
import sample.Enums.Effect;
import sample.Enums.GovernmentType;
import sample.GalaxyData.Planet;
import sample.GalaxyData.Technology;
import sample.PoliticalParty;
import sample.GalaxyData.Star;
import java.util.ArrayList;

public class Empire {
    private String name;
    private GovernmentType government;
    private ArrayList<Star> territory = new ArrayList<>();
    private ArrayList<Colony> colonies = new ArrayList<>();
    private ArrayList<Modifier> modifiers = new ArrayList<Modifier>();
    private PoliticalParty rulingParty;
    private ArrayList<PoliticalParty> parties = new ArrayList<>();
    private Technology currentResearch;
    private double credits = 100;
    private int stability = 80;
    private int science = 0;
    private int influence = 0;
    private Species founders;
    private ArrayList<Fleet> fleets = new ArrayList<>();
    private ColorAdjust mapColor = new ColorAdjust();


    public Empire(String n,GovernmentType gov,Species f){
        name = n;
        government = gov;
        founders = f;


        mapColor.setHue(0.5);
        mapColor.setSaturation(1);
    }

    public void colonisePlanet(Planet planet){
        Colony c = new Colony(planet);
        colonies.add(c);
        c.addPop(founders, (int)searchForModifier(Effect.STARTING_COLONY_POP));
    }

    public void processTurn(){
        for (Colony c: colonies) {
            c.turnTick(this);
        }

    }

    public void addScience(double science){
        this.science += science;
        if(science >= currentResearch.getCost()){

        }
    }

    public double searchForModifier(Effect effect){
        double strengthTotal = 1; //1 is default to not mess up multipliers

        for(int i = 0; i < modifiers.size(); i++){
            if(modifiers.get(i).getEffect().equals(effect)){
                strengthTotal += modifiers.get(i).getStrength();
            }
        }

        return strengthTotal;
    }

    public void annexStar(Star star){
        territory.add(star);
    }

    public void createColor(double hue, double brightness, double saturation){
        mapColor.setHue(hue);
        mapColor.setBrightness(brightness);
        mapColor.setSaturation(saturation);
    }

    public Technology getCurrentResearch() {
        return currentResearch;
    }

    public void setCurrentResearch(Technology currentResearch) {
        this.currentResearch = currentResearch;
    }

    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }

    public int getStability() {
        return stability;
    }

    public void setStability(int stability) {
        this.stability = stability;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public ColorAdjust getMapColor() {
        return mapColor;
    }

    public void setMapColor(ColorAdjust mapColor) {
        this.mapColor = mapColor;
    }

    public Species getFounders() {
        return founders;
    }

    public void setFounders(Species founders) {
        this.founders = founders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GovernmentType getGovernment() {
        return government;
    }

    public void setGovernment(GovernmentType government) {
        this.government = government;
    }

    public ArrayList<Star> getTerritory() {
        return territory;
    }

    public void setTerritory(ArrayList<Star> territory) {
        this.territory = territory;
    }

    public ArrayList<Colony> getColonies() {
        return colonies;
    }

    public void setColonies(ArrayList<Colony> colonies) {
        this.colonies = colonies;
    }

    public ArrayList<Modifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(ArrayList<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public PoliticalParty getRulingParty() {
        return rulingParty;
    }

    public void setRulingParty(PoliticalParty rulingParty) {
        this.rulingParty = rulingParty;
    }

    public ArrayList<PoliticalParty> getParties() {
        return parties;
    }

    public void setParties(ArrayList<PoliticalParty> parties) {
        this.parties = parties;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public ArrayList<Fleet> getFleets() {
        return fleets;
    }

    public void setFleets(ArrayList<Fleet> fleets) {
        this.fleets = fleets;
    }
}
