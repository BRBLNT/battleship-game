package hu.nye.progtech.battleship.service.validate;

import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import hu.nye.progtech.battleship.service.exception.NotValidPositionException;
import hu.nye.progtech.battleship.service.exception.PositionNotValidForSizeException;

/**
 * Position validator interface. Define methods to check coordinate value is valid.
 */
public interface PositionValidator {

    void validFormat(String pos) throws CoordinateFormatException;

    void validPositionInline(String pos) throws NotValidPositionException;

    String convertPosition(String pos);

    void checkLength(int size, String pos, int maxSize) throws PositionNotValidForSizeException;

    void validate(int size, String pos, int maxSize)
            throws PositionNotValidForSizeException, CoordinateFormatException, NotValidPositionException;


}
