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
    private static final int FIRST_SPACE = 17;
    private static final int SECOND_SPACE = 7;
    private static final int HORIZONTAL = 24 + 3;

    /**
     * Print high score table.
     */
    public static void printHighScoreTable(ArrayList<Player> players) {
        LOGGER.info("print high score table");
        PrintWrapper.printSpace(5);
        PrintWrapper.printMore(HORIZONTAL, HORIZONTAL_SEPARATOR);
        PrintWrapper.printLine("");
        PrintWrapper.print(VERTICAL_THIN_SEPARATOR);
        PrintWrapper.print("  Name           ");
        PrintWrapper.print(VERTICAL_THICK_SEPARATOR);
        PrintWrapper.print("  Wins ");
        PrintWrapper.print(VERTICAL_THICK_SEPARATOR);
        PrintWrapper.printLine("");
        PrintWrapper.printMore(HORIZONTAL, HORIZONTAL_SEPARATOR);
        PrintWrapper.printLine("");
        for (Player player : players) {
            PrintWrapper.print(VERTICAL_THIN_SEPARATOR);
            PrintWrapper.print(player.getName());
            PrintWrapper.printMore( FIRST_SPACE - player.getName().length(), " ");
            PrintWrapper.print(VERTICAL_THICK_SEPARATOR);
            PrintWrapper.print("" + player.getNumberOfWins());
            PrintWrapper.printMore(SECOND_SPACE - player.getNumberOfWins()," ");
            PrintWrapper.print(VERTICAL_THICK_SEPARATOR);
            PrintWrapper.printLine("");
            PrintWrapper.printMore(HORIZONTAL, HORIZONTAL_SEPARATOR);
            PrintWrapper.printLine("");
        }
    }
}
