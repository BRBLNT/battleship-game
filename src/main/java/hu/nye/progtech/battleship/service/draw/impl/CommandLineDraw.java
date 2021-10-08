package hu.nye.progtech.battleship.service.draw.impl;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.service.draw.Draw;

import java.util.ArrayList;

public final class CommandLineDraw implements Draw {

    @Override
    public void drawBoard(Board b) {
        System.out.print(" ");
        for (int i = 0; i < b.getBoardSize(); i++){
            System.out.print(" "+b.getCellsTitleHorizontal().get(i));
        }
        System.out.println("");
        for (int i = 0; i < b.getBoardSize(); i++){
            System.out.print(b.getCellsTitleVertical().get(i));
            System.out.print("|");
            for (int j = 0; j < b.getBoardSize(); j++){
                System.out.print(b.getMatrixForBoard()[i][j] +"|");
            }
            System.out.println("");
            for(int j = 0; j < b.getBoardSize(); j++) {
                System.out.print(" -");
            }
            System.out.println("");
        }
    }
}
