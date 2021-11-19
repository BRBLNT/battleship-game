package hu.nye.progtech.battleship.service.output.gamestate;

import hu.nye.progtech.battleship.service.input.gamestate.LoadGameState;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link SaveGame}
 */
public class SaveGameTest {

    private SaveGame underTest;

    @Test
    public void testGameStateSave() {
        underTest = new SaveGame();
    }
}
