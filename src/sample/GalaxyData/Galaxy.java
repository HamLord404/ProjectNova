package sample.GalaxyData;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Dictionaries.BuildableDictionary;
import sample.EmpireData.*;

import java.util.ArrayList;
import java.util.Random;

public class Galaxy {
    private ArrayList<Star> stars = new ArrayList<>();

    private ArrayList<Empire> empires = new ArrayList<>();

    int mapX = 10; //default value
    int mapY = 10; //default value

    Pane root;

    Star[][] grid;

    public Galaxy(int mapX, int mapY,Pane root){
        grid = new Star[mapX][mapY];
        this.root = root;
        createGalaxy(mapX,mapY);
        mapX = mapX;
        mapY = mapY;
    }

    public void createGalaxy(int mapX, int mapY){
        for(int i = 0; i < mapX; i++){
            for(int j = 0; j < mapY; j++){

                Random r = new Random();

                if(r.nextInt(100) >= 80){
                    grid[i][j] = new Star(root,StarType.NORMAL,i,j);
                    stars.add(grid[i][j]);
                } else {
                    grid[i][j] = new Star(root,i,j);
                }

            }
        }


    }



    public void spawnEmpire(Empire e,Planet p){

        empires.add(e);

        Random r = new Random();

        Star s = stars.get(r.nextInt(stars.size()));

        s.getPlanets().add(p);

        Colony homeworld = new Colony(p,s.getX(),s.getY());
        homeworld.addPop(e.getFounders(),5);
        e.getColonies().add(homeworld);
        p.setColonised(true);

        //Buildable testShip = BuildableDictionary.getBuildable("Light Ship",e);

        //ArrayList<Ship> ships = new ArrayList<Ship>();

        //ships.add((Ship)testShip);

        //Fleet f = new Fleet(e,s.getX(),s.getY(),ships,root);

        e.annexStar(s);

    }

    public void processTurn(Empire e){

    }

    public ArrayList<Star> getStars() {
        return stars;
    }

    public void setStars(ArrayList<Star> stars) {
        this.stars = stars;
    }

    public ArrayList<Empire> getEmpires() {
        return empires;
    }

    public void setEmpires(ArrayList<Empire> empires) {
        this.empires = empires;
    }

    public int getMapX() {
        return mapX;
    }

    public void setMapX(int mapX) {
        this.mapX = mapX;
    }

    public int getMapY() {
        return mapY;
    }

    public void setMapY(int mapY) {
        this.mapY = mapY;
    }

    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }

    public Star[][] getGrid() {
        return grid;
    }

    public void setGrid(Star[][] grid) {
        this.grid = grid;
    }
}
