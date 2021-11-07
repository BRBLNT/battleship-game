package hu.nye.progtech.battleship.service.validate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.input.MapReader;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link ValidateHit}
 */
public class ValidateHitTest {

    private ValidateHit underTest;
    private final int MAX_SIZE = 10;
    private final String POS = "A:2";
    private final int X = 0;
    private final int Y = 1;
    private final String WRONG_POS = "Z:34";
    private Player player;
    private ConfigReader cr;

    @Test
    public void testPositionOnBoardShouldReturnTrueIfPositionOnSize() {
        //given
        boolean test = false;
        underTest = new ValidateHit();
        //when
        test = underTest.positionOnBoard(POS, MAX_SIZE);
        //then
        assertTrue(test);
    }

    @Test
    public void testPositionOnBoardShouldReturnFalseIfPositionOutOfSize() {
        //given
        boolean test = false;
        underTest = new ValidateHit();
        //when
        test = underTest.positionOnBoard(WRONG_POS, MAX_SIZE);
        //then
        assertFalse(test);
    }

    @Test
    public void testNotHitBeforeShouldReturnTrueIfNotHit() throws ConfigurationNotFoundException {
        //given
        cr = new ConfigReader("");
        boolean test = false;
        underTest = new ValidateHit();
        upload(nameOfMapFile);
        player = new Player(board.get(0),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        //when
        test = underTest.positionNotHiteBefore(POS, player);
        //then
        assertTrue(test);
    }

    @Test
    public void testNotHitBeforeShouldReturnFalseIfPosHitted() throws ConfigurationNotFoundException {
        //given
        cr = new ConfigReader("");
        boolean test = false;
        underTest = new ValidateHit();
        upload(nameOfMapFile);
        player = new Player(board.get(0),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        //when
        player.getHits()[X][Y] = true;
        test = underTest.positionNotHiteBefore(POS, player);
        //then
        assertFalse(test);
    }


    private static String nameOfMapFile = "ai/boards.txt";
    private static ArrayList<Board> board = new ArrayList<>();
    private static final int DEFAULT_SIZE = 10;

    private static void upload(String file) {
        try {
            InputStream is = MapReader.class.getClassLoader().getResourceAsStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                board.add(new Board(DEFAULT_SIZE));
                board.get(i).setMatrixForBoard(mapFormatter(line));
                i++;
            }
        } catch (Exception ex) {

        }
    }
    private static char[][] mapFormatter(String s) {
        char[][] matrix = new char[10][10];
        String[] slices = s.split(";");
        for (int i = 0; i < slices.length; i++) {
            for (int j = 0; j < slices[i].length(); j++) {
                matrix[i][j] = slices[i].charAt(j);
            }
        }
        return matrix;
    }
}
