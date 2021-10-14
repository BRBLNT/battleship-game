package hu.nye.progtech.battleship.service.game;

import hu.nye.progtech.battleship.model.Player;
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
import java.io.StringBufferInputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * Unit tests for {@link GameController}.
 */
@ExtendWith(MockitoExtension.class)
public class GameControllerTest {
    private static final String CONFIG = "config.properties";

    @Mock
    private static GameController underTest;
    @Mock
    private static UserInputReader uir;

    private static final Properties prop = new Properties();

    private static final PositionValidatorImpl positionValidator = new PositionValidatorImpl();
    private static final CoordinateConverter coordinateConverter = new CoordinateConverter();
    private static final BoardModifier boardModifier = new BoardModifier();

    private final static String NAME = "Test User";
    private final static String SET_NAME = "SET_NAME";
    private final static String START_GAME = "START";
    private final static String SET_SHIP = "SET_SHIP";
    private final static String EXIT = "EXIT";
    private static boolean isShipsSet = false;

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
        //when
        underTest.init(CONFIG);
    }

    @Test
    public void testChooseMenuStart(){
        //given

        //when

        //then
    }

    @Test
    public void testChooseMenuSetShip(){
        //given

        //when

        //then
    }

    @Test
    public void testChooseMenuSetName(){
        //given
        underTest = new GameController();
        ByteArrayInputStream in = new ByteArrayInputStream(SET_NAME.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        //when
        underTest.init(CONFIG);
        in = new ByteArrayInputStream(NAME.getBytes());
        System.setIn(in);
        //then
    }

    @Test
    public void testChooseMenuExit(){
        //given
        underTest = new GameController();
        ByteArrayInputStream in = new ByteArrayInputStream(EXIT.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        //when
        underTest.init(CONFIG);
        //then
    }
}



