package sample.UIElements;


import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Background {
    ImageView background = new ImageView("space_bg.png");


    public Background(Pane root){
        root.getChildren().add(background);
        background.toBack();
    }
}
