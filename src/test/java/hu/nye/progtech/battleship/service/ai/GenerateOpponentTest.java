package hu.nye.progtech.battleship.service.ai;

import static org.junit.jupiter.api.Assertions.assertTrue;

import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link GenerateOpponent}
 */
public class GenerateOpponentTest {

    private GenerateOpponent underTest;

    @Test
    public void testBotShouldHaveNameAndBoard() throws ConfigurationNotFoundException {
        //given
        underTest = new GenerateOpponent();
        ConfigReader cr = new ConfigReader("");
        OpponentAI testBot;
        boolean have = false;
        //when
        testBot = underTest.generate();
        if (testBot.getBoard() != null && testBot.getName() != null) {
            have = true;
        }
        //then
        assertTrue(have);
    }
}
