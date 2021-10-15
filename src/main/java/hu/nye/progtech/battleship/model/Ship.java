package hu.nye.progtech.battleship.model;

import java.util.Objects;

/**
 * Ship implementation.
 * 2 coordination and size.
 */
public final class Ship {
    private final int size;
    private int posX;
    private int posY;

    public Ship(int size) {
        this.size = size;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
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
        return size == ship.size && posX == ship.posX && posY == ship.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, posX, posY);
    }
}
