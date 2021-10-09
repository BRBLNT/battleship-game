package hu.nye.progtech.battleship.service.validate;

import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import hu.nye.progtech.battleship.service.exception.NotValidPositionException;

public interface PositionValidator {

    void validFormat(String pos) throws CoordinateFormatException;

    void validPosition(String posX, String posY) throws NotValidPositionException;

    String convertPosition(String pos);


}
