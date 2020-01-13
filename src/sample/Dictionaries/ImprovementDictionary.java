package sample.Dictionaries;

import sample.EmpireData.Improvement;
import sample.EmpireData.Modifier;
import sample.Enums.ImprovementType;

public class ImprovementDictionary {
    public static Improvement makeImprovement(ImprovementType i){
        Improvement improvement = new Improvement();



        switch (i){
            case HYDROPONICS_FARMS:
                improvement.setName("Hydroponics Farms");
                improvement.setProductionCost(45);
            case FACTORY:
                improvement.setName("Factory");
                improvement.setProductionCost(45);
            case BARRACKS:
                improvement.setName("Barracks");
                improvement.setProductionCost(45);
            case ARCOLOGY:
                improvement.setName("Arcology");
                improvement.setProductionCost(125);
            case SHIPYARD:
                improvement.setName("Shipyard");
                improvement.setProductionCost(120);

        }

        improvement.setType(i);

        return improvement;

    }
}
