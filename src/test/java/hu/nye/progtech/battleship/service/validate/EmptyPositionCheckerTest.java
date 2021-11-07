package hu.nye.progtech.battleship.service.validate;

import static org.junit.jupiter.api.Assertions.assertTrue;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Ship;
import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import hu.nye.progtech.battleship.service.exception.NotValidPositionException;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link EmptyPositionChecker}
 */
public class EmptyPositionCheckerTest {

    private EmptyPositionChecker underTest;

    private Board board;

    private final String POS = "A1:A1";
    private final String NOT_EMPTY_POS = "A3:B3";
    private final int SIZE = 10;

    private char[][] matrix = {
            {'0','1','1','1','0','0','0','0','0','0'},
            {'0','0','1','0','0','0','0','0','0','0'},
            {'0','0','1','0','0','0','0','0','0','0'},
            {'0','0','1','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
            {'0','0','0','0','0','0','0','0','0','0'},
    };

    @Test
    public void testEmptyPositionCheckerShouldNotThrownException() throws CoordinateFormatException, NotValidPositionException {
        //given
        underTest = new EmptyPositionChecker();
        board = new Board(SIZE);
        board.setMatrixForBoard(matrix);
        //when
        underTest.positionIsEmpty(board, POS);
        //then - exception
    }

    @Test
    public void testEmptyPositionCheckerShouldThrownExceptionIfNotEmpty(){
        //given
        underTest = new EmptyPositionChecker();
        board = new Board(SIZE);
        board.setMatrixForBoard(matrix);
        boolean result = false;
        //when
        try {
            underTest.positionIsEmpty(board, NOT_EMPTY_POS);
        } catch (NotValidPositionException | CoordinateFormatException e) {
            result = true;
        }
        //then
        assertTrue(result);
    }


}
