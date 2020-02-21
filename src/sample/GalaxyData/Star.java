package sample.GalaxyData;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class Star {


    private StarType type = StarType.NONE;
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    private ImageView sprite = new ImageView();

    private int x;
    private int y;


    public Star(Pane root,int x,int y){
        root.getChildren().add(sprite);

        this.x = x;
        this.y = y;
    }

    public Star(Pane root,StarType type,int x,int y){
        sprite.setImage(new Image("tile_star.png"));
        //root.getChildren().add(sprite);
        this.x = x;
        this.y = y;
        this.type = type;

        if(y % 2 == 0) {
            sprite.setTranslateX( (1.5*x) * sprite.getImage().getWidth());
            sprite.setTranslateY((y * (sprite.getImage().getHeight()/2))+35);
        } else {
            sprite.setTranslateX( (1.5*x) * sprite.getImage().getWidth() + (sprite.getImage().getWidth()*0.75));
            sprite.setTranslateY((y * (sprite.getImage().getHeight()/2))+35);
        }
        generatePlanet();

    }

    public void generatePlanet(){
        Random r = new Random();
        int numPlanet = r.nextInt(4) + 1;
        for(int i = 0; i < numPlanet; i++){
            planets.add(Planet.generatePlanet());
        }

    }

    public Star[] findNeighbours(Star[][] grid,int mapX,int mapY){
        Star[] neighbours = new Star[6];

        System.out.println("MapX: "+mapX + " MapY: " + mapY);

        if(y-2 >= 0){
            neighbours[0] = grid[x][y-2];
        } else{
            neighbours[0] = null;
        }
        if(y+2 < mapY){
            neighbours[1] = grid[x][y+2];
        } else{
            neighbours[1] = null;
        }

        if(y % 2 == 0){ //even

            if(y-1 >= 0){
                neighbours[2] = grid[x][y-1];
            } else{
                neighbours[2] = null;
            }

            if(y+1 < mapY){
                neighbours[3] = grid[x][y+1];
            } else{
                neighbours[3] = null;
            }

            if(x-1 >= 0 && y+1 < mapY){
                neighbours[4] = grid[x-1][y+1];
            } else{
                neighbours[4] = null;
            }

            if(x-1 >= 0 && y-1 >= 0){
                neighbours[5] = grid[x-1][y-1];
            } else{
                neighbours[5] = null;
            }

        }
        else{ //odd

            if(x+1 < mapX && y-1 >= 0){
                neighbours[2] = grid[x+1][y-1];
            } else{
                neighbours[2] = null;
            }

            if(x+1 < mapX && y+1 < mapY){
                neighbours[3] = grid[x+1][y+1];
            } else{
                neighbours[3] = null;
            }

            if(y+1 < mapY){
                neighbours[4] = grid[x][y+1];
            } else{
                neighbours[4] = null;
            }

            if(y-1 >= 0){
                neighbours[5] = grid[x][y-1];
            } else{
                neighbours[5] = null;
            }


        }
        return neighbours;
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

    public StarType getType() {
        return type;
    }

    public void setType(StarType type) {
        this.type = type;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    public ImageView getSprite() {
        return sprite;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }
}
