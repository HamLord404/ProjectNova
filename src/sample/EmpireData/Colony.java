package sample.EmpireData;

import sample.Dictionaries.BuildableDictionary;
import sample.Enums.BuildType;
import sample.Enums.Effect;
import sample.Enums.Job;
import sample.Enums.TraitEnum;
import sample.GalaxyData.Galaxy;
import sample.GalaxyData.Planet;
import sample.GalaxyData.Star;
import sample.Screens.GalaxyScreen;

import java.util.ArrayList;
import java.util.Random;

public class Colony {

    private ArrayList<Pop> pops = new ArrayList<>();
    private ArrayList<Improvement> improvements = new ArrayList<Improvement>();
    private Planet planet;
    private int growthProgress;
    final int growthThreshold = 300;
    private int productionProgress;
    private Buildable currentConstruction;
    //private Star location;
    private int x;
    private int y;
    private int expandCount = 0;


    public Colony(Planet planet,int x,int y){
        this.planet = planet;
        this.x = x;
        this.y = y;
    }

    public void addPop(Species species, int popCount){
        for(int i = 0; i < popCount; i++) {
            pops.add(new Pop(species));
        }
    }

    public void turnTick(Empire e){
        double food = 0;
        double production = 0;
        double science = 0;
        double influence = 1;



        for(Pop p : pops){
            if(p.getJob() == Job.FARMER){
                food  += 3 + p.getSpecies().getFoodBonus();
            }
            if(p.getJob() == Job.WORKER){
                production  += 2 + p.getSpecies().getProductionBonus();
            }
            if(p.getJob() == Job.SCIENTIST){
                science += 2 + p.getSpecies().getScienceBonus();
            }
        }

        food *= e.searchForModifier(Effect.EMPIRE_FOOD);
        production *= e.searchForModifier(Effect.EMPIRE_PRODUCTION);
        science *= e.searchForModifier(Effect.EMPIRE_SCIENCE);

        //Pops consume food
        for (Pop p: pops){
            if(p.getSpecies().getTraits().contains(TraitEnum.CYBORG)){
                food -= 0.5;
            } else if(p.getSpecies().getTraits().contains(TraitEnum.MECHANICAL)){

            } else{
                food -= 1;
            }
        }

        //pops consume production

        growthProgress += food;

        productionProgress += production;
        if(growthProgress >= growthThreshold){
            addPop(CalculateNewPopToGrow(e),1);
            growthProgress = 0;
        }

        e.addScience(science);

        e.setInfluence(e.getInfluence()+influence);



        if(productionProgress >= currentConstruction.getProductionCost()){
            productionProgress = 0;
            finishProduction(e);
        }

    }

    public void finishProduction(Empire e){
        if(currentConstruction.getBuildableType() == BuildType.SHIP){
            ArrayList<Ship> ships = new ArrayList<>();
            ships.add((Ship)currentConstruction);
            //Fleet newFleet = new Fleet(e,x,y,ships);
            //e.getFleets().add(newFleet);
        }
    }

    public void expandBorders(Empire e,Galaxy g){
        
    }

    public void findFleetForShip(Ship ship,Empire e){
        for (Fleet f: e.getFleets()) {

        }
    }

    public int getTurnlyProduction(Empire e){
        int production = 0;
        for(Pop p : pops){

            if(p.getJob() == Job.WORKER){
                production  += 2 + p.getSpecies().getProductionBonus();
            }

        }

        production *= e.searchForModifier(Effect.EMPIRE_PRODUCTION);

        return production;
    }

    public int getTurnlyFood(Empire e){
        int food = 0;
        for(Pop p : pops){

            if(p.getJob() == Job.FARMER){
                food  += 2 + p.getSpecies().getFoodBonus();
            }

        }

        food *= e.searchForModifier(Effect.EMPIRE_FOOD);

        return food;
    }

    public int getTurnlyScience(Empire e){
        int science = 0;
        for(Pop p : pops){

            if(p.getJob() == Job.SCIENTIST){
                science  += 2 + p.getSpecies().getScienceBonus();
            }

        }

        science *= e.searchForModifier(Effect.EMPIRE_SCIENCE);

        return science;
    }

    public Species CalculateNewPopToGrow(Empire e){
        Species species;
        Random r = new Random();
        int index = r.nextInt(pops.size());
        species = pops.get(index).getSpecies();


        return species;
    }

    public void GrowBorders(){

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Buildable getCurrentConstruction() {
        return currentConstruction;
    }

    public void setCurrentConstruction(Buildable currentConstruction) {
        this.currentConstruction = currentConstruction;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
