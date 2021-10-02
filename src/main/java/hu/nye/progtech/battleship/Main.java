package hu.nye.progtech.battleship;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;



public class Main {
    private static int boardSize;
    private static int numberOfShips;

    private static Player player;
    private static Board board;


    public static void main(String[] args) {
        welcomeText();
        readProperties("config.properties");
        player = new Player();
        board = new Board(boardSize);
        player.setName(getPlayerName());
        player.setBoard(board);
        player.setNumberOfShips(numberOfShips);
        player.getBoard().drawEmptyBoard();
        System.out.println("\nAz alábbi táblán a kezdő- és végpozició megadásával állíthatod be a hajóidat! (minta: A1:A3)");
        System.out.println("\nA hajóid száma a következő:");

    }

    public static void readProperties(String namePropertiesFile) {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream(namePropertiesFile)) {
            Properties prop = new Properties();
            prop.load(input);
            boardSize = Integer.parseInt(prop.getProperty("board.setting.boardSize"));
            numberOfShips = Integer.parseInt(prop.getProperty("board.setting.numberOfShips"));
        } catch (IOException ex) {
            /*If config.properties non-available setup basic values*/
            boardSize = 10;
            numberOfShips = 5;
            ex.printStackTrace();
        }
    }

    private static String getPlayerName() {
        Scanner read = new Scanner(System.in);
        String readName;
        do {
            System.out.println("Add meg a nevedet: ");
            readName = read.nextLine();
            if (readName.length() < 3)
                System.out.println("Nem megfelelő hosszúságú név!");
        }
        while (readName.length() < 3);
        System.out.println("Szia "+readName+"!\n");
        return readName;
    }

    private static void welcomeText(){
        System.out.println("Üdvözöllek a Torpedó játékban!\n");
    }

}
