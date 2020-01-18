package sample.EmpireData;

import sample.Enums.ShipClass;

public class Ship extends Buildable{
    private String name;
    private ShipClass shipClass;
    private double speed;
    private double hp = 100;
    private double weapons;
    private double shields;
    private double armour;
    private double agility;
    private double morale;
    private int movement;
    private double xp;
    private int level;
    private Ship target;


    public Ship(){

    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public void assignTarget(Ship target){
        this.target = target;
    }

    public ShipClass getShipClass() {
        return shipClass;
    }

    public void setShipClass(ShipClass shipClass) {
        this.shipClass = shipClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getWeapons() {
        return weapons;
    }

    public void setWeapons(double weapons) {
        this.weapons = weapons;
    }

    public double getShields() {
        return shields;
    }

    public void setShields(double shields) {
        this.shields = shields;
    }

    public double getArmour() {
        return armour;
    }

    public void setArmour(double armour) {
        this.armour = armour;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getMorale() {
        return morale;
    }

    public void setMorale(double morale) {
        this.morale = morale;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Ship getTarget() {
        return target;
    }

    public void setTarget(Ship target) {
        this.target = target;
    }
}
