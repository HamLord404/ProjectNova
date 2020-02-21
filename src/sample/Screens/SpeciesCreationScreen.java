package sample.Screens;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.EmpireData.Species;
import sample.Dictionaries.TraitDictionary;
import sample.Enums.TraitEnum;
import sample.UIElements.*;


import java.util.ArrayList;


public class SpeciesCreationScreen {
    Pane root = new Pane();
    Scene speciesCreationScene = new Scene(root,1000,500);
    Label title = new Label("10 picks left");
    int picks = 10;

    Background bg = new Background(root);

    Species newSpecies = new Species();
    TextField speciesName = new TextField();
    LabelBackground speciesNameLabel = new LabelBackground("Species Name",root,0,4);

    Stage primaryStage;

    LabelBackground picksLeft = new LabelBackground("10 picks",root,0,0);
    Button next = new Button("Next",root,650,300);
    ArrayList<ToggleButton> buttons = new ArrayList<>();

    ToggleButton food1 = new ToggleButton(root,0,1,"-1 food");
    ToggleButton food2 = new ToggleButton(root,0,2,"+1 food");
    ToggleButton food3 = new ToggleButton(root,0,3,"+2 food");

    ToggleButton prod1 = new ToggleButton(root,1,1,"-1 production");
    ToggleButton prod2 = new ToggleButton(root,1,2,"+1 production");
    ToggleButton prod3 = new ToggleButton(root,1,3,"+2 production");

    ToggleButton sci1 = new ToggleButton(root,2,1,"-1 science");
    ToggleButton sci2 = new ToggleButton(root,2,2,"+1 science");
    ToggleButton sci3 = new ToggleButton(root,2,3,"+2 science");

    ToggleButton inf1 = new ToggleButton(root,3,1,"-1 influence");
    ToggleButton inf2 = new ToggleButton(root,3,2,"+1 influence");
    ToggleButton inf3 = new ToggleButton(root,3,3,"+2 influence");

    ToggleButton Adaptable = new ToggleButton(root,4,1,"Adaptable");
    ToggleButton Mechanical = new ToggleButton(root,4,2,"Mechanical");
    ToggleButton Cyborg = new ToggleButton(root,4,3,"Cyborg");
    ToggleButton Warriors = new ToggleButton(root,4,4,"Warriors");
    ToggleButton Lithovore = new ToggleButton(root,4,5,"Lithovore");
    ToggleButton Psionic = new ToggleButton(root,4,6,"Psionic");
    ToggleButton Aquatic = new ToggleButton(root,4,7,"Aquatic");
    ToggleButton Content = new ToggleButton(root,4,8,"Content");

    public SpeciesCreationScreen(Stage s){

        primaryStage = s;

        title.setFont(new Font("BankGothic Md BT", 30));

        //put the buttons in the arrayList for looping
        addButtons();


        addMutuallyExclusives();

        for (ToggleButton x : buttons) {
            x.getSprite().setOnMouseClicked(this::selectPick);
            x.getLabel().setOnMouseClicked(this::selectPick);
        }

        next.getSegmentGroup().setOnMouseClicked(this::finishRace);
        next.getLabel().setOnMouseClicked(this::finishRace);



        root.getChildren().add(speciesName);
        speciesName.setTranslateX(0);
        speciesName.setTranslateY(155);

        addToolTips();

    }

