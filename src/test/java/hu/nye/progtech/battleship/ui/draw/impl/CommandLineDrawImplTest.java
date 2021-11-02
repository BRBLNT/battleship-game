package hu.nye.progtech.battleship.ui.draw.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import hu.nye.progtech.battleship.model.Board;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link CommandLineDrawImpl}.
 */
public class CommandLineDrawImplTest {

    final ByteArrayOutputStream myOut = new ByteArrayOutputStream();

    private CommandLineDrawImpl underTest;
    private static final int BOARD_SIZE = 4;
    private static Board board;

    private static final int[][] EMPTY_BOARD = {
            {'0','0','0','0'},
            {'0','0','0','0'},
            {'0','0','0','0'},
            {'0','0','0','0'},
    };

    private static final List<String> EMPTY_BOARD_AS_STRING_ARRAY = List.of(
            "  1 2 3 4",
            "A|0|0|0|0|",
            " - - - -",
            "B|0|0|0|0|",
            " - - - -",
            "C|0|0|0|0|",
            " - - - -",
            "D|0|0|0|0|",
            " - - - -"
    );

    private static final String EMPTY_BOARD_AS_STRING =
            "  1 2 3 4\nA|0|0|0|0|\n - - - -\nB|0|0|0|0|\n - - - -\nC|0|0|0|0|\n - - - -\nD|0|0|0|0|\n - - - -\n";

    @Test
    public void testDrawBoardShouldReturnCorrectStdoutVisual(){
        //given
        board = new Board(BOARD_SIZE);
        underTest = new CommandLineDrawImpl();
        System.setOut(new PrintStream(myOut));
        //when
        underTest.drawBoard(board);
        //then
        assertEquals(EMPTY_BOARD_AS_STRING,myOut.toString());
    }


}
