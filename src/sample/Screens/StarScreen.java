package sample.Screens;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.EmpireData.Colony;
import sample.EmpireData.Empire;
import sample.GalaxyData.Planet;
import sample.GalaxyData.Star;
import sample.UIElements.Button;

import java.util.ArrayList;

public class StarScreen {
    Pane root = new Pane();
    Scene starScene = new Scene(root,1000,700);
    ArrayList<ImageView> planets = new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<Button>();
    ArrayList<Planet> planetData = new ArrayList<Planet>();
    Button back = new Button("Back",root,0,0);
    Star star;
    GalaxyScreen gs;
    Empire empire;
    Stage primaryStage;

    public StarScreen(Star star, GalaxyScreen gs, Stage primaryStage, Empire empire){
        this.star = star;
        this.gs = gs;
        this.primaryStage = primaryStage;
        this.empire = empire;


        for(int i = 0; i < star.getPlanets().size(); i++){
            String planetName = star.getPlanets().get(i).getName();
            Button temp = new Button(planetName,root,(i* 100) + 200,500);
            temp.getSegmentGroup().setOnMouseClicked(this::processPlanetSelect);
            temp.getLabel().setOnMouseClicked(this::processPlanetSelect);
            buttons.add(temp);
            planetData.add(star.getPlanets().get(i));


            ImageView planetImage = new ImageView("desert_planet.png");
            //planets.add(planetImage);
            //root.getChildren().add(planetImage);
            //planetImage.setScaleX(0.2);
            //planetImage.setScaleY(0.2);
            //planetImage.setTranslateX(100 + (i * 100));
            //planetImage.setTranslateY(-100);

        }

        back.getSegmentGroup().setOnMouseClicked(this::backToGalaxyScreen);
        back.getLabel().setOnMouseClicked(this::backToGalaxyScreen);

    }

    public void processPlanetSelect(MouseEvent event){
        int index = 0;
        for(int i = 0; i < buttons.size(); i++){
            if(event.getSource() == buttons.get(i).getSegmentGroup() || event.getSource() == buttons.get(i).getLabel()){
                index = i;
            }
        }
        if(star.getPlanets().get(index).isColonised()){
            //ColonyScreen x = new ColonyScreen();
            
        } else{
            ColonisationScreen x = new ColonisationScreen(planetData.get(index),empire,starScene,primaryStage);
            primaryStage.setScene(x.colonisationScene);
        }

        

    }

    public void backToGalaxyScreen(MouseEvent event){
        primaryStage.setScene(gs.galaxyScene);
    }



}
