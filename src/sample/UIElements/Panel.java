package sample.UIElements;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Panel {
    ImageView sprite = new ImageView("Tooltip.png");
    ArrayList<Label> labels = new ArrayList<Label>();

    public Panel(){

    }

    public Panel(Pane root, String[] text,int x,int y){
        root.getChildren().add(sprite);
        sprite.setTranslateX(x);
        sprite.setTranslateY(y);

        for(int i = 0; i < text.length; i++ ) {
            Label temp = new Label(text[i]);
            labels.add(temp);
            root.getChildren().add(temp);
        }
        positionLabels();
    }

    private void positionLabels(){
        for(int i = 0; i < labels.size(); i++){
            labels.get(i).setTranslateX(sprite.getTranslateX() + 10);
            labels.get(i).setTranslateY((sprite.getTranslateY() + 10) + (i * 32) );
        }
    }
}
