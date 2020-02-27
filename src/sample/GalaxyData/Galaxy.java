package sample.GalaxyData;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Dictionaries.BuildableDictionary;
import sample.EmpireData.*;
import sample.Enums.GovernmentType;

import java.util.ArrayList;
import java.util.Random;

public class Galaxy {
    private ArrayList<Star> stars = new ArrayList<>();

    private ArrayList<Empire> empires = new ArrayList<>();

    int mapX = 12; //default value
    int mapY = 18; //default value

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

    public void annexStar(Star star,Empire e){
        e.getTerritory().add(star);

        Star[] neighbourTiles = star.findNeighbours(grid,mapX,mapY);

        for(int i = 0; i < neighbourTiles.length; i++){
            if(neighbourTiles[i] != null){
                e.claimTile(neighbourTiles[i]);
            }
        }
        e.colonisePlanet(star,star.getX(),star.getY());

    }

    public void spawnEmpire(Empire e,Planet p){

        empires.add(e);

        Random r = new Random();

        Star s = stars.get(r.nextInt(stars.size()));

        s.getPlanets().add(p);

        Colony homeworld = new Colony(s,s.getX(),s.getY());
        homeworld.addPop(e.getFounders(),5);
        e.getColonies().add(homeworld);
        p.setColonised(true);

        //Buildable testShip = BuildableDictionary.getBuildable("Light Ship",e);

        //ArrayList<Ship> ships = new ArrayList<Ship>();

        //ships.add((Ship)testShip);

        //Fleet f = new Fleet(e,s.getX(),s.getY(),ships,root);

        annexStar(s,e);

        Species testSpecies = new Species();
        Empire testEmpire = new Empire("The Alliance", GovernmentType.DEMOCRACY,testSpecies);
        ColorAdjust testColor = new ColorAdjust();
        testColor.setHue(0.8);
        testColor.setSaturation(1);
        testEmpire.setIcon(new Image("faction_4.png"));
        testEmpire.setMapColor(testColor);
        empires.add(testEmpire);


        Species testSpecies2 = new Species();
        Empire testEmpire2 = new Empire("The League", GovernmentType.OLIGARCHY,testSpecies);
        ColorAdjust testColor2 = new ColorAdjust();
        testColor2.setHue(0.1);
        testColor2.setSaturation(1);
        testEmpire2.setIcon(new Image("faction_2.png"));
        testEmpire2.setMapColor(testColor2);
        empires.add(testEmpire2);

        Species testSpecies3 = new Species();
        Empire testEmpire3 = new Empire("The Horde", GovernmentType.MONARCHY,testSpecies);
        ColorAdjust testColor3 = new ColorAdjust();
        testColor3.setHue(0.3);
        testColor3.setSaturation(1);
        testEmpire3.setIcon(new Image("faction_3.png"));
        testEmpire3.setMapColor(testColor3);
        empires.add(testEmpire3);

        s = stars.get(r.nextInt(stars.size()));
        annexStar(s,testEmpire);
        s = stars.get(r.nextInt(stars.size()));
        annexStar(s,testEmpire2);
        s = stars.get(r.nextInt(stars.size()));
        annexStar(s,testEmpire3);
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
