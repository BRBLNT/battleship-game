package hu.nye.progtech.battleship.model;

import java.util.ArrayList;
import java.util.Arrays;

public final class Board implements Draw {
    private char[][] matrixForBoard;
    private final ArrayList<Integer> cellsTitleHorizontal;
    private final ArrayList<Character> cellsTitleVertical;
    private final int boardSize;

    /**
     * 0 - empty slot
     * 1 - ship
     * */
    public Board(int sizeX) {
        this.boardSize = sizeX;
        this.matrixForBoard = new char[sizeX][sizeX];
        this.cellsTitleHorizontal = new ArrayList<>();
        this.cellsTitleVertical = new ArrayList<>();
        char tmp = 'A';
        for (int i = 0; i < sizeX; i++){
            this.cellsTitleHorizontal.add((i+1));
            this.cellsTitleVertical.add(tmp++);
            for (int j = 0; j < sizeX; j++){
                this.matrixForBoard[i][j] = '0';
            }
        }
    }

    public char[][] getMatrixForBoard() {
        return matrixForBoard;
    }

    public void setMatrixForBoard(char[][] matrixForBoard) {
        this.matrixForBoard = matrixForBoard;
    }

    public ArrayList<Integer> getCellsTitleHorizontal() {
        return cellsTitleHorizontal;
    }

    public ArrayList<Character> getCellsTitleVertical() {
        return cellsTitleVertical;
    }

    @Override
    public String toString() {
        return "Board{" +
                "matrixForBoard=" + Arrays.toString(matrixForBoard) +
                ", cellsTitleHorizontal=" + cellsTitleHorizontal +
                ", cellsTitleVertical=" + cellsTitleVertical +
                '}';
    }

    @Override
    public void drawBoard() {
        System.out.print(" ");
        for (int i = 0; i < boardSize; i++){
            System.out.print(" "+cellsTitleHorizontal.get(i));
        }
        System.out.println("");
        for (int i = 0; i < boardSize; i++){
            System.out.print(cellsTitleVertical.get(i));
            System.out.print("|");
            for (int j = 0; j < boardSize; j++){
                System.out.print(matrixForBoard[i][j] +"|");
            }
            System.out.println("");
            for(int j = 0; j < boardSize; j++) {
                System.out.print(" -");
            }
            System.out.println("");
        }
    }
}
