package sample.EmpireData;

import sample.Enums.ImprovementType;

public class Improvement {
    private String name;
    private ImprovementType type;
    private int productionCost;
    private Modifier mod;


    public Modifier getMod() {
        return mod;
    }

    public void setMod(Modifier mod) {
        this.mod = mod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImprovementType getType() {
        return type;
    }

    public void setType(ImprovementType type) {
        this.type = type;
    }

    public int getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(int productionCost) {
        this.productionCost = productionCost;
    }
}
