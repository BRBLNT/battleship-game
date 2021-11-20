package hu.nye.progtech.battleship.service.menu;

import java.sql.SQLOutput;

import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.game.GameProcess;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import hu.nye.progtech.battleship.ui.draw.PrintWrapper;

/**
 * Load game from file.
 */
public class LoadGame {

    private static Player playerLoaded;
    private static OpponentAI botLoaded;

    public void setPlayerLoaded(Player playerLoaded) {
        this.playerLoaded = playerLoaded;
    }

    public void setBotLoaded(OpponentAI botLoaded) {
        this.botLoaded = botLoaded;
    }

    /**
     * Loading game.
     *
     * @param player is a temporary parameter while the function not working.
     */
    public static void loadGameFromGameState(Player player) {
        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.workingaera"));
        MenuController.chooseMenu(player);
        /*
        GameProcess.initParticipants(playerLoaded, botLoaded);
        GameProcess.game();

         */
    }
}
