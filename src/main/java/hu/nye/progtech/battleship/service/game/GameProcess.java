package hu.nye.progtech.battleship.service.game;

import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import hu.nye.progtech.battleship.ui.draw.PrintWrapper;

/**
 * This class manage game process.
 */
public class GameProcess {
    private static Player player;
    private static OpponentAI ai;

    public static void initParticipants(Player p, OpponentAI oai) {
        player = p;
        ai = oai;
    }

    /**
     * Players always start the game.
     */
    public static void game() {
        PrintWrapper.printLine(
                ConfigReader.getPropertyFromConfig("game.text.opponentname") + " " + ai.getName() + " !");
    }

    private static void playerStep() {
        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.playerturn"));
    }

    private static void botStep() {}

}
