package hu.nye.progtech.battleship;

import hu.nye.progtech.battleship.service.game.GameController;

/**
 * Entry point of the game.
 */
public class Main {
    /**
     * Entrypoint of the game.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        GameController gl = new GameController();
        GameController.init("config.properties");
        GameController.chooseMenu();
    }


}
