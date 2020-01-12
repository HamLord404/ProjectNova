package sample.UIElements;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import sample.Dictionaries.TraitDictionary;
import sample.Enums.TraitEnum;

import java.util.ArrayList;


public class ToggleButton {
    private ImageView sprite = new ImageView("UnclickedPick.png");
    private ArrayList<ToggleButton> mutuallyExclusive = new ArrayList<>();
    private boolean active = false;
    private Label label = new Label();
    private Enum data;



    public ToggleButton(GridPane root,int row,int col){
        sprite.setOnMouseClicked(this::clickFeedback);
        root.add(sprite,row,col);
    }
    public ToggleButton(GridPane root,int row,int col,String text){
        sprite.setOnMouseClicked(this::clickFeedback);
        label.setOnMouseClicked(this::clickFeedback);
        root.add(sprite,row,col);
        root.add(label,row,col);
        label.setTranslateX(42);
        label.setTranslateY(2);
        label.setFont(new Font("OCR A Extended", 12));
        label.setText(text);
    }

    public ToggleButton(Pane root,int row,int col,String text){
        sprite.setOnMouseClicked(this::clickFeedback);
        label.setOnMouseClicked(this::clickFeedback);
        root.getChildren().add(sprite);
        root.getChildren().add(label);
        //sprite.setTranslateX(row * sprite.getImage().getWidth());
        //sprite.setTranslateY(col * sprite.getImage().getHeight());
        sprite.setTranslateX(row * sprite.getImage().getWidth());
        sprite.setTranslateY(col * sprite.getImage().getHeight());


        label.setTranslateX((row * sprite.getImage().getWidth())+ 42);
        label.setTranslateY( (col * sprite.getImage().getHeight()) + 10);
        label.setFont(new Font("OCR A Extended", 12));
        label.setText(text);
    }

    public void clickFeedback(MouseEvent event){
        active = !active;
        if(active) {
            sprite.setImage(new Image("clickedPick.png"));
        } else {
            sprite.setImage(new Image("UnclickedPick.png"));
        }



    }

    public void addExclusive(ToggleButton t){
        mutuallyExclusive.add(t);
        t.getMutuallyExclusive().add(this);
    }


    public ArrayList<ToggleButton> getMutuallyExclusive() {
        return mutuallyExclusive;
    }

    public void setMutuallyExclusive(ArrayList<ToggleButton> mutuallyExclusive) {
        this.mutuallyExclusive = mutuallyExclusive;
    }

    public ImageView getSprite() {
        return sprite;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Enum getData() {
        return data;
    }

    public void setData(Enum data) {
        this.data = data;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
