package sample.EmpireData;

import sample.Enums.TraitEnum;

import java.util.ArrayList;

public class Species {
    private String name;
    private ArrayList<TraitEnum> traits = new ArrayList<>();

    public int getFoodBonus(){
        int foodBonus = 0;
        if(traits.contains(TraitEnum.FOOD_MINUS_1)){
            foodBonus = -1;
        }
        if(traits.contains(TraitEnum.FOOD_PLUS_1)){
            foodBonus = 1;
        }
        if(traits.contains(TraitEnum.FOOD_PLUS_2)){
            foodBonus = 2;
        }
        return foodBonus;
    }

    public int getProductionBonus(){
        int productionBonus = 0;
        if(traits.contains(TraitEnum.PROD_MINUS_1)){
            productionBonus = -1;
        }
        if(traits.contains(TraitEnum.PROD_PLUS_1)){
            productionBonus = 1;
        }
        if(traits.contains(TraitEnum.PROD_PLUS_2)){
            productionBonus = 2;
        }
        return productionBonus;
    }

    public int getScienceBonus(){
        int scienceBonus = 0;
        if(traits.contains(TraitEnum.SCI_MINUS_1)){
            scienceBonus = -1;
        }
        if(traits.contains(TraitEnum.SCI_PLUS_1)){
            scienceBonus = 1;
        }
        if(traits.contains(TraitEnum.SCI_PLUS_2)){
            scienceBonus = 2;
        }
        return scienceBonus;
    }

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
