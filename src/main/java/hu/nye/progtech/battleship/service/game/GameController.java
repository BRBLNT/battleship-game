package hu.nye.progtech.battleship.service.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;
import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.persistance.SavePlayersToRepository;
import hu.nye.progtech.battleship.persistance.impl.SavePlayersToRepositoryJDBC;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.input.UserInput;
import hu.nye.progtech.battleship.service.menu.MenuController;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Game Controller use other classes to control the game process.
 */
public class GameController {

    private static UserInput uir;
    private static ConfigReader cr;
    private static SavePlayersToRepository db;
    private static ArrayList<Player> players;

    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);
    private static Player player;


    private static void welcomeText() {
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(120).height(20);
        builder.element(new PseudoText(ConfigReader.getPropertyFromConfig("game.text.name")));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(ConfigReader.getPropertyFromConfig("game.text.actual.version") + " " +
                ConfigReader.getPropertyFromConfig("game.settings.version"));
        System.out.println(s);
        System.out.print(ConfigReader.getPropertyFromConfig("game.text.welcome") + "\n");
    }


    /**
     * Init properties file and set menu commands.
     */
    public GameController(String config, UserInput userInputReader, Connection connection) {
        try {
            cr = new ConfigReader(config);
        } catch (ConfigurationNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        MenuController.setSetName(cr.getPropertyFromConfig("game.control.set.name"));
        MenuController.setStartGame(cr.getPropertyFromConfig("game.control.start"));
        MenuController.setSetShips(cr.getPropertyFromConfig("game.control.set.ship"));
        MenuController.setExit(cr.getPropertyFromConfig("game.control.exit"));
        MenuController.setHs(cr.getPropertyFromConfig("game.control.hs"));
        player = createPlayer();
        uir = userInputReader;
        welcomeText();
        try {
            db = new SavePlayersToRepositoryJDBC(connection);
            players = (ArrayList<Player>) db.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("initialization");
    }

    public void start() {
        MenuController.setPlayerList(players);
        MenuController.chooseMenu(player);
    }

    public static void savePlayer(Player p) {
        db.save(p);
    }

    private static Player createPlayer() {
        return new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(cr.getPropertyFromConfig("board.setting.numberofships")));
    }









}
