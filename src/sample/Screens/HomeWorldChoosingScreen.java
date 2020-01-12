package sample.Screens;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.EmpireData.Empire;
import sample.Enums.*;
import sample.GalaxyData.Planet;
import sample.UIElements.Button;
import sample.UIElements.LabelBackground;
import sample.UIElements.ToggleButton;

import java.util.ArrayList;

public class HomeWorldChoosingScreen {
    GridPane root = new GridPane();
    LabelBackground homeworldBiome = new LabelBackground("Homeworld Biome",root,0,0);
    ArrayList<ToggleButton> biomePicker = new ArrayList<>();
    LabelBackground homeworldTempurature = new LabelBackground("Tempurature",root,0,3);
    ArrayList<ToggleButton> gravityPicker = new ArrayList<>();
    LabelBackground homeworldGravity = new LabelBackground("Gravity",root,0,5);
    ArrayList<ToggleButton> tempuraturePicker = new ArrayList<>();
    TextField homeworldName = new TextField();
    Scene homeWorldScene = new Scene(root,1000,500);
    Biome biome = Biome.TERRAN;
    Temperature temperature = Temperature.TEMPERATE;
    Gravity gravity = Gravity.MEDIUM;
    Button next = new Button("Next",root,9,9);
    Empire e;
    Planet p;


    Stage primaryStage;
    public HomeWorldChoosingScreen(Empire e,Stage s){
        int xtemp = 0;
        for(int i = 0; i < Biome.values().length; i++){
            biomePicker.add(new ToggleButton(root,xtemp,1 + (i/5),Biome.values()[i].toString()));
            xtemp++;
            if(xtemp > 4){
                xtemp = 0;
            }

        }

        for(int i = 0; i < biomePicker.size(); i++){
            for(int j = 0; j < biomePicker.size(); j++){
                biomePicker.get(i).addExclusive(biomePicker.get(j));
                biomePicker.get(i).getLabel().setOnMouseClicked(this::handleBiomeMutualExclusive);
                biomePicker.get(i).getSprite().setOnMouseClicked(this::handleBiomeMutualExclusive);
            }
        }

        for(int i = 0; i < Temperature.values().length; i++){
            ToggleButton temp = new ToggleButton(root,i,4, Temperature.values()[i].toString());
            temp.getSprite().setOnMouseClicked(this::handleTempuratureMutualExclusive);
            temp.getLabel().setOnMouseClicked(this::handleTempuratureMutualExclusive);
            tempuraturePicker.add(temp);
        }

        tempuraturePicker.get(0).addExclusive(tempuraturePicker.get(1));
        tempuraturePicker.get(0).addExclusive(tempuraturePicker.get(2));
        tempuraturePicker.get(1).addExclusive(tempuraturePicker.get(2));


        for(int i = 0; i < Gravity.values().length; i++){
            ToggleButton temp = new ToggleButton(root,i,6, Gravity.values()[i].toString());
            temp.getSprite().setOnMouseClicked(this::handleGravityMutualExclusive);
            temp.getLabel().setOnMouseClicked(this::handleGravityMutualExclusive);
            gravityPicker.add(temp);
        }
        gravityPicker.get(0).addExclusive(gravityPicker.get(1));
        gravityPicker.get(0).addExclusive(gravityPicker.get(2));
        gravityPicker.get(1).addExclusive(gravityPicker.get(2));



        next.getSprite().setOnMouseClicked(this::finishHomeworld);
        next.getLabel().setOnMouseClicked(this::finishHomeworld);


        root.add(homeworldName,0,7);

        primaryStage = s;
        this.e = e;
    }

    public void handleBiomeMutualExclusive(MouseEvent event){
        for (ToggleButton x : biomePicker) {
            if (x.getSprite() == event.getSource() || x.getLabel() == event.getSource()) {
                for (ToggleButton y : x.getMutuallyExclusive()) {
                    if(y.isActive()) {
                        y.clickFeedback(event);
                    }
                }
                x.clickFeedback(event);

                biome = Biome.valueOf(x.getLabel().getText());
            }

        }
    }

    public void handleTempuratureMutualExclusive(MouseEvent event){
        for (ToggleButton x : tempuraturePicker) {
            if (x.getSprite() == event.getSource() || x.getLabel() == event.getSource()) {
                for (ToggleButton y : x.getMutuallyExclusive()) {
                    if(y.isActive()) {
                        y.clickFeedback(event);
                    }
                }
                x.clickFeedback(event);

                temperature = Temperature.valueOf(x.getLabel().getText());
            }

        }
    }

    public void handleGravityMutualExclusive(MouseEvent event){
        for (ToggleButton x : gravityPicker) {
            if (x.getSprite() == event.getSource() || x.getLabel() == event.getSource()) {
                for (ToggleButton y : x.getMutuallyExclusive()) {
                    if(y.isActive()) {
                        y.clickFeedback(event);
                    }
                }
                x.clickFeedback(event);

                gravity = Gravity.valueOf(x.getLabel().getText());
            }

        }
    }

    /*
    public void finishHomeworld(MouseEvent event){
        System.out.println("Homeworld Created");
        GalaxyScreen x = new GalaxyScreen();

        p = Planet.generatePlanet();
        p.setBiome(biome);
        p.setGrav(gravity);
        p.setTemp(temperature);
        p.setName(homeworldName.getText());

        x.galaxy.spawnEmpire(e,p);
        x.updateHexGrid();
        x.loadTopBarData(e);
        primaryStage.setScene(x.galaxyScene);
    }
     */

    public void finishHomeworld(MouseEvent event){
        System.out.println("Homeworld Created");


        p = Planet.generatePlanet();
        p.setBiome(biome);
        p.setGrav(gravity);
        p.setTemp(temperature);
        p.setName(homeworldName.getText());

        ColorChoosingScreen x = new ColorChoosingScreen(primaryStage,e,p);


        primaryStage.setScene(x.colorCreationScene);
    }



}
