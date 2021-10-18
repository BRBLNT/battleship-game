package hu.nye.progtech.battleship.service.menu;

import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.properties.ConfigReader;

/**
 * Start game menu.
 */
public final class StartGame {

    /**
     * Start game if everything is set.
     */
    public static void startGame(Player player) {
        if (player.getName() == null) {
            System.out.println(ConfigReader.getPropertyFromConfig("game.text.name.notset"));
            MenuController.chooseMenu(player);
        } else if (!MenuController.isIsShipsSet()) {
            System.out.println(ConfigReader.getPropertyFromConfig("game.text.ship.notset"));
            MenuController.chooseMenu(player);
        } else {
            /*
            Here is the game
             */
        }

    }
}
