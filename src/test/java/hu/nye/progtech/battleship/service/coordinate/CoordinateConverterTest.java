package hu.nye.progtech.battleship.service.coordinate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link CoordinateConverter}.
 */
public class CoordinateConverterTest {
    private static final String POS = "E1:E2";
    private static final String POS2 = "B2:D2";
    private static final int SIZE = 2;
    private static final int SIZE2 = 3;

    private CoordinateConverter underTest;

    @Test
    public void testCoordinateConverterShouldReturnEqualsValue() {
        // given
        underTest = new CoordinateConverter();
        // when
        int resultOne = underTest.sizeCalculator(POS);
        int resultTwo = underTest.sizeCalculator(POS2);
        // then no exception is thrown
        assertEquals(SIZE,resultOne);
        assertEquals(SIZE2,resultTwo);
    }

}
