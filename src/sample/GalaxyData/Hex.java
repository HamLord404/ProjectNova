package sample.GalaxyData;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;



public class Hex {
    private ImageView sprite = new ImageView("tile_blank.png");
    private int x;
    private int y;
    private Star star;

    public Hex(Pane root,int x, int y){
        root.getChildren().add(sprite);


        if(y % 2 == 0) {
            sprite.setTranslateX( (1.5*x) * sprite.getImage().getWidth());
            sprite.setTranslateY((y * (sprite.getImage().getHeight()/2))+35);
        } else {
            sprite.setTranslateX( (1.5*x) * sprite.getImage().getWidth() + (sprite.getImage().getWidth()*0.75));
            sprite.setTranslateY((y * (sprite.getImage().getHeight()/2))+35);
        }

        //sprite.setOnMouseEntered(this::temp);


        this.x = x;
        this.y = y;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
        if(star.getType() != StarType.NONE){
            sprite.setImage(new Image("startilenew.png"));
        } else{
            sprite.setImage(new Image("tile_blank.png"));
        }
    }

    public void temp(MouseEvent event){
        System.out.println("x: " + x + " y: " + y);
    }

    public ImageView getSprite() {
        return sprite;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
