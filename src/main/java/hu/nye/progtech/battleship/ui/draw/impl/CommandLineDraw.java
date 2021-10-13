package hu.nye.progtech.battleship.ui.draw.impl;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.ui.draw.Draw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command line interface this class draw out the board.
 */
public class CommandLineDraw implements Draw {
    private static final String HORIZONTAL_SEPARATOR = " -";
    private static final String VERTICAL_SEPARATOR = "|";
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineDraw.class);

    @Override
    public void drawBoard(Board b) {
        LOGGER.info("Printing map to stdout");
        System.out.print(" ");
        for (int i = 0; i < b.getBoardSize(); i++) {
            System.out.print(" " + b.getCellsTitleHorizontal().get(i));
        }
        System.out.println();
        for (int i = 0; i < b.getBoardSize(); i++) {
            System.out.print(b.getCellsTitleVertical().get(i));
            System.out.print(VERTICAL_SEPARATOR);
            for (int j = 0; j < b.getBoardSize(); j++) {
                System.out.print(b.getMatrixForBoard()[i][j] + VERTICAL_SEPARATOR);
            }
            System.out.println();
            for (int j = 0; j < b.getBoardSize(); j++) {
                System.out.print(HORIZONTAL_SEPARATOR);
            }
            System.out.println();
        }
    }

}
