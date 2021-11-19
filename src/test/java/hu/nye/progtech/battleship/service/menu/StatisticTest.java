package hu.nye.progtech.battleship.service.menu;

import java.util.ArrayList;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

public class StatisticTest {

    private Statistic underTest;
    private ArrayList<Player> players;

    private Player p;
    private ConfigReader cr;

    @Test
    public void testStatisticShouldPrintHighScoreTable() throws ConfigurationNotFoundException {
        //given
        cr = new ConfigReader("");
        Player temp = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        temp.setNumberOfWins(1);
        temp.setName("NAME");
        players = new ArrayList<>();
        players.add(temp);
        underTest = new Statistic();
        p = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        p.setName("NAME");
        //when
        underTest.printStat(players, p);
        //then
    }
}
