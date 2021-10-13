package hu.nye.progtech.battleship.service.modify;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Ship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Board visual modifier.
 * If we add ships to board or change the cell condition update visual implementation.
 */
public final class BoardModifier {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardModifier.class);

    /**
     * If we add ships to board change 0 to 1.
     */
    public char[][] modifyBoard(Board b, Ship ship) {
        int posX1 = ship.getPosX() / 10;
        int posY1 = ship.getPosY() / 10;
        int posX2 = ((ship.getPosX() * 10) - (posX1 * 100)) / 10;
        int posY2 = ((ship.getPosY() * 10) - (posY1 * 100)) / 10;
        LOGGER.info(posX1 + " " + posX2 + " " + posY1 + " " + posY2);
        boolean start = false;
        int counter = 1;
        char[][] newBoard = b.getMatrixForBoard();
        for (int i = 0; i <= b.getBoardSize(); i++) {
            for (int j = 0; j <= b.getBoardSize(); j++) {
                if (posX1 == posY1) {
                    if (j == posX2 - 1) {
                        start = true;
                    }
                    if (start && counter <= ship.getSize() && posX1 - 1 == i && posX2 - 1 <= j) {
                        newBoard[i][j] = '1';
                        counter++;
                    }
                } else if (posX2 == posY2) {
                    if (i == posX1 - 1) {
                        start = true;
                    }
                    if (start && counter <= ship.getSize() && posX2 - 1 == j && posX1 - 1 <= i) {
                        newBoard[i][j] = '1';
                        counter++;
                    }
                }
            }
        }

        return newBoard;
    }
}
