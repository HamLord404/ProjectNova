package sample.GalaxyData;

import sample.Enums.Biome;
import sample.Enums.Gravity;
import sample.Enums.Temperature;

import java.util.Random;

public class Planet {
    private int populationCap;
    private String name;
    private Gravity grav;
    private Temperature temp;
    private Biome biome;
    private boolean colonised = false;
    private int foodYeild = 2;
    private int scienceYeild = 2;
    private int productionYeild = 2;
    private int creditYeild = 2;

    public Planet(){

    }

    public static Planet generatePlanet(){
        Planet newPlanet = new Planet();

        Random r = new Random();
        newPlanet.biome = Biome.values()[r.nextInt(Biome.values().length)];
        newPlanet.grav = Gravity.values()[r.nextInt(Gravity.values().length)];
        newPlanet.temp = Temperature.values()[r.nextInt(Temperature.values().length)];
        newPlanet.name = generatePlanetName();


        return newPlanet;
    }


    public static String generatePlanetName(){
        String prefix[] = {"Gla","Vol","Fort","Pol","Gal","Jin","Wei","Nov","Hi","Tre","Ely","Era","Aral","Oru","Una"};
        String suffix[] = {"lix","lon","lux","tron","yuu","dur","bit","num","dol","rule","sia","tia","shun","con"};
        Random r = new Random();
        String name = prefix[r.nextInt(prefix.length)] + suffix[r.nextInt(suffix.length)];

        return name;
    }

    public int getFoodYeild() {
        return foodYeild;
    }

    public void setFoodYeild(int foodYeild) {
        this.foodYeild = foodYeild;
    }

    public int getScienceYeild() {
        return scienceYeild;
    }

    public void setScienceYeild(int scienceYeild) {
        this.scienceYeild = scienceYeild;
    }

    public int getProductionYeild() {
        return productionYeild;
    }

    public void setProductionYeild(int productionYeild) {
        this.productionYeild = productionYeild;
    }

    public int getCreditYeild() {
        return creditYeild;
    }

    public void setCreditYeild(int creditYeild) {
        this.creditYeild = creditYeild;
    }

    public boolean isColonised() {
        return colonised;
    }

    public void setColonised(boolean colonised) {
        this.colonised = colonised;
    }

    public int getPopulationCap() {
        return populationCap;
    }

    public void setPopulationCap(int populationCap) {
        this.populationCap = populationCap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gravity getGrav() {
        return grav;
    }

    public void setGrav(Gravity grav) {
        this.grav = grav;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public Biome getBiome() {
        return biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }
}
