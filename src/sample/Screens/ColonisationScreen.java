package sample.Screens;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.EmpireData.Empire;
import sample.Enums.Effect;
import sample.GalaxyData.Planet;
import sample.UIElements.Button;
import sample.UIElements.Panel;
import sample.UIElements.SmallButton;

public class ColonisationScreen {
    Planet planet;
    Empire empire;
    Pane root = new Pane();
    Scene colonisationScene = new Scene(root,1000,700);
    Button back = new Button("Back",root,0,0);

    Panel planetInfo;
    Scene lastScene;
    Stage primaryStage;

    public ColonisationScreen(Planet planet, Empire empire, Scene lastScene, Stage primaryStage){
        this.planet = planet;
        this.empire = empire;
        this.lastScene = lastScene;
        this.primaryStage = primaryStage;

        back.getLabel().setOnMouseClicked(this::backToLastScene);
        back.getSegmentGroup().setOnMouseClicked(this::backToLastScene);

        getInfo();

    }

    public void getInfo(){
        String planetName = "Name: " + planet.getName();
        String planetBiome = "Biome: " + planet.getBiome();
        String planetTemp = "Temperature: " + planet.getTemp();
        String planetGrav = "Gravity: " + planet.getGrav();
        String[] info = {planetName,planetBiome,planetTemp,planetGrav};
        planetInfo = new Panel(root,info,0,32);

    }

    public void backToLastScene(MouseEvent event){
        primaryStage.setScene(lastScene);
    }



}
