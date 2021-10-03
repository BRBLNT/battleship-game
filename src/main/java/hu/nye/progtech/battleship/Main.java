package hu.nye.progtech.battleship;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;


public class Main {
    private static int boardSize;
    private static int numberOfShips;

    private static Properties prop = new Properties();;

    private static Player player;
    private static Board board;


    public static void main(String[] args) {
        activity();
    }

    private static void activity(){
        readProperties("config.properties");
        welcomeText();
        player = new Player();
        board = new Board(boardSize);
        player.setName(getPlayerName());
        player.setBoard(board);
        player.setNumberOfShips(numberOfShips);
        player.getBoard().drawEmptyBoard();
        System.out.println("\nAz alábbi táblán a kezdő- és végpozició megadásával állíthatod be a hajóidat! (minta: A1:A3)");
        System.out.println("\nA hajóid száma a következő:" + player.getNumberOfShips());
    }


    private static void readProperties(String namePropertiesFile) {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream(namePropertiesFile)) {
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
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(120).height(20);
        builder.element(new PseudoText(prop.getProperty("game.text.name")));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println("Aktuális verzió: "+ prop.getProperty("game.settings.version"));
        System.out.println(s);
        System.out.print(prop.getProperty("game.text.welcome")+"\n");
    }

}
