package hu.nye.progtech.battleship.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Player implementation.
 */
public class Player {
    private Board board;
    private final int numberOfShips;
    private String name;
    private ArrayList<Ship> ships;

    public Player(Board board, int numberOfShips) {
        this.board = board;
        this.numberOfShips = numberOfShips;
        ships = new ArrayList<>();
        shipsArraySize(numberOfShips);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public int getNumberOfShips() {
        return numberOfShips;
    }

    private void shipsArraySize(int numberOfShips) {
        for (int i = 1; i <= numberOfShips; i++) {
            this.ships.add(new Ship(i));
        }
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Name='" + name + '\'' +
                ", board=" + board +
                ", numberOfShips=" + numberOfShips +
                ", ships=" + ships +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return numberOfShips == player.numberOfShips && Objects.equals(board, player.board) &&
                Objects.equals(name, player.name) && Objects.equals(ships, player.ships);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, numberOfShips, name, ships);
    }
}
