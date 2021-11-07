package hu.nye.progtech.battleship.service.game;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import hu.nye.progtech.battleship.service.input.UserInput;
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
        underTest = new GameController();
        ByteArrayInputStream in = new ByteArrayInputStream(COMMAND.getBytes());
        System.setIn(in);
        uirp = new UserInputReader(new Scanner(System.in));
        //when
        underTest.init(CONFIG, uirp);
        //then - no exception
    }
}
