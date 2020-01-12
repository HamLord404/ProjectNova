package sample.EmpireData;

import sample.Enums.Job;
import sample.GalaxyData.Planet;

import java.util.ArrayList;

public class Colony {

    private ArrayList<Pop> pops = new ArrayList<>();
    private Planet planet;
    private int growthProgress;
    private int productionProgress;



    public Colony(Planet planet){
        this.planet = planet;
    }

    public void addPop(Species species, int popCount){
        for(int i = 0; i < popCount; i++) {
            pops.add(new Pop(species));
        }
    }

    public void turnTick(){
        int food = 0;
        int production = 0;


        for(Pop p : pops){
            if(p.getJob() == Job.FARMER){
                //food  += 2+
            }
        }
    }

    public void GrowBorders(){

    }

}