    private void addToolTips(){
        Node[] temp = {food1.getSprite(),food1.getLabel()};
        String tempText = "This species does not\n" +
                "grow much food\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "-1 food from pop\n" +
                "\n" +
                "+2 picks";
        Tooltip food1Tip = new Tooltip(temp,tempText,root);

        Node[] temp2 = {food2.getSprite(),food2.getLabel()};
        tempText = "This species is quite\n" +
                "adept at farming\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "+1 food from pop\n" +
                "\n" +
                "-2 picks";
        Tooltip food2Tip = new Tooltip(temp2,tempText,root);

        Node[] temp3 = {food3.getSprite(),food3.getLabel()};
        tempText = "This species is\n" +
                "expert at farming\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "+2 food from pop\n" +
                "\n" +
                "-5 picks";
        Tooltip food3Tip = new Tooltip(temp3,tempText,root);

        Node[] temp4 = {prod1.getSprite(),prod1.getLabel()};
        tempText = "This species is\n" +
                "not very industrious\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "-1 production from pop\n" +
                "\n" +
                "+2 picks";
        Tooltip prod1Tip = new Tooltip(temp4,tempText,root);

        Node[] temp5 = {prod2.getSprite(),prod2.getLabel()};
        tempText = "This species is\n" +
                "quite industrious\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "+1 production from pop\n" +
                "\n" +
                "-2 picks";
        Tooltip prod2Tip = new Tooltip(temp5,tempText,root);

        Node[] temp6 = {prod3.getSprite(),prod3.getLabel()};
        tempText = "This species is\n" +
                "very industrious\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "+2 production from pop\n" +
                "\n" +
                "-5 picks";
        Tooltip prod3Tip = new Tooltip(temp6,tempText,root);

        Node[] temp7 = {sci1.getSprite(),sci1.getLabel()};
        tempText = "This species is\n" +
                "not that intelligent\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "-1 science from pop\n" +
                "\n" +
                "+2 picks";
        Tooltip sci1Tip = new Tooltip(temp7,tempText,root);

        Node[] temp8 = {sci2.getSprite(),sci2.getLabel()};
        tempText = "This species is\n" +
                "quite intelligent\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "+1 science from pop\n" +
                "\n" +
                "-2 picks";
        Tooltip sci2Tip = new Tooltip(temp8,tempText,root);

        Node[] temp9 = {sci3.getSprite(),sci3.getLabel()};
        tempText = "This species is\n" +
                "very intelligent\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "+2 science from pop\n" +
                "\n" +
                "-5 picks";
        Tooltip sci3Tip = new Tooltip(temp9,tempText,root);

        Node[] temp10 = {inf1.getSprite(),inf1.getLabel()};
        tempText = "This species is\n" +
                "not very good at governing\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "-1 influence from pop\n" +
                "\n" +
                "+2 picks";
        Tooltip inf1Tip = new Tooltip(temp10,tempText,root);

        Node[] temp11 = {inf2.getSprite(),inf2.getLabel()};
        tempText = "This species is\n" +
                "quite good at governing\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "+1 influence from pop\n" +
                "\n" +
                "-2 picks";
        Tooltip inf2Tip = new Tooltip(temp11,tempText,root);

        Node[] temp12 = {inf3.getSprite(),inf3.getLabel()};
        tempText = "This species is\n" +
                "very good at governing\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "+2 influence from pop\n" +
                "\n" +
                "-5 picks";
        Tooltip inf3Tip = new Tooltip(temp12,tempText,root);

        Node[] temp13 = {Adaptable.getSprite(),Adaptable.getLabel()};
        tempText = "This species is\n" +
                "very hardy and can live\n" +
                "in a multitude of environments\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "+15% habitability on all worlds\n" +
                "\n" +
                "-6 picks";
        Tooltip adaptableTip = new Tooltip(temp13,tempText,root);

        Node[] temp14 = {Mechanical.getSprite(),Mechanical.getLabel()};
        tempText = "This species is\n" +
                "a machine with no noticable\n" +
                "Biological parts\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "Pops do not require food\n" +
                "+30% habitabilty on all worlds\n" +
                "Must build pops\n" +
                "\n" +
                "-8 picks";
        Tooltip mechanicalTip = new Tooltip(temp14,tempText,root);

        Node[] temp15 = {Cyborg.getSprite(),Cyborg.getLabel()};
        tempText = "All members of this species\n" +
                "have been cybernetically\n" +
                "augmented\n" +
                "\n" +
                "Gameplay Effect: \n" +
                "Pops require half as much food\n" +
                "+15% Ground Force weapons\n" +
                "\n" +
                "-4 picks";
        Tooltip cyborgTip = new Tooltip(temp15,tempText,root);

        Node[] temp16 = {Lithovore.getSprite(),Lithovore.getLabel()};
        tempText = "This species is silicon-based\n" +
                "and consumes minerals straight\n" +
                "from stone for nurishment\n" +
                "\n" +
                "Gameplay Effect:\n" +
                "gain food equal to production\n" +
                "cannot farm\n" +
                "\n" +
                "-7 picks";
        Tooltip lithovoreTip = new Tooltip(temp16,tempText,root);

        Node[] temp17 = {Psionic.getSprite(),Psionic.getLabel()};
        tempText = "This species has unlocked\n" +
                "the ability to use it's brain\n" +
                "foe telepathy with the help of\n" +
                "technology\n" +
                "\n" +
                "Gameplay Effect:\n" +
                "Spy Defence +25%\n" +
                "Ship Sight +2\n" +
                "\n" +
                "-6 picks";
        Tooltip psionicTip = new Tooltip(temp17,tempText,root);

        Node[] temp18 = {Warriors.getSprite(),Warriors.getLabel()};
        tempText = "This species has a warrior\n" +
                "culture where fighting is \n" +
                "commonplace. Most citizens have\n" +
                "some form of combat experience.\n" +
                "\n" +
                "Gameplay Effect:\n" +
                "Military Unit Starting level +2\n" +
                "+25% Military Unit production\n" +
                "\n" +
                "-4 picks";
        Tooltip warriorsTip = new Tooltip(temp18,tempText,root);

        Node[] temp19 = {Aquatic.getSprite(),Aquatic.getLabel()};
        tempText = "This species naturally\n" +
                "lives underwater and can \n" +
                "make maximum use of\n" +
                "wet planets\n" +
                "\n" +
                "Gameplay Effect:\n" +
                "+25% Pop capacity on \n" +
                "       Ocean, Island worlds\n" +
                "\n" +
                "-6 picks";
        Tooltip aquaticTip = new Tooltip(temp19,tempText,root);

        Node[] temp20 = {Content.getSprite(),Content.getLabel()};
        tempText = "This species is naturally\n" +
                "happy and is not upset often \n" +
                "\n" +
                "Gameplay Effect:\n" +
                "-0.5 unhappiness per pop\n" +
                "\n" +
                "-4 picks";
        Tooltip contentTip = new Tooltip(temp20,tempText,root);
    }

