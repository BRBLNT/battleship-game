package hu.nye.progtech.battleship.service.validate.impl;


import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import hu.nye.progtech.battleship.service.exception.NotValidPositionException;
import hu.nye.progtech.battleship.service.exception.PositionNotValidForSizeException;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link PositionValidatorImpl}.
 */

public class PositionValidatorImplTest {

    private static final String POS = "A1:A2";
    private static final String POS2 = "B1:C1";
    private static final int SIZE = 2;
    private static final int MAX_SIZE = 5;

    private PositionValidatorImpl underTest;


    @Test
    public void testValidateShouldNotThrowExceptionWhenPosInCorrectForm() throws CoordinateFormatException {
        // given
        underTest = new PositionValidatorImpl();
        // when
        underTest.validFormat(POS);
        underTest.validFormat(POS2);
        // then no exception is thrown
    }
    @Test
    public void testValidateShouldNotThrowExceptionWhenPosInLine() throws NotValidPositionException {
        // given
        underTest = new PositionValidatorImpl();
        // when
        underTest.validPositionInline(POS);
        underTest.validPositionInline(POS2);
        // then no exception is thrown
    }
    @Test
    public void testValidateShouldNotThrowExceptionWhenLengthIsCorrect() throws PositionNotValidForSizeException {
        // given
        underTest = new PositionValidatorImpl();
        // when
        underTest.checkLength(SIZE, POS, MAX_SIZE);
        underTest.checkLength(SIZE, POS2, MAX_SIZE);
        // then no exception is thrown
    }
    @Test
    public void testValidateShouldNotThrowExceptionWhenEverythingIsCorrect()
            throws PositionNotValidForSizeException, CoordinateFormatException, NotValidPositionException {
        // given
        underTest = new PositionValidatorImpl();
        // when
        underTest.validate(SIZE, POS, MAX_SIZE);
        // then no exception is thrown
    }
}
