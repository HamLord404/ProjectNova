package sample.Dictionaries;


import sample.EmpireData.Buildable;
import sample.EmpireData.Empire;
import sample.EmpireData.Improvement;
import sample.EmpireData.Ship;
import sample.Enums.BuildType;
import sample.Enums.Effect;
import sample.Enums.ShipClass;

public class BuildableDictionary {

    public static Buildable getBuildable(String s, Empire e){
        Buildable newbuildable = new Buildable();

        switch (s){
            case "Light Ship":
                newbuildable = buildShip("light",e);
            case "Heavy Ship":
                newbuildable = buildShip("heavy",e);
        }

        return newbuildable;
    }

    public static Ship buildShip(String s, Empire e){
        Ship newShip = new Ship();
        newShip.setMorale(100);
        switch(s){
            case "colony":
                newShip.setName("Colony Ship");
                newShip.setProductionCost(80);
                newShip.setShipClass(ShipClass.COLONISATION);
                newShip.setHp(10);
                newShip.setArmour(5 * e.searchForModifier(Effect.SHIP_ARMOUR));
                newShip.setAgility(3);
                newShip.setShields(1);
                newShip.setWeapons(1 * e.searchForModifier(Effect.SHIP_WEAPONS));
                newShip.setMovement(2);
            case "light":
                newShip.setName("Light Ship");
                newShip.setProductionCost(45);
                newShip.setShipClass(ShipClass.FRIGATE);
                newShip.setHp(50);
                newShip.setArmour(10 * e.searchForModifier(Effect.SHIP_ARMOUR));
                newShip.setAgility(15);
                newShip.setShields(5);
                newShip.setWeapons(8 * e.searchForModifier(Effect.SHIP_WEAPONS));
                newShip.setMovement(3);
                newShip.setLevel((int)e.searchForModifier(Effect.MILITARY_UNIT_LEVEL));
                newShip.setXp(0);
            case "heavy":
                newShip.setName("Heavy Ship");
                newShip.setProductionCost(150);
                newShip.setShipClass(ShipClass.BATTLESHIP);
                newShip.setHp(80);
                newShip.setArmour(20 * e.searchForModifier(Effect.SHIP_ARMOUR));
                newShip.setAgility(10);
                newShip.setShields(10);
                newShip.setWeapons(15 * e.searchForModifier(Effect.SHIP_WEAPONS));
                newShip.setMovement(2);
                newShip.setLevel((int)e.searchForModifier(Effect.MILITARY_UNIT_LEVEL));
                newShip.setXp(0);
        }


        return newShip;
    }

    public static Improvement buildImprovement(String s, Empire e){
        Improvement newImprovement = new Improvement();



        return newImprovement;
    }



    public static void makeThing(Buildable b,Empire e){

        switch (b.getBuildableType()){
            case SHIP:
                buildShip(b.getName(),e);
            case IMPROVEMENT:

            case TRADE:
        }
    }
}
