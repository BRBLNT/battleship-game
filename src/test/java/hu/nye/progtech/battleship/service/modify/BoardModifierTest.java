package hu.nye.progtech.battleship.service.modify;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Ship;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link BoardModifier}.
 */
public class BoardModifierTest {

    private static final int POS1 = 11;
    private static final int POS2 = 12;

    private static final int POS21 = 11;
    private static final int POS22 = 21;

    private static final int SIZE = 2;
    private static final int BOARD_SIZE = 5;

    private static Board board;
    private static Ship ship;

    private BoardModifier underTest;

    private static final char[][] ZERO = {
            {'0','0','0','0','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'},
    };

    private static final char[][] RESULT_HORIZONTAL = {
            {'1','1','0','0','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'},
    };

    private static final char[][] RESULT_VERTICAL = {
            {'1','0','0','0','0'},
            {'1','0','0','0','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'},
    };

    @Test
    public void testBoardModifierShouldReturnEqualsBoardIfCoordinatesIsHorizontal() {
        // given in setup
        underTest = new BoardModifier();
        ship = new Ship(SIZE);
        ship.setPosX(POS1);
        ship.setPosY(POS2);
        board = new Board(BOARD_SIZE);
        // when
        char[][] result = underTest.modifyBoard(board,ship);

        // then
        assertEquals(RESULT_HORIZONTAL.length,result.length);
        for (int i = 0; i < RESULT_HORIZONTAL.length; i++)
            for (int j = 0; j < RESULT_HORIZONTAL.length; j++)
            assertEquals(RESULT_HORIZONTAL[i][j], result[i][j] );
    }

    @Test
    public void testBoardModifierShouldReturnEqualsBoardIfCoordinatesIsVertical() {
        // given in setup
        underTest = new BoardModifier();
        ship = new Ship(SIZE);
        ship.setPosX(POS21);
        ship.setPosY(POS22);
        board = new Board(BOARD_SIZE);
        // when
        char[][] result = underTest.modifyBoard(board,ship);

        // then
        assertEquals(RESULT_VERTICAL.length,result.length);
        for (int i = 0; i < RESULT_VERTICAL.length; i++)
            for (int j = 0; j < RESULT_VERTICAL.length; j++)
                assertEquals(RESULT_VERTICAL[i][j], result[i][j] );
    }
}
