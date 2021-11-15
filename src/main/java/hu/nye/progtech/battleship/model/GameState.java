package hu.nye.progtech.battleship.model;

/**
 * Store game actual position to load next time.
 */
public class GameState {

    private OpponentAI bot;
    private Player player;

    public void setBot(OpponentAI bot) {
        this.bot = bot;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public OpponentAI getBot() {
        return bot;
    }

    public Player getPlayer() {
        return player;
    }
}
