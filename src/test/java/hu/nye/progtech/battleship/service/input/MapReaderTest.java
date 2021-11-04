package hu.nye.progtech.battleship.service.input;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import hu.nye.progtech.battleship.model.Board;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link MapReader}
 */
public class MapReaderTest {

    private MapReader underTest;
    private static String nameOfMapFile = "ai/boards.txt";
    private static ArrayList<Board> board = new ArrayList<>();
    private static final int DEFAULT_SIZE = 10;

    @Test
    public void testReadMapShouldReturnMapAndMapListContainsIt() {
        //given
        underTest = new MapReader();
        underTest.setNameOfMapFile(nameOfMapFile);
        upload(nameOfMapFile);
        Board b;
        boolean contains = false;
        //when
        b = underTest.getBoard();
        for (Board board1: board) {
            if (Arrays.deepEquals(board1.getMatrixForBoard(), b.getMatrixForBoard())) {
                contains = true;
            }
        }
        System.out.println(b);
        //then
        assertTrue(contains);
    }


    private static ArrayList<String> lines = new ArrayList<>();

    private static void upload(String file) {
        try {
            InputStream is = MapReader.class.getClassLoader().getResourceAsStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                board.add(new Board(DEFAULT_SIZE));
                board.get(i).setMatrixForBoard(mapFormatter(line));
                System.out.println(board.get(i));
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
