package hu.nye.progtech.battleship;

public class Ship {
    private int posX;
    private int posY;
    private int size;

    public Ship(int size) {
        this.size = size;
    }

    public Ship(int posX, int posY, int size) {
        this.posX = posX;
        this.posY = posY;
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

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", size=" + size +
                '}';
    }
}
