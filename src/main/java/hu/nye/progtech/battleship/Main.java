package hu.nye.progtech.battleship;

import java.util.Scanner;

import hu.nye.progtech.battleship.service.game.GameController;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;

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
        GameController.init("config.properties", new UserInputReader(new Scanner(System.in)));
    }


}
