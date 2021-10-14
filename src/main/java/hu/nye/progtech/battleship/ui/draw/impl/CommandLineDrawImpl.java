package hu.nye.progtech.battleship.ui.draw.impl;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.ui.draw.Draw;
import hu.nye.progtech.battleship.ui.draw.PrintWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command line interface this class draw out the board.
 */
public class CommandLineDrawImpl implements Draw {
    private static final String HORIZONTAL_SEPARATOR = " -";
    private static final String VERTICAL_SEPARATOR = "|";
    private PrintWrapper printWrapper;

    @Override
    public void drawBoard(Board b) {
        printWrapper = new PrintWrapper();
        printWrapper.print(" ");
        for (int i = 0; i < b.getBoardSize(); i++) {
            printWrapper.print(" " + b.getCellsTitleHorizontal().get(i));
        }
        printWrapper.print("\n");
        for (int i = 0; i < b.getBoardSize(); i++) {
            printWrapper.print(b.getCellsTitleVertical().get(i) + "");
            printWrapper.print(VERTICAL_SEPARATOR);
            for (int j = 0; j < b.getBoardSize(); j++) {
                printWrapper.print(b.getMatrixForBoard()[i][j] + VERTICAL_SEPARATOR + "");
            }
            printWrapper.print("\n");
            for (int j = 0; j < b.getBoardSize(); j++) {
                printWrapper.print(HORIZONTAL_SEPARATOR);
            }
            printWrapper.print("\n");
        }
    }

}
