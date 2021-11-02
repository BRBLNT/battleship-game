package hu.nye.progtech.battleship.service.players;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link HighScoreTable}.
 */
public class HighScoreTableTest {

    final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
    private HighScoreTable underTest;
    private static ArrayList<Player> p;
    private Board b;
    private ConfigReader cr;

    private static final String EMPTY_TABLE_AS_STRING = "\r\n\r\n\r\n\r\n\r\n" +
                      "=============================" +
                    "\r\n||  Name           |  Wins ||" +
                    "\r\n=============================" +
                    "\r\n||Player1          |3      ||" +
                    "\r\n=============================" +
                    "\r\n||Player2          |1      ||" +
                    "\r\n=============================\r\n";


    @Test
    public void testHighScoreTableShouldReturnTheSame() throws ConfigurationNotFoundException {
        //given
        underTest = new HighScoreTable();
        p = new ArrayList<>();
        b = new Board(10);
        cr = new ConfigReader("");
        Player temp = new Player(b, 5);
        Player temp2 = new Player(b, 5);
        temp.setName("Player1");
        temp2.setName("Player2");
        temp.setNumberOfWins(3);
        temp2.setNumberOfWins(1);
        p.add(temp);
        p.add(temp2);
        System.setOut(new PrintStream(myOut));
        //when
        underTest.printHighScoreTable(p);
        //then
        assertEquals(EMPTY_TABLE_AS_STRING,myOut.toString());
    }

    @Test
    public void testHighScoreTableWhenArrayIsEmptyShouldReturnNothingWithoutError() {
        //given
        underTest = new HighScoreTable();
        p = new ArrayList<>();
        //when
        underTest.printHighScoreTable(p);
        //then
    }

}
