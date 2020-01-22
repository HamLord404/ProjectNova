package sample.UIElements;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class SmallButton {
    private ImageView sprite = new ImageView("SmallButton.png");
    private Label text = new Label("");

    public SmallButton(Pane root, String text, int xPos, int yPos){
        sprite.setTranslateX(xPos);
        sprite.setTranslateY(yPos);
        this.text.setTranslateX(xPos + 12);
        this.text.setTranslateY(yPos + 8);
        this.text.setText(text);
        root.getChildren().add(sprite);
        root.getChildren().add(this.text);
    }


    public ImageView getSprite() {
        return sprite;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }

    public Label getText() {
        return text;
    }

    public void setText(Label text) {
        this.text = text;
    }
}
