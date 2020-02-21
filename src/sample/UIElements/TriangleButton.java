package sample.UIElements;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TriangleButton {
    private ImageView sprite = new ImageView("arrow_button_right.png");

    public TriangleButton(Pane root, double x, double y,boolean right){
        root.getChildren().add(sprite);
        sprite.setTranslateX(x);
        sprite.setTranslateY(y);
        sprite.setScaleX(0.3);
        sprite.setScaleY(0.3);

        if(!right){
            sprite.setImage(new Image("arrow_button_left.png"));
        }

    }

    public ImageView getSprite() {
        return sprite;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }
}
