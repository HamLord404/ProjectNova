package sample.UIElements;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.awt.*;


public class Tooltip {
    ImageView sprite = new ImageView("Tooltip.png");
    Label text = new Label();
    Group group = new Group();


    public Tooltip(Node[] n, String text, Pane root){


        for(int i = 0; i < n.length; i++){
            n[i].setOnMouseMoved(this::showToolTip);
            n[i].setOnMouseExited(this::hideToolTip);
        }
        root.getChildren().add(sprite);
        root.getChildren().add(this.text);
        sprite.setVisible(false);
        this.text.setVisible(false);
        this.text.setText(text);
        //group.getChildren().add(this.text);
        //group.getChildren().add(sprite);

    }

    public void showToolTip(MouseEvent event){
        sprite.setVisible(true);
        text.setVisible(true);

        sprite.setTranslateX(MouseInfo.getPointerInfo().getLocation().x - 300);
        sprite.setTranslateY(MouseInfo.getPointerInfo().getLocation().y - 100);

        text.setTranslateX(MouseInfo.getPointerInfo().getLocation().x - 290);
        text.setTranslateY(MouseInfo.getPointerInfo().getLocation().y - 90);

    }

    public void hideToolTip(MouseEvent event){
        sprite.setVisible(false);
        text.setVisible(false);
    }
}
