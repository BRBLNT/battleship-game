package hu.nye.progtech.battleship.model;

public final class Ship {
    private int posX;
    private int posY;
    private final int size;

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

    public boolean validPosition(String posX,String posY){
        int posX1;
        int posX2;
        int posY1;
        int posY2;
        return false;
    }
    private int convertPosition(String pos){
        int pos1 = -1;
        int pos2 = pos.charAt(1);
        int i = 1;
        for (char a = 'A'; a < 'Z'; a++){
            if(pos.charAt(0) == a)
                pos1 = i;
            i++;
        }
        String tmp = pos1+""+pos2;
        return Integer.parseInt(tmp);
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
