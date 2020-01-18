package sample.EmpireData;

import sample.Enums.BuildType;

public class Buildable {
    private String name;
    private BuildType buildableType;
    private int productionCost;
    private int maintenanceCost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildType getBuildableType() {
        return buildableType;
    }

    public void setBuildableType(BuildType buildableType) {
        this.buildableType = buildableType;
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
