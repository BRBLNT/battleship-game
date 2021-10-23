package hu.nye.progtech.battleship.service.validate;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Ship;
import hu.nye.progtech.battleship.service.coordinate.CoordinateConverter;
import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import hu.nye.progtech.battleship.service.exception.NotValidPositionException;
import hu.nye.progtech.battleship.service.validate.impl.PositionValidatorImpl;

/**
 * Validate position is empty.
 */
public final class EmptyPositionChecker {

    private static final PositionValidatorImpl POSITION_VALIDATOR = new PositionValidatorImpl();

    /**
     * Check empty spaces for ship if all coordinate is empty ship may place there.
     */
    public static void positionIsEmpty(Board board, String pos)
            throws CoordinateFormatException, NotValidPositionException {
        boolean isEmpty = true;
        Ship ship = new Ship(new CoordinateConverter().sizeCalculator(pos));
        ship.setPosX(
                POSITION_VALIDATOR.convertPosition(pos.split(":")[0]));
        ship.setPosY(
                POSITION_VALIDATOR.convertPosition(pos.split(":")[1]));
        int posX1 = Integer.parseInt(ship.getPosX().split(":")[0]);
        int posY1 = Integer.parseInt(ship.getPosY().split(":")[0]);
        int posX2 = Integer.parseInt(ship.getPosX().split(":")[1]);
        int posY2 = Integer.parseInt(ship.getPosY().split(":")[1]);
        boolean start = false;
        int counter = 1;
        for (int i = 0; i <= board.getBoardSize(); i++) {
            for (int j = 0; j <= board.getBoardSize(); j++) {
                if (posX1 == posY1) {
                    if (j == posX2 - 1) {
                        start = true;
                    }
                    if (start && counter <= ship.getSize() && posX1 - 1 == i && posX2 - 1 <= j) {
                        if (board.getMatrixForBoard()[i][j] == '1') {
                            isEmpty = false;
                        }
                        counter++;
                    }
                } else if (posX2 == posY2) {
                    if (i == posX1 - 1) {
                        start = true;
                    }
                    if (start && counter <= ship.getSize() && posX2 - 1 == j && posX1 - 1 <= i) {
                        if (board.getMatrixForBoard()[i][j] == '1') {
                            isEmpty = false;
                        }
                        counter++;
                    }
                }
            }
        }
        if (!isEmpty) {
            throw new NotValidPositionException("Not empty positon");
        }
    }
}
