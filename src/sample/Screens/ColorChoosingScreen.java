package sample.Screens;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.EmpireData.Empire;
import sample.GalaxyData.Planet;
import sample.UIElements.Background;
import sample.UIElements.Button;
import sample.UIElements.TriangleButton;


public class ColorChoosingScreen {
    Slider hue = new Slider();
    Slider saturation = new Slider();
    Slider brightness = new Slider();

    ImageView example = new ImageView("faction_1.png");
    ImageView AdjustLayer = new ImageView("adjustmentlayer.png");
    Pane root = new Pane();
    Background bg = new Background(root);
    Label hueLabel = new Label("Hue");
    Label satLabel = new Label("Saturation");
    Label briLabel = new Label("Brightness");

    String[] icons = {"faction_1.png","faction_2.png","faction_3.png","faction_4.png"};
    int currentIconIndex = 0;

    Button next = new Button("Next",root,300,100);
    TriangleButton left = new TriangleButton(root,-20,42,false);
    TriangleButton right = new TriangleButton(root,65,42,true);

    ColorAdjust color = new ColorAdjust();

    Scene colorCreationScene = new Scene(root,1000,500);
    Stage primaryStage;
    Planet homeworld;
    Empire empire;
    Timeline tick;

    public ColorChoosingScreen(Stage s, Empire e, Planet p){
        root.getChildren().add(hue);
        root.getChildren().add(hueLabel);
        root.getChildren().add(saturation);
        root.getChildren().add(satLabel);
        root.getChildren().add(example);
        root.getChildren().add(AdjustLayer);

        hue.setTranslateX(20);
        hue.setTranslateY(20);
        hueLabel.setTranslateX(200);
        hueLabel.setTranslateY(20);
        hueLabel.setTextFill(Color.WHITE);

        saturation.setTranslateX(20);
        saturation.setTranslateY(40);
        satLabel.setTranslateX(200);
        satLabel.setTranslateY(40);
        satLabel.setTextFill(Color.WHITE);

        example.setTranslateX(-30);
        example.setTranslateY(10);
        AdjustLayer.setTranslateX(-30);
        AdjustLayer.setTranslateY(10);



        homeworld = p;
        primaryStage = s;
        empire = e;

        updateColor();
        hue.setMax(1.0);
        hue.setMin(-1.0);
        saturation.setMax(1.0);
        saturation.setMin(0);
        saturation.setValue(1);
        brightness.setMax(1.0);
        brightness.setMin(0.0);



        example.setScaleX(0.2);
        example.setScaleY(0.2);
        AdjustLayer.setScaleX(0.2);
        AdjustLayer.setScaleY(0.2);

        left.getSprite().setOnMouseClicked(this::rotateIconLeft);
        right.getSprite().setOnMouseClicked(this::rotateIconRight);


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
                color.setBrightness(brightness.getValue());


                AdjustLayer.setBlendMode(BlendMode.OVERLAY);
                AdjustLayer.setEffect(color);
            }
        }));

        tick.setCycleCount(Timeline.INDEFINITE);
        tick.play();





    }


    public void rotateIconLeft(MouseEvent event){
        if(currentIconIndex == 0){
            currentIconIndex = icons.length - 1;
        } else{
            currentIconIndex--;
        }

        example.setImage(new Image(icons[currentIconIndex]));

    }

    public void rotateIconRight(MouseEvent event){
        if(currentIconIndex == icons.length-1){
            currentIconIndex = 0;
        } else{
            currentIconIndex++;
        }

        example.setImage(new Image(icons[currentIconIndex]));
    }

    public void finishColor(MouseEvent event){
        GalaxyScreen x = new GalaxyScreen(primaryStage,empire);
        empire.setMapColor(color);
        empire.setIcon(example.getImage());
        x.galaxy.spawnEmpire(empire,homeworld);
        x.updateHexGrid();
        x.loadTopBarData(empire);
        tick.stop();
        primaryStage.setScene(x.galaxyScene);
    }




}
