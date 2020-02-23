package sample.GalaxyData;

import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Hex {
    private ImageView sprite = new ImageView("tile_blank.png");
    private ImageView adjust = new ImageView("adjustmentlayer.png");
    private ImageView tileHover = new ImageView("select.png");
    private Label sanityTest = new Label("");
    private int x;
    private int y;
    private Star star;

    public Hex(Pane root,int x, int y){
        root.getChildren().add(sprite);
        root.getChildren().add(adjust);
        //root.getChildren().add(sanityTest);
        root.getChildren().add(tileHover);
        adjust.setBlendMode(BlendMode.OVERLAY);
        tileHover.setVisible(false);


        // looks right but has screwed up coordinates

        if(y % 2 == 0) {
            sprite.setTranslateX( (1.5*x) * sprite.getImage().getWidth());
            sprite.setTranslateY((y * (sprite.getImage().getHeight()/2))+35);

            adjust.setTranslateX( (1.5*x) * adjust.getImage().getWidth());
            adjust.setTranslateY((y * (adjust.getImage().getHeight()/2))+35);

            tileHover.setTranslateX( (1.5*x) * adjust.getImage().getWidth());
            tileHover.setTranslateY((y * (adjust.getImage().getHeight()/2))+35);

            sanityTest.setTranslateX( (1.5*x) * adjust.getImage().getWidth()+35);
            sanityTest.setTranslateY((y * (adjust.getImage().getHeight()/2))+65);
        } else {
            sprite.setTranslateX( (1.5*x) * sprite.getImage().getWidth() + (sprite.getImage().getWidth()*0.75));
            sprite.setTranslateY((y * (sprite.getImage().getHeight()/2))+35);

            adjust.setTranslateX( (1.5*x) * adjust.getImage().getWidth() + (adjust.getImage().getWidth()*0.75));
            adjust.setTranslateY((y * (adjust.getImage().getHeight()/2))+35);

            tileHover.setTranslateX( (1.5*x) * adjust.getImage().getWidth() + (adjust.getImage().getWidth()*0.75));
            tileHover.setTranslateY((y * (adjust.getImage().getHeight()/2))+35);

            sanityTest.setTranslateX( (1.5*x) * adjust.getImage().getWidth() + (adjust.getImage().getWidth()*0.75)+35);
            sanityTest.setTranslateY((y * (adjust.getImage().getHeight()/2))+65);
        }

        sanityTest.setText(x + "," + y);
        sanityTest.setTextFill(Color.WHITE);
        sanityTest.setScaleX(3);
        sanityTest.setScaleY(3);





        //sprite.setOnMouseEntered(this::temp);


        this.x = x;
        this.y = y;
    }

    public Star getStar() {
        return star;
    }

    public Hex[] findNeighbours(Hex[][] grid,int mapX,int mapY){
        Hex[] neighbours = new Hex[6];

        if(y-2 >= 0){
            neighbours[0] = grid[x][y-2];
        } else{
            neighbours[0] = null;
        }
        if(y+2 < mapY){
            neighbours[1] = grid[x][y+2];
        } else{
            neighbours[1] = null;
        }

        if(y % 2 == 0){ //even

            if(y-1 >= 0){
                neighbours[2] = grid[x][y-1];
            } else{
                neighbours[2] = null;
            }

            if(y+1 < mapY){
                neighbours[3] = grid[x][y+1];
            } else{
                neighbours[3] = null;
            }

            if(x-1 >= 0 && y+1 < mapY){
                neighbours[4] = grid[x-1][y+1];
            } else{
                neighbours[4] = null;
            }

            if(x-1 <= 0 && y-1 >= 0){
                neighbours[5] = grid[x-1][y-1];
            } else{
                neighbours[5] = null;
            }

        }
        else{ //odd

            if(x+1 < mapX && y-1 >= 0){
                neighbours[2] = grid[x+1][y-1];
            } else{
                neighbours[2] = null;
            }

            if(x+1 < mapX && y+1 < mapY){
                neighbours[3] = grid[x+1][y+1];
            } else{
                neighbours[3] = null;
            }

            if(y+1 < mapY){
                neighbours[4] = grid[x][y+1];
            } else{
                neighbours[4] = null;
            }

            if(y-1 >= 0){
                neighbours[5] = grid[x][y-1];
            } else{
                neighbours[5] = null;
            }


        }
        return neighbours;
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


    public ImageView getTileHover() {
        return tileHover;
    }

    public void setTileHover(ImageView tileHover) {
        this.tileHover = tileHover;
    }

    public Label getSanityTest() {
        return sanityTest;
    }

    public void setSanityTest(Label sanityTest) {
        this.sanityTest = sanityTest;
    }

    public ImageView getAdjust() {
        return adjust;
    }

    public void setAdjust(ImageView adjust) {
        this.adjust = adjust;
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
