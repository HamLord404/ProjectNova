package sample.Screens;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.UIElements.Background;
import sample.UIElements.Button;


public class MainMenuScreen {
    Pane root = new Pane();
    Stage stage = new Stage();
    public Scene mainMenuScene = new Scene(root,1000,700);
    Background bg = new Background(root);
    Label title = new Label("Project Nova");
    Button newGame = new Button("New Game",root,450,300);
    Button loadGame = new Button("Load Game",root,450,400);
    Button exitGame = new Button("Exit Game",root,450,500);

    public MainMenuScreen(Stage primaryStage){
        stage = primaryStage;
        newGame.getSegmentGroup().setOnMouseClicked(this::startNewGame);
        newGame.getLabel().setOnMouseClicked(this::startNewGame);

        exitGame.getSegmentGroup().setOnMouseClicked(this::exitGame);
        exitGame.getLabel().setOnMouseClicked(this::exitGame);

        title.setTextFill(Color.WHITE);
        title.setFont(new Font("BankGothic Md BT", 30));
        title.setTranslateX(430);
        title.setTranslateY(100);
        root.getChildren().add(title);
    }

    public void startNewGame(MouseEvent event){
        //SpeciesCreationScreen sp = new SpeciesCreationScreen(stage);
        //        //stage.setScene(sp.getSpeciesCreationScene());

        NewGameScreen sp = new NewGameScreen(stage);
        stage.setScene(sp.newGameScene);
    }



    public void exitGame(MouseEvent event){
        System.exit(0);
    }
}
