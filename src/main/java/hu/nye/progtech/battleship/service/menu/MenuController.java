package hu.nye.progtech.battleship.service.menu;

import static hu.nye.progtech.battleship.service.menu.Exit.exit;

import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import hu.nye.progtech.battleship.ui.draw.PrintWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Menu controller call different menus if user choose it.
 */
public final class MenuController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    private static String setName;
    private static String startGame;
    private static String setShips;
    private static String exit;
    private static boolean isShipsSet = false;

    public static void setIsShipsSet(boolean isShipsSet) {
        MenuController.isShipsSet = isShipsSet;
    }

    public static boolean isIsShipsSet() {
        return isShipsSet;
    }

    public static void setSetName(String setName) {
        MenuController.setName = setName;
    }

    public static void setStartGame(String startGame) {
        MenuController.startGame = startGame;
    }

    public static void setSetShips(String setShips) {
        MenuController.setShips = setShips;
    }

    public static void setExit(String exit) {
        MenuController.exit = exit;
    }

    private static void menuText() {
        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.choose"));
        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.type") + " " +
                startGame + " " + ConfigReader.getPropertyFromConfig("game.text.start"));
        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.type") + " " +
                setName + " " + ConfigReader.getPropertyFromConfig("game.text.set.name"));
        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.type") + " " +
                setShips + " " + ConfigReader.getPropertyFromConfig("game.text.set.ship"));
        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.type") + " " +
                exit + " " + ConfigReader.getPropertyFromConfig("game.text.exit"));

    }

    /**
     * Choose menu in the game we can set name, set ships , start game or exit the game.
     */
    public static void chooseMenu(Player player) {
        menuText();
        String command;
        boolean run = true;
        do {
            command = UserInputReader.readInput().toUpperCase();
            if (command.equals(startGame)) {
                LOGGER.info("choose start");
                StartGame.startGame(player);
                run = false;
            } else if (command.equals(setName)) {
                LOGGER.info("choose set name");
                SetName.setName(player);
                run = false;
            } else if (command.equals(setShips)) {
                LOGGER.info("choose set ships");
                SetShip.setShip(player);
                run = false;
            } else if (command.equals(exit)) {
                LOGGER.info("choose exit");
                exit();
            } else {
                System.out.println(ConfigReader.getPropertyFromConfig("game.text.notvalidcommand"));
                LOGGER.warn("invalid command!");
            }
        } while (run);
    }
}
