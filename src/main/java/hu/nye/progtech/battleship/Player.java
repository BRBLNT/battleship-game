package hu.nye.progtech.battleship;

import java.util.ArrayList;

public class Player {
    private String Name;
    private Board board;
    private int numberOfShips;
    private ArrayList<Ship> ships;

    public Player(){

    }

    public Player(String name, Board board, int numberOfShips, ArrayList<Ship> ships) {
        Name = name;
        this.board = board;
        this.numberOfShips = numberOfShips;
        this.ships = ships;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public void setNumberOfShips(int numberOfShips) {
        this.numberOfShips = numberOfShips;
        for (int i = 1; i <= numberOfShips; i++){
            ships.add(new Ship(i));
        }
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
                "Name='" + Name + '\'' +
                ", board=" + board +
                ", numberOfShips=" + numberOfShips +
                ", ships=" + ships +
                '}';
    }

}
