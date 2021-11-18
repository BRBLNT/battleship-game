package hu.nye.progtech.battleship.service.players;

import java.util.ArrayList;

import hu.nye.progtech.battleship.model.Player;

/**
 * If player name exist in DB update the wins.
 */
public class PlayerIsExist {

    /**
     * Search player in list return with wins.
     */
    public static int numberOfWinsSet(Player p, ArrayList<Player> players) {
        int wins = 0;
        for (Player temp : players) {
            if (p.getName().equals(temp.getName())) {
                wins = temp.getNumberOfWins();
                break;
            }
        }
        return wins;
    }
}
