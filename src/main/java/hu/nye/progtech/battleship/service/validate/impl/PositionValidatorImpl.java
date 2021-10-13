package hu.nye.progtech.battleship.service.validate.impl;


import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import hu.nye.progtech.battleship.service.exception.NotValidPositionException;
import hu.nye.progtech.battleship.service.exception.PositionNotValidForSizeException;
import hu.nye.progtech.battleship.service.validate.PositionValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Position Validator Implementation.
 * Implements PositionValidator interface.
 */
public final class PositionValidatorImpl implements PositionValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionValidatorImpl.class);

    @Override
    public void validFormat(String pos) throws CoordinateFormatException {
        boolean firstIsLetter = false;
        boolean secondIsNum = false;
        pos = pos.toUpperCase();
        String[] slices = pos.split(":");
        if (slices[0].length() >= 3 || slices[0].length() <= 0) {
            LOGGER.warn("pos contains too much character");
            throw new CoordinateFormatException("Too much character!");
        } else if (slices[1].length() >= 3 || slices[1].length() <= 0) {
            LOGGER.warn("pos contains too much character");
            throw new CoordinateFormatException("Too much character!");
        }
        for (char a = 'A'; a < 'Z'; a++) {
            if (pos.charAt(0) == a) {
                firstIsLetter = true;
                break;
            }
        }
        for (int i = 1; i < 100; i++) {
            if (pos.charAt(1) == i) {
                secondIsNum = true;
                break;
            }

        }
        if (!firstIsLetter || !secondIsNum) {
            LOGGER.warn("pos contains illegal character");
            throw new CoordinateFormatException("Illegal character!");
        }
    }

    @Override
    public void validPositionInline(String pos) throws NotValidPositionException {
        String[] slices = pos.split(":");
        String posX = slices[0];
        String posY = slices[1];
        int posX1 = Integer.parseInt(String.valueOf(convertPosition(posX).charAt(0)));
        int posX2 = Integer.parseInt(String.valueOf(convertPosition(posX).charAt(1)));
        int posY1 = Integer.parseInt(String.valueOf(convertPosition(posY).charAt(0)));
        int posY2 = Integer.parseInt(String.valueOf(convertPosition(posY).charAt(1)));
        LOGGER.info(posX1 + " " + posX2 + " " + posY1 + " " + posY2 + "  " + posX + " - " + posY);
        if (posX1 == posY1 || posX2 == posY2) {
            return;
        } else  {
            LOGGER.warn("ships not inline");
            throw new NotValidPositionException("Not Inline!");
        }

    }

    @Override
    public String convertPosition(String pos) {
        pos = pos.toUpperCase();
        int pos1 = -1;
        int pos2 = Integer.parseInt(pos.substring(1, 2));
        int i = 1;
        for (char a = 'A'; a < 'Z'; a++) {
            if (pos.charAt(0) == a) {
                pos1 = i;
            }
            i++;
        }
        return pos1 + "" + pos2;

    }

    @Override
    public void checkLength(int size, String pos, int maxSize) throws PositionNotValidForSizeException {
        String[] slices = pos.split(":");
        int cordLength = 0;
        int posX1 = Integer.parseInt(String.valueOf(convertPosition(slices[0]).charAt(0)));
        int posX2 = Integer.parseInt(String.valueOf(convertPosition(slices[0]).charAt(1)));
        int posY1 = Integer.parseInt(String.valueOf(convertPosition(slices[1]).charAt(0)));
        int posY2 = Integer.parseInt(String.valueOf(convertPosition(slices[1]).charAt(1)));
        if (posX1 == posY1) {
            cordLength = posY2 - posX2;
        } else if (posX2 == posY2) {
            cordLength = posY1 - posX1;
        }
        if (cordLength + 1 != size || cordLength + 1 > maxSize) {
            LOGGER.warn("coordination not valid for this size");
            throw new PositionNotValidForSizeException("Coordination not valid for this size");
        }
    }

    @Override
    public void validate(int size, String pos, int maxSize)
            throws PositionNotValidForSizeException, CoordinateFormatException, NotValidPositionException {
        validFormat(pos);
        validPositionInline(pos);
        checkLength(size, pos, maxSize);
    }
}
