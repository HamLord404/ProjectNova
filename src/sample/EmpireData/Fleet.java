package sample.EmpireData;

import sample.Enums.ShipClass;
import sample.Leader;

import java.util.ArrayList;

public class Fleet {
    private Empire loyalty;
    private Leader admiral;
    private ArrayList<Ship> ships = new ArrayList<>();
    private double morale = 100;
    private int x;
    private int y;


    public Fleet(Empire loyalty,int x,int y){
        this.loyalty = loyalty;
        this.x = x;
        this.y = y;

    }

    public void destroyShip(Ship ship){

        if(ship.getShipClass() == ShipClass.BATTLESHIP){
            morale = morale - 15;
        } else if(ship.getShipClass() == ShipClass.FRIGATE){
            morale = morale - 5;
        }

        ships.remove(ship);
    }

    public void addShip(Ship ship){
        ships.add(ship);
    }

    public Leader getAdmiral() {
        return admiral;
    }

    public void setAdmiral(Leader admiral) {
        this.admiral = admiral;
    }

    public double getMorale() {
        return morale;
    }

    public void setMorale(double morale) {
        this.morale = morale;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Empire getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(Empire loyalty) {
        this.loyalty = loyalty;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }
}
