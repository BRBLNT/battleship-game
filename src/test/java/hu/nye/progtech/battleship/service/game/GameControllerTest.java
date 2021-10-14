package hu.nye.progtech.battleship.service.game;

import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.coordinate.CoordinateConverter;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import hu.nye.progtech.battleship.service.modify.BoardModifier;
import hu.nye.progtech.battleship.service.validate.impl.PositionValidatorImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * Unit tests for {@link GameController}.
 */
public class GameControllerTest {
    private static final String CONFIG = "config.properties";

    @Mock
    private static GameController underTest;

    private static final Properties prop = new Properties();
    private static final UserInputReader uir = new UserInputReader(new Scanner(System.in));
    private static final PositionValidatorImpl positionValidator = new PositionValidatorImpl();
    private static final CoordinateConverter coordinateConverter = new CoordinateConverter();
    private static final BoardModifier boardModifier = new BoardModifier();

    private static Player player;
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

        //when

        //then
    }

    @Test
    public void testChooseMenuExit(){
        //given

        //when

        //then
    }
}



