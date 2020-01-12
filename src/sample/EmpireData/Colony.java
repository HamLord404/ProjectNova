package sample.EmpireData;

import sample.Enums.Effect;
import sample.Enums.Job;
import sample.Enums.TraitEnum;
import sample.GalaxyData.Planet;

import java.util.ArrayList;
import java.util.Random;

public class Colony {

    private ArrayList<Pop> pops = new ArrayList<>();
    private ArrayList<Improvement> improvements = new ArrayList<Improvement>();
    private Planet planet;
    private int growthProgress;
    final int growthThreshold = 300;
    private int productionProgress;



    public Colony(Planet planet){
        this.planet = planet;
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
            addPop(CalculateNewPopToGrow(),1);
            growthProgress = 0;
        }

        e.addScience(science);



        //TODO::Do production stuff
        //if(productionProgress >= ){

        //}

    }

    public Species CalculateNewPopToGrow(){
        Species species;
        Random r = new Random();
        int index = r.nextInt(pops.size());
        species = pops.get(index).getSpecies();


        return species;
    }

    public void GrowBorders(){

    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
