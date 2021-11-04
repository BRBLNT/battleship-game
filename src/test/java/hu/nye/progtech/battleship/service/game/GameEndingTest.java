package hu.nye.progtech.battleship.service.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link GameEnding}
 */
public class GameEndingTest {

    private GameEnding underTest;
    private Player player;

    private final int BOARD_X = 10;
    private final int NUM_OF_SHIPS = 5;

    private final int START = 0;
    private final int FINISH = 1;

    /*
    @BeforeEach
    public void init() throws ConfigurationNotFoundException {
        underTest = new GameEnding();
        ConfigReader cr = new ConfigReader("");
        player = new Player(new Board(BOARD_X), NUM_OF_SHIPS);
        player.setNumberOfWins(START);
        player.setNumberOfGames(START);
    }

     */

    @Test
    public void testWinShouldGiveWinToTheStat() throws ConfigurationNotFoundException {
        //given
        underTest = new GameEnding();
        ConfigReader cr = new ConfigReader("");
        player = new Player(new Board(BOARD_X), NUM_OF_SHIPS);
        player.setNumberOfWins(START);
        player.setNumberOfGames(START);
        //when
        underTest.win(player);
        //then
        assertEquals(FINISH, player.getNumberOfWins());
    }

    @Test
    public void testWinShouldGiveGameToTheStat() throws ConfigurationNotFoundException {
        //given
        underTest = new GameEnding();
        ConfigReader cr = new ConfigReader("");
        player = new Player(new Board(BOARD_X), NUM_OF_SHIPS);
        player.setNumberOfWins(START);
        player.setNumberOfGames(START);
        //when
        underTest.win(player);
        //then
        assertEquals(FINISH, player.getNumberOfGames());
    }

    @Test
    public void testLoseShouldGiveLoseToTheStat() throws ConfigurationNotFoundException {
        //given
        underTest = new GameEnding();
        ConfigReader cr = new ConfigReader("");
        player = new Player(new Board(BOARD_X), NUM_OF_SHIPS);
        player.setNumberOfWins(START);
        player.setNumberOfGames(START);
        //when
        underTest.lose(player);
        //then
        assertEquals(FINISH, player.getNumberOfGames());
    }
}
