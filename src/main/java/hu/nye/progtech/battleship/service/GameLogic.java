package hu.nye.progtech.battleship.service;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;
import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class GameLogic {
    /*
    Variables
     */
    private static Properties prop = new Properties();
    private static Player player;
    private static String setName;
    private static String changeName;
    private static String startGame;
    private static String setShips;
    private static String exit;

    /*
    Values set
     */
    private static void readProperties(String namePropertiesFile) throws ConfigurationNotFoundException {
        try (InputStream input = GameLogic.class.getClassLoader().getResourceAsStream(namePropertiesFile)) {
            prop.load(input);
        } catch (IOException ex) {
            throw new ConfigurationNotFoundException("Cannot load configuration file! Failed to start game!");
        }
    }


    /*
    Messages
     */
    private static void welcomeText(){
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(120).height(20);
        builder.element(new PseudoText(prop.getProperty("game.text.name")));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(prop.getProperty("game.text.actual.version")+" "+ prop.getProperty("game.settings.version"));
        System.out.println(s);
        System.out.print(prop.getProperty("game.text.welcome")+"\n");
    }

    private static void menuText(){
        System.out.println(prop.getProperty("game.text.choose"));
        System.out.println(prop.getProperty("game.text.type")+" "+startGame+" "+prop.getProperty("game.text.start"));
        System.out.println(prop.getProperty("game.text.type")+" "+setName+" "+prop.getProperty("game.text.setname"));
        System.out.println(prop.getProperty("game.text.type")+" "+changeName+" "+prop.getProperty("game.text.changeName"));
        System.out.println(prop.getProperty("game.text.type")+" "+setShips+" "+prop.getProperty("game.text.setships"));
        System.out.println(prop.getProperty("game.text.type")+" "+exit+" "+prop.getProperty("game.text.exit"));

    }


    /*
    Runtime
     */

    public static void init(){
        try {
            readProperties("config.properties");
        } catch (ConfigurationNotFoundException e) {
            e.printStackTrace();
        }
        setName = prop.getProperty("game.controll.setname");
        changeName = prop.getProperty("game.controll.changename");
        startGame = prop.getProperty("game.controll.start");
        setShips = prop.getProperty("game.controll.setships");
        exit = prop.getProperty("game.controll.exit");


        player = createPlayer();
        welcomeText();


    }
    public static void chooseMenu(){
        menuText();
        Scanner read = new Scanner(System.in);
        String command;
        boolean run = true;
        do{
            command = "";
            command = read.nextLine().toUpperCase();
            if(command.equals(startGame)){
                startGame();
                run = false;
            }
            else if(command.equals(setName)){
                setName();
                run = false;
            }
            else if(command.equals(changeName)){
                changeName();
                run = false;
            }
            else if(command.equals(setShips)){
                setShip();
                run = false;
            }
            else if(command.equals(exit)){
                exit();
            }
            else{
                System.out.println(prop.getProperty("game.text.notvalidcommand"));
            }
        }while(run);
    }

    private static void startGame(){
        if(player.getName() == null){
            System.out.println(prop.getProperty("game.text.namenotset"));
            chooseMenu();
        }
        else{
            player.getBoard().drawBoard();
        }

    }
    private static void setName(){
        player.setName(getPlayerName());
        if(player.getName() != null){
            chooseMenu();
        }
    }
    private static void changeName(){
        player.setName(getPlayerName());
        if(player.getName() != null){
            chooseMenu();
        }
    }
    private static void setShip(){}
    private static void exit(){
        System.exit(0);
    }



    /*
    Methods
     */
    private static Player createPlayer(){
        Player tmp = new Player(new Board(Integer.parseInt(prop.getProperty("board.setting.boardSize"))),Integer.parseInt(prop.getProperty("board.setting.numberOfShips")));
        return tmp;
    }

    private static String getPlayerName() {
        Scanner read = new Scanner(System.in);
        String readName;
        do {
            System.out.println(prop.getProperty("game.text.name.get"));
            readName = read.nextLine();
            if (readName.length() < 3)
                System.out.println(prop.getProperty("game.text.name.lenght"));
        }
        while (readName.length() < 3);
        System.out.println(prop.getProperty("game.text.name.welcome")+" "+readName+"!\n");
        return readName;
    }



}
