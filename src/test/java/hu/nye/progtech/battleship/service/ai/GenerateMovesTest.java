package hu.nye.progtech.battleship.service.ai;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.input.MapReader;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link GenerateMoves}
 */
public class GenerateMovesTest {

    private GenerateMoves underTest;
    private GenerateOpponent go;
    private ConfigReader cr;
    private Player player;
    private OpponentAI ai;

    private static String nameOfMapFile = "ai/boards.txt";
    private static ArrayList<Board> board = new ArrayList<>();
    private static final int DEFAULT_SIZE = 10;



    @Test
    public void testBotStepShouldReturnFalseWhenNoMoreStep() throws ConfigurationNotFoundException {
        //given
        go = new GenerateOpponent();
        upload(nameOfMapFile);
        cr = new ConfigReader("");
        player = new Player(board.get(0),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        ai = go.generate();
        boolean res = true;
        //when
        for (int i = 0; i < (DEFAULT_SIZE * DEFAULT_SIZE)-1 ; i++) {
            res = underTest.botStep(player, ai);
        }
        //then
        assertFalse(res);
    }




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
