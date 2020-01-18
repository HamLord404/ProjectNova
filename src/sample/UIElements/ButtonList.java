package sample.UIElements;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ButtonList {
    ArrayList<Button> buttons = new ArrayList<>();
    Group group = new Group();
    Pane root;


    public ButtonList(Pane root,String[] buttonTexts,int posX,int posY){
        this.root = root;
        for(int i = 0; i < buttonTexts.length; i++){
            Button newButton = new Button(buttonTexts[i],root,0,i);
            newButton.getSegmentGroup().setTranslateY(i * (newButton.getSprite().getImage().getHeight()-10));
            newButton.getLabel().setTranslateY(newButton.getSegmentGroup().getTranslateY()+10);
            buttons.add(newButton);
            group.getChildren().add(newButton.getSegmentGroup());
            group.getChildren().add(newButton.getLabel());
        }

        System.out.println("ButtonList");

        group.setTranslateX(posX);
        group.setTranslateY(posY);
        root.getChildren().add(group);
    }


}
