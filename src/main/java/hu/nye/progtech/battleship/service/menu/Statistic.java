package hu.nye.progtech.battleship.service.menu;

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
    public static void printStat(Player p) {
        //null set array
        //Arrays.sort();
        HighScoreTable.printHighScoreTable(null);
        //PrintWrapper.printLine("Not working. Try it later...");
        MenuController.chooseMenu(p);
    }
}
