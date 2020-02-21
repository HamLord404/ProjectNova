package sample.Screens;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Dictionaries.BuildableDictionary;
import sample.EmpireData.Buildable;
import sample.EmpireData.Empire;
import sample.EmpireData.Fleet;
import sample.EmpireData.Ship;
import sample.FileManaging.GameSaver;
import sample.GalaxyData.Galaxy;
import sample.GalaxyData.Hex;
import sample.GalaxyData.Star;
import sample.GalaxyData.StarType;
import sample.UIElements.Button;



import java.io.IOException;
import java.util.ArrayList;


public class GalaxyScreen {



    int mapX = 12;
    int mapY = 18;

    Hex[][] grid = new Hex[mapX][mapY];
    Group hexes = new Group();
    Pane root = new Pane();
    public Galaxy galaxy = new Galaxy(mapX,mapY,root);
    Scene galaxyScene = new Scene(root,1000,700);

    ImageView background = new ImageView("space_bg.png");

    Button endTurn = new Button("End Turn",root,800,600);
    Button tech = new Button("Technology",root,640,600);
    Button government = new Button("Government",root,480,600);

    ImageView topBar = new ImageView("ui_8.png");
    ImageView GC = new ImageView("GC.png");
    Label creditCount = new Label();
    ImageView sci = new ImageView("SCI.png");
    Label scienceCount = new Label();
    ImageView stab = new ImageView("STAB.png");
    Label stabilityCount = new Label();
    ImageView inf = new ImageView("INF.png");
    Label influenceCount = new Label();

    Stage primaryStage;
    Empire empire;

    public GalaxyScreen(Stage s,Empire empire){
        this.empire = empire;
        generateHexGrid();
        updateHexGrid();
        galaxyScene.setOnKeyPressed(event -> {
            try {
                processHotkey(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        root.getChildren().add(background);
        background.toBack();

        topBar.setScaleX(0.33);
        topBar.setScaleY(0.33);
        topBar.setTranslateX(-(topBar.getImage().getWidth()/3) -10);
        topBar.setTranslateY(-(topBar.getImage().getHeight()/3));

        root.getChildren().add(topBar);
        root.getChildren().add(GC);
        root.getChildren().add(sci);
        root.getChildren().add(stab);
        root.getChildren().add(inf);

        endTurn.getSegmentGroup().setOnMouseClicked(this::endTurn);
        endTurn.getLabel().setOnMouseClicked(this::endTurn);


        primaryStage = s;
    }


    public void generateHexGrid(){
        for(int i = 0; i < mapX; i++){
            for(int j = 0; j < mapY; j++){

                grid[i][j] = new Hex(root,i,j);
                //grid[i][j].getSprite().setOnMouseClicked(this::SelectHex);
                grid[i][j].getAdjust().setOnMouseClicked(this::SelectHex);
                hexes.getChildren().add(grid[i][j].getSprite());
                hexes.getChildren().add(grid[i][j].getAdjust());
                hexes.getChildren().add(grid[i][j].getSanityTest());
                if(galaxy.getGrid()[i][j].getType() != StarType.NONE){
                    grid[i][j].setStar(galaxy.getGrid()[i][j]);
                }


            }
        }

        //size grid
        root.getChildren().add(hexes);
        hexes.setScaleX(0.2);
        hexes.setScaleY(0.2);
        hexes.setTranslateX(-1700);
        hexes.setTranslateY(-800);

    }

    public void updateHexGrid(){
        System.out.println(" empire count: " + galaxy.getEmpires().size());
        for(int i = 0; i < galaxy.getEmpires().size();i++){
            System.out.println(" territory size: " + galaxy.getEmpires().get(i).getTerritory().size());
            for(int j = 0; j < galaxy.getEmpires().get(i).getTerritory().size();j++){
                Star currentStar = galaxy.getEmpires().get(i).getTerritory().get(j);
                String spriteChange = "tile_blank.png";
                if(currentStar.getType() != StarType.NONE){
                    spriteChange = "startilebasenewclaimed.png";
                } else {
                    spriteChange = "tile_base_1.png";
                }


                grid[currentStar.getX()][currentStar.getY()].getSprite().setImage(new Image(spriteChange));
                grid[currentStar.getX()][currentStar.getY()].getAdjust().setEffect(galaxy.getEmpires().get(i).getMapColor());
            }
        }

        for(Fleet f : empire.getFleets()){
            f.getSprite().setOnMouseClicked(this::selectFleet);
        }


    }

    public void loadTopBarData(Empire e){
        root.getChildren().add(creditCount);
        creditCount.setTranslateX(40);
        creditCount.setText(e.getCredits() + "");
        creditCount.setFont(new Font("OCR A Extended", 12));
        creditCount.setTextFill(Color.LIGHTYELLOW);

        root.getChildren().add(scienceCount);
        scienceCount.setTranslateX(120);
        scienceCount.setText(e.getScience() + "");
        scienceCount.setFont(new Font("OCR A Extended", 12));
        scienceCount.setTextFill(Color.LIGHTBLUE);


        root.getChildren().add(stabilityCount);
        stabilityCount.setTranslateX(180);
        stabilityCount.setText(e.getStability() + "");
        stabilityCount.setFont(new Font("OCR A Extended", 12));
        stabilityCount.setTextFill(Color.LIGHTGRAY);

        root.getChildren().add(influenceCount);
        influenceCount.setTranslateX(220);
        influenceCount.setText(e.getInfluence() + "");
        influenceCount.setFont(new Font("OCR A Extended", 12));
        influenceCount.setTextFill(Color.DARKMAGENTA);
    }

    public void selectFleet(MouseEvent event){
        Fleet selectedFleet = null;
        for(Fleet f : empire.getFleets()){
            if(f.getSprite() == event.getSource()){
                selectedFleet = f;
            }
        }




    }

    public void SelectHex(MouseEvent event){

        Hex src = null;
        int x = 0;
        int y = 0;
        for(int i = 0; i < mapX; i++){
            for(int j = 0; j < mapY; j++){

                if(grid[i][j].getAdjust() == event.getSource()){
                    src = grid[i][j];
                    x = i;
                    y = j;
                }

            }
        }

        //empire.annexStar(galaxy.getGrid()[x][y]);
        //updateHexGrid();

        System.out.println("Hex position: "+x+" "+y);

        Star temp = galaxy.getGrid()[x][y];

        System.out.println(temp.getPlanets().size());
        for(int i = 0; i < temp.getPlanets().size(); i++){
            System.out.println(temp.getPlanets().get(i).getName() + " " + temp.getPlanets().get(i).getBiome().toString());
        }

        if(temp.getPlanets().size() > 0){
            StarScreen starScreen = new StarScreen(temp,this,primaryStage,empire);
            primaryStage.setScene(starScreen.starScene);
        }



    }

    public void processHotkey(KeyEvent event) throws IOException {
        if(event.getCode() == KeyCode.S){
            GameSaver.saveGame(galaxy);
            System.out.println("Game saved");
        }
    }

    public void endTurn(MouseEvent event){
        empire.processTurn(root);
    }

}
