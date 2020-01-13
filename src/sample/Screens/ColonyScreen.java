package sample.Screens;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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

        String turnlyFood = "Food: " + c.getTurnlyFood(e);
        String turnlyProduction = "Production: " + c.getTurnlyProduction(e);
        String turnlyScience = "Science: " + c.getTurnlyScience(e);

        String[] statsText = {turnlyFood,turnlyProduction,turnlyScience};
        stats = new Panel(root,statsText,0,32);

        back.getSegmentGroup().setOnMouseClicked(this::backToLastScreen);
        back.getLabel().setOnMouseClicked(this::backToLastScreen);


        
    }


    public void backToLastScreen(MouseEvent event){
        primaryStage.setScene(previousScene);
    }







}
