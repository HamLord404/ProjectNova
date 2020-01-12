package sample.EmpireData;

import sample.Enums.Effect;

public class Modifier {
    private double strength;
    private Effect effect;

    public Modifier(Effect effect, double strength){
        this.effect = effect;
        this.strength = strength;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }
}
