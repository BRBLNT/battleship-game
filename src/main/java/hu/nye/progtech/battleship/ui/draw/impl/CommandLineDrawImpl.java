package hu.nye.progtech.battleship.ui.draw.impl;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.ui.draw.Draw;
import hu.nye.progtech.battleship.ui.draw.PrintWrapper;

/**
 * Implements Draw for Command Line Interface.
 */
public class CommandLineDrawImpl implements Draw {
    private static final String HORIZONTAL_SEPARATOR = " -";
    private static final String VERTICAL_SEPARATOR = "|";


    @Override
    public void drawBoard(Board b) {
        PrintWrapper.print(" ");
        for (int i = 0; i < b.getBoardSize(); i++) {
            PrintWrapper.print(" " + b.getCellsTitleHorizontal().get(i));
        }
        PrintWrapper.print("\n");
        for (int i = 0; i < b.getBoardSize(); i++) {
            PrintWrapper.print(b.getCellsTitleVertical().get(i) + "");
            PrintWrapper.print(VERTICAL_SEPARATOR);
            for (int j = 0; j < b.getBoardSize(); j++) {
                PrintWrapper.print(b.getMatrixForBoard()[i][j] + VERTICAL_SEPARATOR + "");
            }
            PrintWrapper.print("\n");
            for (int j = 0; j < b.getBoardSize(); j++) {
                PrintWrapper.print(HORIZONTAL_SEPARATOR);
            }
            PrintWrapper.print("\n");
        }
    }

}
