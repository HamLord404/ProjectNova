package sample.FileManaging;

import sample.GalaxyData.Galaxy;
import sample.GalaxyData.Planet;
import sample.GalaxyData.Star;

import java.io.FileWriter;
import java.io.IOException;

public class GameSaver {
    static String filename = "Project Nova.txt";
    static FileWriter fw;

    static {
        try {
            fw = new FileWriter(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveGame(Galaxy galaxy) throws IOException {
        fw.append(galaxy.getMapX() + "");
        fw.append(galaxy.getMapY() + "");

        for(int i = 0; i < galaxy.getMapX(); i++){
            for(int j = 0; j < galaxy.getMapY(); j++){
                Star temp = galaxy.getGrid()[i][j];
                fw.append(temp.getType().ordinal() + "," +
                        temp.getPlanets().size());
                if(temp.getPlanets().size() != 0){
                    String s = "";

                    for(int p = 0; p < temp.getPlanets().size(); p++){
                        Planet planet = temp.getPlanets().get(p);
                        s = s + planet.getName() + "," +
                                planet.getBiome().ordinal() + "," + planet.getGrav().ordinal() + ","
                                + planet.getTemp().ordinal();
                        fw.append(s);
                    }
                }
            }
        }


        fw.close();
    }

    public GameSaver() throws IOException {
    }
}
