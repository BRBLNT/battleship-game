package hu.nye.progtech.battleship.service.menu;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link MenuController}
 */
public class MenuControllerTest {

    private MenuController underTest;
    private UserInputReader uir;
    private Player p;
    private ConfigReader cr;
    private String loadGame = "LOAD";
    private String highScore = "HIGH_SCORE";
    private String start = "START_GAME";
    private String setName = "SET_NAME";
    private String setShip = "SET_SHIP";
    private ArrayList<Player> players;

    @Test
    public void testMenuControllerWhenCommandLoadGame() throws ConfigurationNotFoundException {
        //given
        underTest = new MenuController();
        cr = new ConfigReader("");
        p = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        p.setName("");
        ByteArrayInputStream in = new ByteArrayInputStream(loadGame.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));

        //when
        underTest.chooseMenu(p);
    }

    @Test
    public void testMenuControllerWhenCommandHighScore() throws ConfigurationNotFoundException {
        //given
        underTest = new MenuController();
        cr = new ConfigReader("");
        p = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        p.setName("");
        players = new ArrayList<>();
        players.add(p);
        ByteArrayInputStream in = new ByteArrayInputStream(highScore.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        underTest.setPlayerList(players);
        //when
        underTest.chooseMenu(p);
    }

    @Test
    public void testMenuControllerWhenCommandStart() throws ConfigurationNotFoundException {
        //given
        underTest = new MenuController();
        cr = new ConfigReader("");
        p = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        p.setName("");
        ByteArrayInputStream in = new ByteArrayInputStream(start.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));

        //when
        underTest.chooseMenu(p);
    }


}
