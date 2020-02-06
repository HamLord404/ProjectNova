package sample.Util;

import javafx.scene.image.ImageView;

public class Scaler {

    public static void ScaleImage(ImageView sprite, double amount,double offsetX,double offsetY){
        sprite.setScaleX(amount);
        sprite.setScaleY(amount);
        sprite.setTranslateX(-(sprite.getImage().getWidth() * amount) + offsetX);
        sprite.setTranslateY(-(sprite.getImage().getHeight() * amount) + offsetY);

    }
}
