package hu.nye.progtech.battleship.service.coordinate;

import hu.nye.progtech.battleship.service.validate.impl.PositionValidatorImpl;

public final class CoordinateConverter {

    private static final PositionValidatorImpl pvi = new PositionValidatorImpl();

    public int sizeCalculator(String pos){
        int size = 0;
        if(pos.length() == 0)
            return -1;
        String[] slices = pos.split(":");
        String posX = slices[0];
        String posY = slices[1];
        int posX1 = Integer.parseInt(String.valueOf(pvi.convertPosition(posX).charAt(0)));
        int posX2 = Integer.parseInt(String.valueOf(pvi.convertPosition(posX).charAt(1)));
        int posY1 = Integer.parseInt(String.valueOf(pvi.convertPosition(posY).charAt(0)));
        int posY2 = Integer.parseInt(String.valueOf(pvi.convertPosition(posY).charAt(1)));
        if(posX1 == posY1){
            size = posY2-posX2;
        }else if(posX2 == posY2){
            size = posY1-posX1;
        }
        return size+1;
    }
}
