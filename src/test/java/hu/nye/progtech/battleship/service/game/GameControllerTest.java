package hu.nye.progtech.battleship.service.game;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link GameController}
 */
public class GameControllerTest {

    private GameController underTest;
    private final String CONFIG = "config.properties";
    private UserInputReader uirp;
    private final String COMMAND = "null";

    @Test
    public void testInitNotThrownExceptionWhileInitTheGame() {
        //given
        ByteArrayInputStream in = new ByteArrayInputStream(COMMAND.getBytes());
        System.setIn(in);
        //when
        underTest = new GameController("", new UserInputReader(new Scanner(System.in)), null);
        //then - no exception
    }
}
