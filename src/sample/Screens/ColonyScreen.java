package sample.Screens;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.EmpireData.Colony;
import sample.EmpireData.Empire;
import sample.UIElements.Button;
import sample.UIElements.LabelBackground;
import sample.UIElements.Panel;

import java.util.ArrayList;

public class ColonyScreen {
    Pane root = new Pane();
    Scene ColonyScene = new Scene(root,1000,500);
    LabelBackground production = new LabelBackground("Production",root,0,10);
    String[] statsText;
    Panel stats = new Panel(root,statsText,0,32);
    ArrayList<Button> productionOptions = new ArrayList<>();

    Colony c;
    Empire e;

    Stage primaryStage;
    Scene previousScene;

    public ColonyScreen(Stage primaryStage, Scene previousScene, Colony c, Empire e){
        this.primaryStage = primaryStage;
        this.previousScene = previousScene;
        this.c = c;
        this.e = e;

        
    }







}
