package sample.UIElements;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;


public class LabelBackground {
    private ImageView sprite = new ImageView("Background.png");
    private Label label = new Label();

    public LabelBackground(String text,GridPane root,int row,int col){
        root.add(sprite,row,col);
        root.add(label,row,col);
        label.setTranslateX(12);
        label.setTranslateY(2);
        label.setFont(new Font("OCR A Extended", 12));
        label.setText(text);

        sprite.setScaleX((text.length()/10) + 1);

    }

    public LabelBackground(String text, Pane root, int row, int col){
        //root.add(sprite,row,col);
        //root.add(label,row,col);

        root.getChildren().add(sprite);
        root.getChildren().add(label);

        sprite.setTranslateX(row * sprite.getImage().getWidth());
        sprite.setTranslateY(col * sprite.getImage().getHeight());

        label.setTranslateX((row * sprite.getImage().getWidth()) +10);
        label.setTranslateY((col * sprite.getImage().getHeight()) + 10);


        label.setFont(new Font("OCR A Extended", 12));
        label.setText(text);

        sprite.setScaleX((text.length()/10) + 1);
    }

    public LabelBackground(String text, Pane root, double row, double col){

        root.getChildren().add(sprite);
        root.getChildren().add(label);

        sprite.setTranslateX(row );
        sprite.setTranslateY(col );

        label.setTranslateX(row  + 10);
        label.setTranslateY(col  + 10);


        label.setFont(new Font("OCR A Extended", 12));
        label.setText(text);

        sprite.setScaleX((text.length()/10) + 1);
    }

    public ImageView getSprite() {
        return sprite;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
