package hu.nye.progtech.battleship.service.menu;

import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.game.GameProcess;

/**
 * Load game from file.
 */
public class LoadGame {

    private Player playerLoaded;
    private OpponentAI botLoaded;

    public void setPlayerLoaded(Player playerLoaded) {
        this.playerLoaded = playerLoaded;
    }

    public void setBotLoaded(OpponentAI botLoaded) {
        this.botLoaded = botLoaded;
    }

    public void loadGameToGameState() {
        GameProcess.initParticipants(playerLoaded, botLoaded);
        GameProcess.game();
    }
}
