package sample.Screens;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import sample.UIElements.LabelBackground;
import sample.UIElements.Panel;

public class ColonyScreen {
    Pane root = new Pane();
    Scene ColonyScene = new Scene(root,1000,500);
    LabelBackground production = new LabelBackground("Production",root,0,10);
    String[] statsText;
    Panel stats = new Panel(root,statsText,0,32);



}
