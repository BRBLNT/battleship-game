package hu.nye.progtech.battleship.service.players;

import java.util.ArrayList;

import hu.nye.progtech.battleship.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HighScoreTable {
    private static final Logger LOGGER = LoggerFactory.getLogger(HighScoreTable.class);

    private static final String HORIZONTAL_SEPARATOR = "=";
    private static final String VERTICAL_THIN_SEPARATOR = " | ";
    private static final String VERTICAL_THICK_SEPARATOR = " || ";
    private static final String LEFT_SIDE_VERTICAL_THICK_SEPARATOR = "|| ";
    private static final String RIGHT_SIDE_VERTICAL_THICK_SEPARATOR = " ||";

    public void printHighScoreTable(ArrayList<Player> players) {
        LOGGER.info("print high score table");

        for (Player player: players) {

        }
    }
}
