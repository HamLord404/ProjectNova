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
            group.getChildren().add(newButton.getSegmentGroup());
            group.getChildren().add(newButton.getLabel());
        }

        group.setTranslateX(posX);
        group.setTranslateY(posY);
    }


}
