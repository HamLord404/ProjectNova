package sample.Screens;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Dictionaries.TraitDictionary;
import sample.EmpireData.Empire;
import sample.EmpireData.Species;
import sample.Enums.GovernmentType;
import sample.Enums.Ideology;
import sample.Enums.TraitEnum;
import sample.GalaxyData.Galaxy;
import sample.PoliticalParty;
import sample.UIElements.*;

import java.util.ArrayList;

public class GovernmentCreationScreen {
    Pane root = new Pane();

    Scene govCreationScene = new Scene(root,1000,500);

    LabelBackground l = new LabelBackground("Government",root,0,0);

    ArrayList<ToggleButton> buttons = new ArrayList<>();

    Button next = new Button("Next",root,300,300);

    Species founders;

    GovernmentType selectGov;
    Ideology selectIdeo;

    Background bg = new Background(root);

    ToggleButton democracy = new ToggleButton(root,0,1,"Republic");
    ToggleButton oligarchy = new ToggleButton(root,1,1,"Oligarchy");
    ToggleButton monarchy = new ToggleButton(root,2,1,"Monarchy");
    ToggleButton dictatorship = new ToggleButton(root,3,1,"Despotism");
    ToggleButton megacorporation = new ToggleButton(root,4,1,"Megacorp");


    LabelBackground empireNameLabel = new LabelBackground("Empire Name",root,0,2);
    TextField empireName = new TextField();

    /*
    LabelBackground rulingParty = new LabelBackground("Ruling Party",root,0,2);

    ToggleButton egalitarian = new ToggleButton(root,0,3,"Egalitarian");
    ToggleButton authoritarian = new ToggleButton(root,1,3,"Absolutist");
    ToggleButton militarist = new ToggleButton(root,2,3,"Militarist");
    ToggleButton pacifist = new ToggleButton(root,3,3,"Pacifist");
    ToggleButton technocrat = new ToggleButton(root,4,3,"Technocrat");
    ToggleButton religious = new ToggleButton(root,4,3,"Religious");
    */

    Stage primaryStage;


    public GovernmentCreationScreen(Species f,Stage s){
        System.out.println("Hello!");

        democracy.addExclusive(oligarchy);
        democracy.addExclusive(monarchy);
        democracy.addExclusive(dictatorship);
        democracy.addExclusive(megacorporation);

        oligarchy.addExclusive(monarchy);
        oligarchy.addExclusive(dictatorship);
        oligarchy.addExclusive(megacorporation);

        monarchy.addExclusive(dictatorship);
        monarchy.addExclusive(megacorporation);

        dictatorship.addExclusive(megacorporation);

        buttons.add(democracy);
        buttons.add(oligarchy);
        buttons.add(monarchy);
        buttons.add(dictatorship);
        buttons.add(megacorporation);

        democracy.setData(GovernmentType.DEMOCRACY);
        oligarchy.setData(GovernmentType.OLIGARCHY);
        dictatorship.setData(GovernmentType.DICTATORSHIP);
        monarchy.setData(GovernmentType.MONARCHY);
        megacorporation.setData(GovernmentType.MEGACORPERATION);



        addEmpireNamer();

        /*
        egalitarian.addExclusive(authoritarian);
        egalitarian.addExclusive(militarist);
        egalitarian.addExclusive(pacifist);
        egalitarian.addExclusive(technocrat);
        egalitarian.addExclusive(religious);

        authoritarian.addExclusive(militarist);
        authoritarian.addExclusive(pacifist);
        authoritarian.addExclusive(technocrat);
        authoritarian.addExclusive(religious);

        militarist.addExclusive(pacifist);
        militarist.addExclusive(technocrat);
        militarist.addExclusive(religious);

        pacifist.addExclusive(technocrat);
        pacifist.addExclusive(religious);

        technocrat.addExclusive(religious);


        buttons.add(egalitarian);
        buttons.add(authoritarian);
        buttons.add(militarist);
        buttons.add(pacifist);
        buttons.add(technocrat);
        buttons.add(religious);

        egalitarian.setData(Ideology.EGALITARIAN);
        authoritarian.setData(Ideology.AUTHORITARIAN);
        technocrat.setData(Ideology.TECHNOCRATIC);
        religious.setData(Ideology.RELIGIOUS);
        militarist.setData(Ideology.MILITARIST);
        pacifist.setData(Ideology.PACIFIST);
        */

        next.getSegmentGroup().setOnMouseClicked(this::finishGov);
        next.getLabel().setOnMouseClicked(this::finishGov);

        for (ToggleButton x : buttons){
            x.getSprite().setOnMouseClicked(this::handleMutEclu);
            x.getLabel().setOnMouseClicked(this::handleMutEclu);
        }

        founders = f;
        primaryStage = s;

        addTooltips();

    }