    private void selectPick(MouseEvent event){
        for (ToggleButton x : buttons) {
            if(x.getSprite() == event.getSource() || x.getLabel() == event.getSource()){

                for(ToggleButton y : x.getMutuallyExclusive()){
                    if(y.isActive()) {
                        updatePickCount(-TraitDictionary.resolveTrait((TraitEnum) y.getData()));
                        newSpecies.getTraits().remove(y.getData());
                        y.clickFeedback(event);
                    }
                }

                if(!x.isActive()) {
                    updatePickCount(TraitDictionary.resolveTrait((TraitEnum) x.getData()));
                    newSpecies.getTraits().add((TraitEnum) x.getData());
                } else {
                    updatePickCount(-TraitDictionary.resolveTrait((TraitEnum) x.getData()));
                    newSpecies.getTraits().remove(x.getData());
                }

                x.clickFeedback(event);

            }
        }
    }

    private void addMutuallyExclusives(){
        food1.addExclusive(food2);
        food1.addExclusive(food3);
        food2.addExclusive(food3);

        sci1.addExclusive(sci2);
        sci1.addExclusive(sci3);
        sci2.addExclusive(sci3);

        inf1.addExclusive(inf2);
        inf1.addExclusive(inf3);
        inf2.addExclusive(inf3);

        prod1.addExclusive(prod2);
        prod1.addExclusive(prod3);
        prod2.addExclusive(prod3);

    }

    private void finishRace(MouseEvent event){
        if(picks >= 0){
            GovernmentCreationScreen x = new GovernmentCreationScreen(newSpecies,primaryStage);
            primaryStage.setScene(x.govCreationScene);
        }
    }

    private void updatePickCount(int cost){
        picks -= cost;
        picksLeft.getLabel().setText(picks + " picks");

        if(picks < 0){
            next.getSegmentGroup().setVisible(false);
            next.getLabel().setVisible(false);
        } else {
            next.getSegmentGroup().setVisible(true);
            next.getLabel().setVisible(true);
        }
    }

    private void addButtons(){
        buttons.add(food1);
        food1.setData(TraitEnum.FOOD_MINUS_1);
        buttons.add(food2);
        food2.setData(TraitEnum.FOOD_PLUS_1);
        buttons.add(food3);
        food3.setData(TraitEnum.FOOD_PLUS_2);
        buttons.add(prod1);
        prod1.setData(TraitEnum.PROD_MINUS_1);
        buttons.add(prod2);
        prod2.setData(TraitEnum.PROD_PLUS_1);
        buttons.add(prod3);
        prod3.setData(TraitEnum.PROD_PLUS_2);
        buttons.add(sci1);
        sci1.setData(TraitEnum.SCI_MINUS_1);
        buttons.add(sci2);
        sci2.setData(TraitEnum.SCI_PLUS_1);
        buttons.add(sci3);
        sci3.setData(TraitEnum.SCI_PLUS_2);
        buttons.add(inf1);
        inf1.setData(TraitEnum.INF_MINUS_1);
        buttons.add(inf2);
        inf2.setData(TraitEnum.INF_PLUS_1);
        buttons.add(inf3);
        inf3.setData(TraitEnum.INF_PLUS_2);
        buttons.add(Adaptable);
        Adaptable.setData(TraitEnum.ADAPTABLE);
        buttons.add(Mechanical);
        Mechanical.setData(TraitEnum.MECHANICAL);
        buttons.add(Cyborg);
        Cyborg.setData(TraitEnum.CYBORG);
        buttons.add(Psionic);
        Psionic.setData(TraitEnum.PSIONIC);
        buttons.add(Warriors);
        Warriors.setData(TraitEnum.WARRIORS);
        buttons.add(Lithovore);
        Lithovore.setData(TraitEnum.LITHOVORE);
        buttons.add(Aquatic);
        Aquatic.setData(TraitEnum.AQUATIC);
        buttons.add(Content);
        Content.setData(TraitEnum.CONTENT);
    }

    public Pane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }

    public Scene getSpeciesCreationScene() {
        return speciesCreationScene;
    }

    public void setSpeciesCreationScene(Scene speciesCreationScene) {
        this.speciesCreationScene = speciesCreationScene;
    }
}
