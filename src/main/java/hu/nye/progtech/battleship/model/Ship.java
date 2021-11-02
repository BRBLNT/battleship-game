package hu.nye.progtech.battleship.model;

import java.util.Objects;

/**
 * Ship implementation.
 * 2 coordination and size.
 */
public final class Ship {
    private final int size;
    private String posX;
    private String posY;

    public Ship(int size) {
        this.size = size;
        posX = "";
        posY = "";
    }

    public String getPosX() {
        return posX;
    }

    public void setPosX(String posX) {
        this.posX = posX;
    }

    public String getPosY() {
        return posY;
    }

    public void setPosY(String posY) {
        this.posY = posY;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", size=" + size +
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
        Ship ship = (Ship) o;
        return size == ship.size && posX.equals(ship.posX) && posY.equals(ship.posY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, posX, posY);
    }
}
