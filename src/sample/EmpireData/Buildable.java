package sample.EmpireData;

import sample.Enums.BuildType;

public class Buildable {
    private String name;
    private BuildType type;
    private int productionCost;
    private int maintenanceCost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildType getType() {
        return type;
    }

    public void setType(BuildType type) {
        this.type = type;
    }

    public int getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(int productionCost) {
        this.productionCost = productionCost;
    }

    public int getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(int maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }
}
