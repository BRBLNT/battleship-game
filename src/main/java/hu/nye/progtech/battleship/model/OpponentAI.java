package hu.nye.progtech.battleship.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import hu.nye.progtech.battleship.service.properties.ConfigReader;

/**
 * AI class a bot player generated automatically.
 */
public class OpponentAI {
    private Board board;
    private final int numberOfShips;
    private String name;
    private ArrayList<Ship> ships;
    private boolean[][] hits;

    public OpponentAI() {
        this.numberOfShips = Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships"));
        ships = new ArrayList<>();
        shipsArraySize(numberOfShips);
        int hitSize = Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.board.size"));
        hits = new boolean[hitSize][hitSize];
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                hits[i][j] = false;
            }
        }
    }

    private void shipsArraySize(int numberOfShips) {
        for (int i = 1; i <= numberOfShips; i++) {
            this.ships.add(new Ship(i));
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getNumberOfShips() {
        return numberOfShips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    public boolean[][] getHits() {
        return hits;
    }

    public void setHits(boolean[][] hits) {
        this.hits = hits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OpponentAI that = (OpponentAI) o;
        return numberOfShips == that.numberOfShips && Objects.equals(board, that.board) &&
                Objects.equals(name, that.name) && Objects.equals(ships, that.ships) &&
                Arrays.equals(hits, that.hits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(board, numberOfShips, name, ships);
        result = 31 * result + Arrays.hashCode(hits);
        return result;
    }

    @Override
    public String toString() {
        return "OpponentAI{" +
                "board=" + board +
                ", numberOfShips=" + numberOfShips +
                ", name='" + name + '\'' +
                ", ships=" + ships +
                ", hits=" + Arrays.toString(hits) +
                '}';
    }
}
