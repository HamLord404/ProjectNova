package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Enums.Ideology;
import sample.GalaxyData.Hex;
import sample.Screens.MainMenuScreen;
import sample.Screens.SpeciesCreationScreen;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {

    ArrayList<Hex> overlay = new ArrayList<Hex>();
    Pane root = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception{



        ArrayList<PoliticalParty> parties = new ArrayList<>();
        for(int i =0; i < 6; i++){
            System.out.println(generateParty(Ideology.values()[i]).getName());
        }

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));


        MainMenuScreen mm = new MainMenuScreen(primaryStage);
        primaryStage.setScene(mm.mainMenuScene);

        //SpeciesCreationScreen sp = new SpeciesCreationScreen(primaryStage);
        //primaryStage.setScene(sp.getSpeciesCreationScene());


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public PoliticalParty generateParty(Ideology idea){
        String prefixes[] = {"Alliance of ","Coalition of ","League of ","Union of ","Order of "};
        String suffixes[] = {" Alliance"," Party"," League"," Union"," Order"," Council"};
        String baseMil[] = {"Warriors","The Military","Strength","Domination","Supremacy","Knights","Protection"};
        String baseTech[] = {"Progress","Atoms","Thinkers","Knowledge","The Future","Discovery","Rationalism"};
        String baseAut[] = {"Iron","Imperialism","Totalism","Unity","Security","Monocracy","Disiplinary"};
        String basePas[] = {"Peace","Commerce","Love","Merchants","Prosperity","Corporate"};
        String baseEga[] = {"Freedom","Equality","The Revolutionary","Liberty","Sufferage","Commonwealth","The Representative"};
        String baseRel[] = {"Purity","Holiness","Light","Faith","The Divine","The Priesthood"};
        String ideas[][] = {baseMil,basePas,baseRel,baseTech,baseEga,baseAut};
        PoliticalParty newParty = new PoliticalParty();
        Random r = new Random();
        if(r.nextBoolean() == true){
            String p = prefixes[r.nextInt(prefixes.length)];
            String b = ideas[idea.ordinal()][r.nextInt(ideas[idea.ordinal()].length)];
            newParty.setName(p + b);
        } else {
            String s = suffixes[r.nextInt(suffixes.length)];
            String b = ideas[idea.ordinal()][r.nextInt(ideas[idea.ordinal()].length)];
            newParty.setName(b + s);
        }
        return newParty;

    }

    public void generateHexGrid(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){

                overlay.add(new Hex(root,i,j));

            }
        }
    }
}
