package hu.nye.progtech.battleship;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        readProperties("config.properties");
    }

    public static void readProperties(String namePropertiesFile){
        try ( InputStream input = Main.class.getClassLoader().getResourceAsStream(namePropertiesFile)){
            Properties prop = new Properties();
            prop.load(input);

            System.out.println(prop.getProperty("board.setting.boardSizeX"));
            System.out.println(prop.getProperty("board.setting.boardSizeY"));
            System.out.println(prop.getProperty("board.setting.numberOfShips"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
