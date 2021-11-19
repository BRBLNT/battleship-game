package hu.nye.progtech.battleship.service.menu;


import java.util.ArrayList;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link StartGame}
 */
public class StartGameTest {

    private MenuController menuController;
    private StartGame underTest;
    private ArrayList<Player> players;

    private Player p;
    private ConfigReader cr;


    @Test
    public void testStartGameWhenPlayerNameIsNull() throws ConfigurationNotFoundException {
        //given
        underTest = new StartGame();
        cr = new ConfigReader("");
        p = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        //when
        underTest.startGame(p);
        //then
    }

    @Test
    public void testStartGameWhenPlayerNameIsNotNull() throws ConfigurationNotFoundException {
        //given
        underTest = new StartGame();
        cr = new ConfigReader("");
        p = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        p.setName("NAME");
        //when
        try {
            underTest.startGame(p);
        } catch (Exception e) {

        }
        //then
    }

    @Test
    public void testStartGameWhenPlayerNameIsNotNullAndShipsSet() throws ConfigurationNotFoundException {
        //given
        menuController = new MenuController();
        cr = new ConfigReader("");
        menuController.setIsShipsSet(true);
        Player temp = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        temp.setNumberOfWins(1);
        temp.setName("NAME");
        players = new ArrayList<>();
        players.add(temp);
        menuController.setPlayerList(players);
        underTest = new StartGame();
        p = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        p.setName("NAME");
        //when
        try {
            underTest.startGame(p);
        } catch (Exception e) {

        }
        //then
    }
}
