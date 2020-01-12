package sample.GalaxyData;

import sample.EmpireData.Fleet;
import sample.EmpireData.Ship;
import sample.Enums.Effect;

import java.util.Random;

public class Battle {
    private Fleet attacker;
    private Fleet defender;
    private Star location;


    public Battle(Fleet attacker, Fleet defender, Star location){
        this.attacker = attacker;
        this.defender = defender;
        this.location = location;
        playBattle();
    }

    public void playBattle(){
        while(attacker.getMorale() > 0 && defender.getMorale() > 0 && attacker.getShips().size() > 0 && defender.getShips().size() > 0){
            BattleRound();
        }

        if(attacker.getMorale() <= 0 && attacker.getShips().size() > 0){
            System.out.println("defender wins!");
        }

        if(defender.getMorale() <= 0 && defender.getShips().size() > 0){
            System.out.println("attacker wins!");
        }
    }

    public void BattleRound(){
        Random r = new Random();
        int attackerSize = attacker.getShips().size();
        int defenderSize = defender.getShips().size();

        for (Ship s: attacker.getShips()) {
            s.assignTarget(defender.getShips().get(r.nextInt(defenderSize)));
            attackTarget(s,s.getTarget(),attacker,defender);
        }

        for (Ship s: defender.getShips()) {
            s.assignTarget(attacker.getShips().get(r.nextInt(attackerSize)));
            attackTarget(s,s.getTarget(),defender,attacker);
        }

        System.out.println("Attacking Fleet ship count: " + attacker.getShips().size());
        System.out.println("Defending Fleet ship count: " + defender.getShips().size());


    }

    public void attackTarget(Ship attackingShip, Ship defendingShip,Fleet attackingFleet,Fleet defendingFleet){
        double weaponsModified = (attackingShip.getWeapons() * attacker.getLoyalty().searchForModifier(Effect.SHIP_WEAPONS));
        double armourModified = (defendingShip.getArmour() * defender.getLoyalty().searchForModifier(Effect.SHIP_ARMOUR));
        double damage = armourModified + weaponsModified;
        defendingShip.setHp(defendingShip.getHp()-damage);
        defendingShip.setMorale(defendingShip.getMorale()-(damage/2));



        if(defendingShip.getHp() <= 0){
            defendingFleet.destroyShip(defendingShip);

        }

    }

}
