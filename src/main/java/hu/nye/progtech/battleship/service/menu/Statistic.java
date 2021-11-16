package hu.nye.progtech.battleship.service.menu;

import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.players.HighScoreTable;
import hu.nye.progtech.battleship.ui.draw.PrintWrapper;

/**
 * Print Statistic from database.
 */
public final class Statistic {

    /**
     *  Print Statistic from database.
     */
    public static void printStat(ArrayList<Player> players, Player p) {
        HighScoreTable.printHighScoreTable(players);
        MenuController.chooseMenu(p);
    }
}