    private void handleMutEclu(MouseEvent event){

        //Handle Mut. Excl. basics

        for (ToggleButton x : buttons) {
            if (x.getSprite() == event.getSource() || x.getLabel() == event.getSource()) {
                for (ToggleButton y : x.getMutuallyExclusive()) {
                    if(y.isActive()) {
                        y.clickFeedback(event);
                    }
                }
                x.clickFeedback(event);

                if(x.getData().getClass() == GovernmentType.class){
                    selectGov = (GovernmentType) x.getData();
                } else {
                    selectIdeo = (Ideology) x.getData();
                }
            }

        }
    }

    private void addTooltips(){
        Node[] temp = {democracy.getSprite(),democracy.getLabel()};
        String tempText = "A form of government where the \npeople elect their leaders \ninto positions of power\n" +
                "\nGameplay Effect: \n" +
                "Election Every 10 turns";
        Tooltip republicTip = new Tooltip(temp,tempText,root);

        Node[] temp2 = {oligarchy.getSprite(),oligarchy.getLabel()};
        tempText = "A form of government dominated\n" +
                "by one particular class of people\n" +
                "with more political rights\n" +
                "in other words,\"Rule by few\" \n" +
                "\n" +
                "Gameplay Effect:\n" +
                "Elections every 20 turns\n" +
                "\nGain a unique bonus whenever a\n" +
                "Idea Tree is fully adopted";

        Tooltip oligarchyTip = new Tooltip(temp2,tempText,root);

        Node[] temp3 = {monarchy.getSprite(),monarchy.getLabel()};
        tempText = "A form of government where\n" +
                "the ruler is chosen via\n" +
                "hereditary succession\n" +
                "\n" +
                "Gameplay Effect:\n" +
                "Ruler rules until death\n" +
                "Has a designated heir";
        Tooltip monarchyTip = new Tooltip(temp3,tempText,root);

        Node[] temp4 = {dictatorship.getSprite(),dictatorship.getLabel()};
        tempText = "A form of government where\n" +
                "the ruler rules for life with\n" +
                "absolute power, a dictatorship\n" +
                "\n" +
                "Gameplay Effect:\n" +
                "Ruler rules until death\n" +
                "Can Appoint a successor\n" +
                "";
        Tooltip despotismTip = new Tooltip(temp4,tempText,root);


        Node[] temp5 = {megacorporation.getSprite(),megacorporation.getLabel()};
        tempText = "A form of government where\n" +
                "the ruler is the CEO of a powerful\n" +
                "corporation that has supplanted the\n" +
                "government, and become a \n" +
                "government itself\n" +
                "\n" +
                "Gameplay Effect:\n" +
                "Ruler rules until death\n" +
                "+50% trade route capacity\n" +
                "";
        Tooltip megaCorpTip = new Tooltip(temp5,tempText,root);


    }


    private void addEmpireNamer(){
        root.getChildren().add(empireName);
        empireName.setTranslateY(93);
    }
    private void finishGov(MouseEvent event){
        System.out.println("Government Created");
        Empire e = new Empire(empireName.getText(),selectGov,founders);
        HomeWorldChoosingScreen x = new HomeWorldChoosingScreen(e,primaryStage);

        primaryStage.setScene(x.homeWorldScene);
    }




}
