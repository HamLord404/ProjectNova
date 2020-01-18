package sample.Screens;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Dictionaries.BuildableDictionary;
import sample.EmpireData.Colony;
import sample.EmpireData.Empire;
import sample.UIElements.Button;
import sample.UIElements.ButtonList;
import sample.UIElements.LabelBackground;
import sample.UIElements.Panel;

import java.util.ArrayList;

public class ColonyScreen {
    Pane root = new Pane();
    Scene ColonyScene = new Scene(root,1000,500);
    LabelBackground production = new LabelBackground("Production",root,9,0);
    LabelBackground planetName = new LabelBackground("",root,1,0);
    ButtonList productionOptions;
    Panel stats;
    Button back = new Button("Back",root,0,0);

    Colony c;
    Empire e;

    Stage primaryStage;
    Scene previousScene;

    public ColonyScreen(Stage primaryStage, Scene previousScene, Colony c, Empire e){
        this.primaryStage = primaryStage;
        this.previousScene = previousScene;
        this.c = c;
        this.e = e;

        panelText(c, e);



        back.getSegmentGroup().setOnMouseClicked(this::backToLastScreen);
        back.getLabel().setOnMouseClicked(this::backToLastScreen);

        String[] options = {"Light Ship","Heavy Ship"};
        productionOptions = new ButtonList(root,options,840,30);

        for(Button b : productionOptions.getButtons()){
            b.getSegmentGroup().setOnMouseClicked(this::CommissionConstruction);
            b.getLabel().setOnMouseClicked(this::CommissionConstruction);
        }

        planetName.getLabel().setText(c.getPlanet().getName());
    }

    public void panelText(Colony c, Empire e){
        String turnlyFood = "Food: " + c.getTurnlyFood(e);
        String turnlyProduction = "Production: " + c.getTurnlyProduction(e);
        String turnlyScience = "Science: " + c.getTurnlyScience(e);

        String currentProduction = "Current Production: None";
        if(c.getCurrentConstruction() != null){
            currentProduction = "Current Production: " + c.getCurrentConstruction().getName();
        }

        String[] statsText = {turnlyFood,turnlyProduction,turnlyScience,currentProduction};
        stats = new Panel(root,statsText,0,32);
    }

    public void CommissionConstruction(MouseEvent event){
        Button pressed = null;
        for(Button b: productionOptions.getButtons()){
            if(event.getSource() == b.getLabel() || event.getSource() == b.getSegmentGroup()){
                pressed = b;
            }
        }

        System.out.println(pressed.getLabel().getText());

        c.setCurrentConstruction(BuildableDictionary.getBuildable(pressed.getLabel().getText(),e));
        panelText(c,e);
    }


    public void backToLastScreen(MouseEvent event){
        primaryStage.setScene(previousScene);
    }







}
