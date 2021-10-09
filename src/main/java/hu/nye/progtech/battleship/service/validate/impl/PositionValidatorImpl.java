package hu.nye.progtech.battleship.service.validate.impl;


import hu.nye.progtech.battleship.service.validate.PositionValidator;

public final class PositionValidatorImpl implements PositionValidator {
    @Override
    public void validPosition(String posX,String posY){
        int posX1;
        int posX2;
        int posY1;
        int posY2;
    }

    @Override
    public int convertPosition(String pos){
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
}
