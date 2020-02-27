package sample.Screens;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;
import sample.UIElements.Background;
import sample.UIElements.Button;
import sample.UIElements.ToggleButton;


import java.util.ArrayList;

public class NewGameScreen {

    Pane root = new Pane();
    Stage stage;
    public Scene newGameScene = new Scene(root,1000,700);
    Background bg = new Background(root);
    ToggleButton hotseat = new ToggleButton(root,0,1,"Hot Seat");
    ToggleButton passSave = new ToggleButton(root,1,1,"Longturn");
    ToggleButton online = new ToggleButton(root,2,1,"Online");

    Button next = new Button("Next",root,500,400);


    Label xLabel = new Label("Map Width:");
    Label yLabel = new Label("Map Height:");
    TextField mapxField = new TextField();
    TextField mapyField = new TextField();

    ArrayList<ToggleButton> gameTypes = new ArrayList<>();
    Label numPlayers = new Label("Number of players: ");
    TextField playerField = new TextField();

    public NewGameScreen(Stage stage){
        this.stage = stage;

        gameTypes.add(hotseat);
        gameTypes.add(passSave);
        gameTypes.add(online);

        hotseat.getSprite().setOnMouseClicked(this::handleMutualExclusives);
        hotseat.getLabel().setOnMouseClicked(this::handleMutualExclusives);
        passSave.getSprite().setOnMouseClicked(this::handleMutualExclusives);
        passSave.getLabel().setOnMouseClicked(this::handleMutualExclusives);
        online.getSprite().setOnMouseClicked(this::handleMutualExclusives);
        online.getLabel().setOnMouseClicked(this::handleMutualExclusives);

        next.getSegmentGroup().setOnMouseClicked(this::createNewGame);
        next.getLabel().setOnMouseClicked(this::createNewGame);


        xLabel.setTranslateX(400);
        xLabel.setTranslateY(30);
        xLabel.setFont(new Font("BankGothic Md BT", 15));
        xLabel.setTextFill(Color.WHITE);

        yLabel.setTranslateX(400);
        yLabel.setTranslateY(60);
        yLabel.setFont(new Font("BankGothic Md BT", 15));
        yLabel.setTextFill(Color.WHITE);

        root.getChildren().add(xLabel);
        root.getChildren().add(yLabel);
        root.getChildren().add(mapxField);
        root.getChildren().add(mapyField);
        root.getChildren().add(playerField);
        root.getChildren().add(numPlayers);

        mapxField.setText("12");
        mapyField.setText("18");
        mapxField.setMinWidth(40);
        mapxField.setMaxWidth(40);
        mapyField.setMinWidth(40);
        mapyField.setMaxWidth(40);
        mapxField.setTranslateX(500);
        mapxField.setTranslateY(30);
        mapyField.setTranslateX(500);
        mapyField.setTranslateY(60);


        numPlayers.setTranslateX(0);
        numPlayers.setTranslateY(100);
        numPlayers.setFont(new Font("BankGothic Md BT", 15));
        numPlayers.setTextFill(Color.WHITE);

        playerField.setMinWidth(40);
        playerField.setMaxWidth(40);

        playerField.setTranslateX(140);
        playerField.setTranslateY(100);

        playerField.setText("2");

        setupMutualExclusives();
    }

    private void setupMutualExclusives(){

        hotseat.addExclusive(passSave);
        hotseat.addExclusive(online);
        passSave.addExclusive(hotseat);
        passSave.addExclusive(online);
        online.addExclusive(passSave);
        online.addExclusive(hotseat);


    }

    public void handleMutualExclusives(MouseEvent event){
        for(ToggleButton x : gameTypes){
            if (event.getSource() == x.getSprite() || event.getSource() == x.getLabel()) {
                for (ToggleButton y : x.getMutuallyExclusive()) {
                    if(y.isActive()) {
                        y.clickFeedback(event);
                    }
                }
                x.clickFeedback(event);
            }
        }
    }

    public void createNewGame(MouseEvent event){
        Main.mapx = Integer.valueOf(mapxField.getText());
        Main.mapy = Integer.valueOf(mapyField.getText());
        Main.numPlayers = Integer.valueOf(playerField.getText());

        SpeciesCreationScreen sp = new SpeciesCreationScreen(stage);
        stage.setScene(sp.getSpeciesCreationScene());
    }


}
