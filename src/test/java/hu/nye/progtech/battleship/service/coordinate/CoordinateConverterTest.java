package hu.nye.progtech.battleship.service.coordinate;

import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link CoordinateConverter}.
 */
public class CoordinateConverterTest {
    private static final String POS = "E1:E2";
    private static final String POS2 = "B2:D2";
    private static final String EMPTY_POS = "";
    private static final int SIZE = 2;
    private static final int SIZE2 = 3;
    private static final int WRONG_POS = -1;

    private CoordinateConverter underTest;

    @Test
    public void testCoordinateConverterShouldReturnEqualsValue() throws CoordinateFormatException {
        // given
        underTest = new CoordinateConverter();
        // when
        int resultOne = underTest.sizeCalculator(POS);
        int resultTwo = underTest.sizeCalculator(POS2);
        // then no exception is thrown
        assertEquals(SIZE, resultOne);
        assertEquals(SIZE2, resultTwo);
    }

    @Test
    public void testCoordinateConverterShouldReturnEqualsValueWhenPosIsEmpty() {
        // given
        underTest = new CoordinateConverter();
        // when
        int resultOne = 0;
        try {
            resultOne = underTest.sizeCalculator(EMPTY_POS);
        } catch (CoordinateFormatException e) {
           resultOne = -1;
        }
        // then no exception is thrown
        assertEquals(WRONG_POS, resultOne);
    }

}
