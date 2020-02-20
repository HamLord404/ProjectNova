package sample.Screens;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.EmpireData.Empire;
import sample.GalaxyData.Planet;
import sample.UIElements.Button;


public class ColorChoosingScreen {
    Slider hue = new Slider();
    Slider saturation = new Slider();
    ImageView example = new ImageView("startilebasenewclaimed.png");
    GridPane root = new GridPane();
    Label hueLabel = new Label("Hue");
    Label satLabel = new Label("Saturation");
    Button next = new Button("Next",root,2,3);

    ColorAdjust color = new ColorAdjust();

    Scene colorCreationScene = new Scene(root,1000,500);
    Stage primaryStage;
    Planet homeworld;
    Empire empire;
    Timeline tick;

    public ColorChoosingScreen(Stage s, Empire e, Planet p){
        root.add(hue,0,0);
        root.add(hueLabel,1,0);
        root.add(saturation,0,1);
        root.add(satLabel,1,1);
        root.add(example,0,3);
        homeworld = p;
        primaryStage = s;
        empire = e;

        updateColor();
        hue.setMax(1.0);
        hue.setMin(-1.0);
        saturation.setMax(1.0);
        saturation.setMin(0);
        saturation.setValue(1);

        example.setScaleX(0.2);
        example.setScaleY(0.2);


        next.getSprite().setOnMouseClicked(this::finishColor);
        next.getLabel().setOnMouseClicked(this::finishColor);
    }

    public void updateColor(){
        tick = new Timeline(new KeyFrame(Duration.seconds(.1), new EventHandler<ActionEvent>() {

            @Override
            //this happens every tick
            public void handle(ActionEvent event) {
                //color = new ColorAdjust();
                System.out.println(hue.getValue());
                color.setHue(hue.getValue());
                color.setSaturation(saturation.getValue());

                example.setEffect(color);
            }
        }));

        tick.setCycleCount(Timeline.INDEFINITE);
        tick.play();





    }


    public void finishColor(MouseEvent event){
        GalaxyScreen x = new GalaxyScreen(primaryStage,empire);
        empire.setMapColor(color);
        x.galaxy.spawnEmpire(empire,homeworld);
        x.updateHexGrid();
        x.loadTopBarData(empire);
        tick.stop();
        primaryStage.setScene(x.galaxyScene);
    }




}
