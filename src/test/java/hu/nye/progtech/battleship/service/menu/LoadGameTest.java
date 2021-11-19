package hu.nye.progtech.battleship.service.menu;

import static org.junit.jupiter.api.Assertions.assertTrue;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link LoadGame}
 */
public class LoadGameTest {

    private LoadGame underTest;
    private ConfigReader cr;
    private Player p;
    private OpponentAI ai;


    @Test
    public void loadGameTest() throws ConfigurationNotFoundException {
        //given
        boolean excp = false;
        underTest = new LoadGame();
        cr = new ConfigReader("");
        p = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        ai = new OpponentAI();
        //when
        underTest.setBotLoaded(ai);
        underTest.setPlayerLoaded(p);
        try {
            underTest.loadGameToGameState();
        } catch (Exception e) {
            excp = true;
        }
        //then
        assertTrue(excp);
    }
}
