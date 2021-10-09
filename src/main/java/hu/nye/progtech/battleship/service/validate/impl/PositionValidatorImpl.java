package hu.nye.progtech.battleship.service.validate.impl;


import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import hu.nye.progtech.battleship.service.exception.NotValidPositionException;
import hu.nye.progtech.battleship.service.validate.PositionValidator;

import java.io.NotActiveException;

public final class PositionValidatorImpl implements PositionValidator {

    @Override
    public void validFormat(String pos) throws CoordinateFormatException {
        boolean firstIsLetter = false;
        boolean secondIsNum = false;
        String[] slices = pos.split(":");
        if(slices[0].length() >= 3 || slices[0].length() <= 0){
            throw new CoordinateFormatException("Too much character!");
        }
        else if(slices[1].length() >= 3 || slices[1].length() <= 0){
            throw new CoordinateFormatException("Too much character!");
        }
        for (char a = 'A'; a < 'Z'; a++){
            if (pos.charAt(0) == a) {
                firstIsLetter = true;
                break;
            }
        }
        for (int i = 1; i < 100; i++){
            if (pos.charAt(1) == i){
                secondIsNum = true;
                break;
            }

        }
        if(!firstIsLetter || !secondIsNum)
            throw new CoordinateFormatException("Illegal character!");
    }

    @Override
    public void validPosition(String posX, String posY) throws NotValidPositionException {
        try {
            validFormat(posX);
            validFormat(posY);
        } catch (CoordinateFormatException e) {
            throw new NotValidPositionException("Invalid Format!");
        }
        int posX1 = Integer.parseInt(String.valueOf(convertPosition(posX).charAt(0)));
        int posX2 = Integer.parseInt(String.valueOf(convertPosition(posX).charAt(1)));
        int posY1 = Integer.parseInt(String.valueOf(convertPosition(posY).charAt(0)));
        int posY2 = Integer.parseInt(String.valueOf(convertPosition(posY).charAt(1)));
    }

    @Override
    public String convertPosition(String pos) {
        pos = pos.toUpperCase();
        int pos1 = -1;
        int pos2 = pos.charAt(1);
        int i = 1;
        for (char a = 'A'; a < 'Z'; a++) {
            if (pos.charAt(0) == a)
                pos1 = i;
            i++;
        }
        return pos1 + "" + pos2;

    }
}
