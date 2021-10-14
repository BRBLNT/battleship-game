package hu.nye.progtech.battleship.service.game;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;
import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.model.Ship;
import hu.nye.progtech.battleship.service.coordinate.CoordinateConverter;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import hu.nye.progtech.battleship.service.exception.NotValidPositionException;
import hu.nye.progtech.battleship.service.exception.PositionNotValidForSizeException;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import hu.nye.progtech.battleship.service.modify.BoardModifier;
import hu.nye.progtech.battleship.service.validate.impl.PositionValidatorImpl;
import hu.nye.progtech.battleship.ui.draw.impl.CommandLineDrawImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Game Controller use other classes to control the game process.
 */
public class GameController {

    private static final Properties PROP = new Properties();
    private static final UserInputReader UIR = new UserInputReader(new Scanner(System.in));
    private static final PositionValidatorImpl POSITION_VALIDATOR = new PositionValidatorImpl();
    private static final CoordinateConverter COORDINATE_CONVERTER = new CoordinateConverter();
    private static final BoardModifier BOARD_MODIFIER = new BoardModifier();
    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);
    private static Player player;
    private static String setName;
    private static String startGame;
    private static String setShips;
    private static String exit;
    private static boolean isShipsSet = false;

    private static void readProperties(String namePropertiesFile) throws ConfigurationNotFoundException {
        try (InputStream input = GameController.class.getClassLoader().getResourceAsStream(namePropertiesFile)) {
            PROP.load(input);
            LOGGER.info("read config file successfully!");
        } catch (IOException ex) {
            LOGGER.error("configuration is missing!");
            throw new ConfigurationNotFoundException("Cannot load configuration file! Failed to start game!");
        }
    }

    private static void welcomeText() {
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(120).height(20);
        builder.element(new PseudoText(PROP.getProperty("game.text.name")));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(PROP.getProperty("game.text.actual.version") + " " + PROP.getProperty("game.settings.version"));
        System.out.println(s);
        System.out.print(PROP.getProperty("game.text.welcome") + "\n");
    }

    private static void exitText() {
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(120).height(20);
        builder.element(new PseudoText(PROP.getProperty("game.text.exit.text")));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(s);
    }

    private static void menuText() {
        System.out.println(PROP.getProperty("game.text.choose"));
        System.out.println(PROP.getProperty("game.text.type") + " " + startGame + " " + PROP.getProperty("game.text.start"));
        System.out.println(PROP.getProperty("game.text.type") + " " + setName + " " + PROP.getProperty("game.text.set.name"));
        System.out.println(PROP.getProperty("game.text.type") + " " + setShips + " " + PROP.getProperty("game.text.set.ship"));
        System.out.println(PROP.getProperty("game.text.type") + " " + exit + " " + PROP.getProperty("game.text.exit"));

    }

    /**
     * Init properties file and menu commands.
     */
    public static void init(String config) {
        try {
            readProperties(config);
        } catch (ConfigurationNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        setName = PROP.getProperty("game.control.set.name");
        startGame = PROP.getProperty("game.control.start");
        setShips = PROP.getProperty("game.control.set.ship");
        exit = PROP.getProperty("game.control.exit");
        player = createPlayer();
        welcomeText();
        LOGGER.info("initialization");

    }

    /**
     * Show menu items, and we can choose when type the correct command.
     */
    public static void chooseMenu() {
        menuText();
        String command;
        boolean run = true;
        do {
            command = UIR.readInput().toUpperCase();
            if (command.equals(startGame)) {
                LOGGER.info("choose start");
                startGame();
                run = false;
            } else if (command.equals(setName)) {
                LOGGER.info("choose set name");
                setName();
                run = false;
            } else if (command.equals(setShips)) {
                LOGGER.info("choose set ships");
                setShip();
                run = false;
            } else if (command.equals(exit)) {
                LOGGER.info("choose exit");
                exit();
            } else {
                System.out.println(PROP.getProperty("game.text.notvalidcommand"));
                LOGGER.warn("invalid command!");
            }
        } while (run);
    }

    private static void startGame() {
        if (player.getName() == null) {
            System.out.println(PROP.getProperty("game.text.name.notset"));
            chooseMenu();
        } else if (!isShipsSet) {
            System.out.println(PROP.getProperty("game.text.ship.notset"));
            chooseMenu();
        } else {
            new CommandLineDrawImpl().drawBoard(player.getBoard());
        }

    }

    private static void setName() {
        player.setName(getPlayerName());
        if (player.getName() != null) {
            chooseMenu();
        }
    }

    private static void setShip() {
        new CommandLineDrawImpl().drawBoard(player.getBoard());
        System.out.println(PROP.getProperty("game.text.set.ship.info"));
        int i = 0;
        do {
            re:
            {
                String line = UIR.readInput();
                try {
                    POSITION_VALIDATOR.validate(COORDINATE_CONVERTER.sizeCalculator(line), line,
                            Integer.parseInt(PROP.getProperty("board.setting.numberofships")));
                } catch (PositionNotValidForSizeException | CoordinateFormatException | NotValidPositionException e) {
                    LOGGER.warn("coordinates fault");
                    System.out.println(PROP.getProperty("game.text.set.ship.warn"));
                    System.out.println(PROP.getProperty("game.text.set.ship.info"));
                    break re;
                }
                for (Ship ship : player.getShips()) {
                    if (ship.getSize() == COORDINATE_CONVERTER.sizeCalculator(line) && ship.getPosX() == 0 && ship.getPosY() == 0) {
                        ship.setPosX(Integer.parseInt(POSITION_VALIDATOR.convertPosition(line.split(":")[0])));
                        ship.setPosY(Integer.parseInt(POSITION_VALIDATOR.convertPosition(line.split(":")[1])));
                        player.getBoard().setMatrixForBoard(BOARD_MODIFIER.modifyBoard(player.getBoard(), ship));
                        new CommandLineDrawImpl().drawBoard(player.getBoard());
                        System.out.println(PROP.getProperty("game.text.ship.add"));
                        i++;
                    }
                }
                if (line.length() > 5 || !line.contains(":")) {
                    System.out.println(PROP.getProperty("game.text.set.ship.info"));
                }
                break re;
            }
        } while (i != player.getNumberOfShips());
        isShipsSet = true;
        chooseMenu();
    }

    private static void exit() {
        exitText();
        LOGGER.info("Exit game");
        System.exit(0);
    }


    private static Player createPlayer() {
        return new Player(new Board(Integer.parseInt(PROP.getProperty("board.setting.board.size"))),
                Integer.parseInt(PROP.getProperty("board.setting.numberofships")));
    }

    private static String getPlayerName() {
        String readName;
        do {
            System.out.println(PROP.getProperty("game.text.name.get"));
            readName = UIR.readInput();
            if (readName.length() < 3) {
                System.out.println(PROP.getProperty("game.text.name.length"));
                LOGGER.warn("name length not enough");
            }
        } while (readName.length() < 3);
        System.out.println(PROP.getProperty("game.text.name.welcome") + " " + readName + "!\n");
        LOGGER.info("name set successfully actual name:" + readName);
        return readName;
    }


}
