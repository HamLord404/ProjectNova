package sample.UIElements;


import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.ArrayList;


public class Button {
    private ImageView sprite = new ImageView("Button.png");
    private Label label = new Label();
    private ArrayList<ImageView> segments = new ArrayList<>();
    private Group segmentGroup = new Group();


    public Button(String text, GridPane root,int row,int col){

        segmentGroup.getChildren().add(sprite);
        root.add(segmentGroup,row,col);
        root.add(label,row,col);
        label.setText(text);
        label.setFont(new Font("OCR A Extended", 12));
        label.setTranslateX(12);
    }

    public Button(String text, Pane root, int posX, int posY){



        label.setText(text);
        label.setFont(new Font("OCR A Extended", 12));
        correctSize(root,posX, posY);
        root.getChildren().add(label);
        label.setTranslateX(posX + 12);
        label.setTranslateY(posY + 12);
    }

    public void correctSize(Pane root, int posX,int posY){
        ImageView temp = new ImageView("ButtonFront.png");
        segments.add(temp);
        temp.setTranslateX(posX);
        temp.setTranslateY(posY);


        int middleSegments = (int)(label.getText().length() * 0.8);
        for(int i = 0; i < middleSegments; i++){
            temp = new ImageView("ButtonMiddle.png");
            segments.add(temp);
            temp.setTranslateX(posX + ((i+1) * temp.getImage().getWidth()));
            temp.setTranslateY(posY);
        }

        temp = new ImageView("ButtonBack.png");
        segments.add(temp);
        temp.setTranslateX(posX + ((middleSegments+1) * temp.getImage().getWidth()));
        temp.setTranslateY(posY);

        for(int i = 0; i < segments.size(); i++){
            //root.getChildren().add(segments.get(i));
            segmentGroup.getChildren().add(segments.get(i));
        }
        root.getChildren().add(segmentGroup);

    }

    public ImageView getSprite() {
        return sprite;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }

    public Group getSegmentGroup() {
        return segmentGroup;
    }

    public void setSegmentGroup(Group segmentGroup) {
        this.segmentGroup = segmentGroup;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
