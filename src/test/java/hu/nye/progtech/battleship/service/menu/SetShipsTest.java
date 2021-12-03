package hu.nye.progtech.battleship.service.menu;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link SetShip}
 */
public class SetShipsTest {

    private SetShip underTest;
    private String input = "A1:A1";
    private String wrong_input = "AA1";
    private UserInputReader uir;


    @Test
    public void testSetShipShouldThrownException() throws ConfigurationNotFoundException {
        //given
        underTest = new SetShip();
        Board b = new Board(10);
        ConfigReader cr = new ConfigReader("");
        Player temp = new Player(b, 5);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        boolean excepted = false;
        //when
        try {
            underTest.setShip(temp);
        } catch (Exception e) {
            excepted = true;
        }
        //then
        assertTrue(excepted);
    }

    @Test
    public void testSetShipShouldThrownExceptionWrongFormat() throws ConfigurationNotFoundException {
        //given
        underTest = new SetShip();
        Board b = new Board(10);
        ConfigReader cr = new ConfigReader("");
        Player temp = new Player(b, 5);
        ByteArrayInputStream in = new ByteArrayInputStream(wrong_input.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        boolean excepted = false;
        //when
        try {
            underTest.setShip(temp);
        } catch (Exception e) {
            excepted = true;
        }
        //then
        assertTrue(excepted);
    }
}
