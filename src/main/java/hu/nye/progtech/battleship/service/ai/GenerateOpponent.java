package hu.nye.progtech.battleship.service.ai;

import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.service.input.MapReader;
import hu.nye.progtech.battleship.service.input.NameReader;

/**
 * Generate opponent AI.
 */
public class GenerateOpponent {

    /**
     * Generate opponent AI.
     */
    public static OpponentAI generate() {
        OpponentAI bot = new OpponentAI();
        bot.setName(NameReader.readRandomNameForTheBot());
        bot.setBoard(MapReader.getBoard());
        return bot;
    }
}
