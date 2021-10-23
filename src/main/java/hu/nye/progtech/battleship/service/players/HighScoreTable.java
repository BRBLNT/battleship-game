package hu.nye.progtech.battleship.service.players;

import java.util.ArrayList;

import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.ui.draw.PrintWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generate high score table and print it.
 */
public class HighScoreTable {
    private static final Logger LOGGER = LoggerFactory.getLogger(HighScoreTable.class);

    private static final String HORIZONTAL_SEPARATOR = "=";
    private static final String VERTICAL_THIN_SEPARATOR = "|";
    private static final String VERTICAL_THICK_SEPARATOR = "||";

    /**
     * Print high score table.
     */
    public void printHighScoreTable(ArrayList<Player> players) {
        LOGGER.info("print high score table");
        PrintWrapper.printSpace(5);
        PrintWrapper.printMore(20, HORIZONTAL_SEPARATOR);
        PrintWrapper.print(VERTICAL_THIN_SEPARATOR);
        PrintWrapper.print("  Name  ");
        PrintWrapper.print(VERTICAL_THICK_SEPARATOR);
        PrintWrapper.print("Wins");
        PrintWrapper.print(VERTICAL_THICK_SEPARATOR);
        PrintWrapper.print("Rate");
        PrintWrapper.print(VERTICAL_THIN_SEPARATOR);
        PrintWrapper.printMore(20, HORIZONTAL_SEPARATOR);
        for (Player player : players) {
            PrintWrapper.print(VERTICAL_THIN_SEPARATOR);
            PrintWrapper.print("        ");
            PrintWrapper.print(VERTICAL_THICK_SEPARATOR);
            PrintWrapper.print("    ");
            PrintWrapper.print(VERTICAL_THICK_SEPARATOR);
            PrintWrapper.print("    ");
            PrintWrapper.print(VERTICAL_THIN_SEPARATOR);
            PrintWrapper.printMore(15, HORIZONTAL_SEPARATOR);
        }
    }
}
