package hu.nye.progtech.battleship.service.game;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;
import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import hu.nye.progtech.battleship.service.menu.MenuController;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Game Controller use other classes to control the game process.
 */
public class GameController {

    private static UserInputReader uir;
    private static ConfigReader CR;

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
    public static void init(String config, UserInputReader uirp) {
        try {
            CR = new ConfigReader(config);
        } catch (ConfigurationNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        MenuController.setSetName(CR.getPropertyFromConfig("game.control.set.name"));
        MenuController.setStartGame(CR.getPropertyFromConfig("game.control.start"));
        MenuController.setSetShips(CR.getPropertyFromConfig("game.control.set.ship"));
        MenuController.setExit(CR.getPropertyFromConfig("game.control.exit"));
        player = createPlayer();
        uir = uirp;
        welcomeText();
        LOGGER.info("initialization");
        MenuController.chooseMenu(player);

    }

    private static Player createPlayer() {
        return new Player(new Board(Integer.parseInt(CR.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(CR.getPropertyFromConfig("board.setting.numberofships")));
    }









}
