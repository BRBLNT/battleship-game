package hu.nye.progtech.battleship.service.validate.impl;


import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import hu.nye.progtech.battleship.service.exception.NotValidPositionException;
import hu.nye.progtech.battleship.service.exception.PositionNotValidForSizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link PositionValidatorImpl}.
 */

public class PositionValidatorImplTest {

    private static final String POS = "A1:A2";
    private static final String POS2 = "B1:C1";

    private static final String INVALID_POS = "A1B4";
    private static final String INVALID_POS2 = "B1:C7";
    private static final String INVALID_POS3 = "BBBC1:CCCC7";
    private static final String INVALID_POS4 = "B3412:C673";
    private static final String INVALID_POS5 = "4fs12:43C673";

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
    public void testValidateShouldThrowExceptionWhenPosInCorrectForm() {
        // given
        underTest = new PositionValidatorImpl();
        boolean thrown = false;
        // when
        try {
            underTest.validFormat(INVALID_POS);
            underTest.validFormat(INVALID_POS2);
            underTest.validFormat(INVALID_POS3);
            underTest.validFormat(INVALID_POS4);
            underTest.validFormat(INVALID_POS5);
        }catch (CoordinateFormatException ex){
            thrown = true;
        }

        // then
        assertTrue(thrown);
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
    public void testValidateShouldThrowExceptionWhenPosInLine() {
        // given
        underTest = new PositionValidatorImpl();
        boolean thrown = false;
        // when
        try {
            underTest.validPositionInline(INVALID_POS);
            underTest.validPositionInline(INVALID_POS2);
        }catch (NotValidPositionException ex){
            thrown = true;
        }

        // then
        assertTrue(thrown);
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
    public void testValidateShouldThrowExceptionWhenLengthIsCorrect() {
        // given
        underTest = new PositionValidatorImpl();
        boolean thrown = false;
        // when
        try {
            underTest.checkLength(SIZE, INVALID_POS, MAX_SIZE);
            underTest.checkLength(SIZE, INVALID_POS2, MAX_SIZE);
        }catch (PositionNotValidForSizeException ex){
            thrown = true;
        }

        // then
        assertTrue(thrown);
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

    @Test
    public void testValidateShouldThrowExceptionWhenEverythingIsCorrect() {
        // given
        underTest = new PositionValidatorImpl();
        boolean thrown = false;
        // when
        try {
            underTest.validate(SIZE, INVALID_POS, MAX_SIZE);
            underTest.validate(SIZE, INVALID_POS2, MAX_SIZE);
        }catch (PositionNotValidForSizeException | CoordinateFormatException | NotValidPositionException ex){
            thrown = true;
        }

        // then
        assertTrue(thrown);
    }
}
