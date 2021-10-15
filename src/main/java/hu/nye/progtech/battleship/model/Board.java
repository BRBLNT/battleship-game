package hu.nye.progtech.battleship.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Board implementation.
 * with title of cells and a matrix for a visualization.
 */
public final class Board {
    private final ArrayList<Integer> cellsTitleHorizontal;
    private final ArrayList<Character> cellsTitleVertical;
    private final int boardSize;
    private char[][] matrixForBoard;

    /**
     * Constructor of board.
     * 0 - empty slot.
     */
    public Board(int sizeX) {
        this.boardSize = sizeX;
        this.matrixForBoard = new char[sizeX][sizeX];
        this.cellsTitleHorizontal = new ArrayList<>();
        this.cellsTitleVertical = new ArrayList<>();
        char tmp = 'A';
        for (int i = 0; i < sizeX; i++) {
            this.cellsTitleHorizontal.add((i + 1));
            this.cellsTitleVertical.add(tmp++);
            for (int j = 0; j < sizeX; j++) {
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

    public int getBoardSize() {
        return boardSize;
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Board board = (Board) o;
        return cellsTitleHorizontal == board.cellsTitleHorizontal && cellsTitleVertical == board.cellsTitleVertical
                && Arrays.deepEquals(matrixForBoard, board.matrixForBoard);
    }

    private char[][] deepCopy(char[][] array) {
        char[][] result = null;

        if (array != null) {
            result = new char[array.length][];
            for (int i = 0; i < array.length; i++) {
                result[i] = Arrays.copyOf(array[i], array[i].length);
            }
        }

        return result;
    }
}
