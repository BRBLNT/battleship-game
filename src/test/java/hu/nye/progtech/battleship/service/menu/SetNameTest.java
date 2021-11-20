package hu.nye.progtech.battleship.service.menu;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link SetName}
 */
public class SetNameTest {

    private SetName underTest;
    private Player p;
    private ConfigReader cr;
    private final String WRONG_NAME = "E";
    private final String NAME = "NAME";
    private UserInputReader uir;

    @Test
    public void testWhenInputNotEnoughLongNotThrownException() throws ConfigurationNotFoundException {
        //given
        cr = new ConfigReader("");
        p = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        p.setName("");
        ByteArrayInputStream in = new ByteArrayInputStream(NAME.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        //when
        try {
            underTest.setName(p);
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    @Test
    public void testWhenInputEnoughLongNotThrownException() throws ConfigurationNotFoundException {
        //given
        cr = new ConfigReader("");
        p = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        p.setName("NAMENAME");
        ByteArrayInputStream in = new ByteArrayInputStream(WRONG_NAME.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        //when
        try {
            underTest.setName(p);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
