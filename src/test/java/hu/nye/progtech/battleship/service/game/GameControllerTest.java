package hu.nye.progtech.battleship.service.game;

import hu.nye.progtech.battleship.service.coordinate.CoordinateConverter;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import hu.nye.progtech.battleship.service.modify.BoardModifier;
import hu.nye.progtech.battleship.service.validate.impl.PositionValidatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Unit tests for {@link GameController}.
 */
@ExtendWith(MockitoExtension.class)
public class GameControllerTest {
    private static final String CONFIG = "config.properties";
    private static final String CONFIGDE = "configDE.properties";

    private static GameController underTest;

    private static UserInputReader uir;

    private static final Properties prop = new Properties();

    private final static String NAME = "Test User";
    private final static String SET_NAME = "SET_NAME";
    private final static String START_GAME = "START_GAME";
    private final static String SET_SHIP = "SET_SHIP";
    private final static String INVALID_COMMAND = "NOT_DEFINED_COMMAND";

    @Test
    public void testReadProperties() throws IOException {
        //given
        InputStream input = GameController.class.getClassLoader().getResourceAsStream(CONFIG);

        //when
        prop.load(input);

    }

    @Test
    public void testInit() throws ConfigurationNotFoundException {
        //given
        underTest = new GameController();
        uir = new UserInputReader(new Scanner(System.in));
        //when
        GameController.init(CONFIG, uir);
    }

    @Test
    public void testChooseMenuStart() {
        //given
        boolean nameNotSet = false;
        underTest = new GameController();
        ByteArrayInputStream in = new ByteArrayInputStream(START_GAME.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        GameController.init(CONFIG, uir);
        //when
        try {
            GameController.chooseMenu();
        } catch (Exception e) {
            nameNotSet = true;
        }
        //then
        assertTrue(nameNotSet);
    }

    @Test
    public void testChooseMenuSetShip() {
        //given
        boolean nameNotSet = false;
        underTest = new GameController();
        ByteArrayInputStream in = new ByteArrayInputStream(SET_SHIP.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        GameController.init(CONFIG, uir);
        //when
        try {
            GameController.chooseMenu();
        } catch (Exception e) {
            nameNotSet = true;
        }
        //then
        assertTrue(nameNotSet);
    }

    @Test
    public void testChooseMenuSetName() {
        //given
        boolean nameNotSet = false;
        underTest = new GameController();
        ByteArrayInputStream in = new ByteArrayInputStream(SET_NAME.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        GameController.init(CONFIG, uir);
        //when
        try {
            GameController.chooseMenu();
        } catch (Exception e) {
            nameNotSet = true;
        }
        //then
        assertTrue(nameNotSet);
    }

    @Test
    public void testChooseMenuInvalidCommand() {
        //given
        boolean nameNotSet = false;
        underTest = new GameController();
        ByteArrayInputStream in = new ByteArrayInputStream(INVALID_COMMAND.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        GameController.init(CONFIG, uir);
        //when
        try {
            GameController.chooseMenu();
        } catch (Exception e) {
            nameNotSet = true;
        }
        //then
        assertTrue(nameNotSet);
    }

}



