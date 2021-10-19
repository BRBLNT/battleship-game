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
        boolean firstIsLetterFirstPos = false;
        boolean secondIsNumFirstPos = false;
        boolean firstIsLetterSecondPos = false;
        boolean secondIsNumSecondPos = false;
        pos = pos.toUpperCase();
        String[] slices = pos.split(":");
        if (slices.length < 2) {
            throw new CoordinateFormatException("Wrong format");
        }
        if (slices[0].length() > 3 || slices[0].length() <= 0) {
            LOGGER.warn("pos contains too much character");
            throw new CoordinateFormatException("Too much character!");
        } else if (slices[1].length() > 3 || slices[1].length() <= 0) {
            LOGGER.warn("pos contains too much character");
            throw new CoordinateFormatException("Too much character!");
        }

        for (char a = 'A'; a < 'Z'; a++) {
            if (slices[0].charAt(0) == a) {
                firstIsLetterFirstPos = true;
                break;
            }
        }
        for (int i = 1; i < 100; i++) {
            if (slices[0].charAt(1) == i) {
                secondIsNumFirstPos = true;
                break;
            }

        }
        for (char a = 'A'; a < 'Z'; a++) {
            if (slices[1].charAt(0) == a) {
                firstIsLetterSecondPos = true;
                break;
            }
        }
        for (int i = 1; i < 100; i++) {
            if (slices[1].charAt(1) == i) {
                secondIsNumSecondPos = true;
                break;
            }

        }
        if (!firstIsLetterFirstPos || !secondIsNumFirstPos || !firstIsLetterSecondPos || !secondIsNumSecondPos) {
            LOGGER.warn("pos contains illegal character or not valid format");
            throw new CoordinateFormatException("Illegal character or not valid format!");
        }
        return;
    }

    @Override
    public void validPositionInline(String pos) throws NotValidPositionException {
        String[] slices = pos.split(":");
        if (slices.length < 2) {
            throw new NotValidPositionException("Wrong format");
        }
        String posX = slices[0];
        String posY = slices[1];
        int posX1 = Integer.parseInt(String.valueOf(convertPosition(posX).split(":")[0]));
        int posX2 = Integer.parseInt(String.valueOf(convertPosition(posX).split(":")[1]));
        int posY1 = Integer.parseInt(String.valueOf(convertPosition(posY).split(":")[0]));
        int posY2 = Integer.parseInt(String.valueOf(convertPosition(posY).split(":")[1]));
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
        int pos2 = -1;
        if (pos.length() > 2) {
            pos2 = Integer.parseInt(pos.substring(1, 3));
        } else if (pos.length() == 2) {
            pos2 = Integer.parseInt(pos.substring(1, 2));
        }
        int i = 1;
        for (char a = 'A'; a <= 'Z'; a++) {
            if (pos.charAt(0) == a) {
                pos1 = i;
                break;
            }
            i++;
        }
        return pos1 + ":" + pos2;

    }

    @Override
    public void checkLength(int size, String pos, int maxSize) throws PositionNotValidForSizeException {
        String[] slices = pos.split(":");
        if (slices.length < 2) {
            throw new PositionNotValidForSizeException("Wrong format");
        }
        int cordLength = 0;
        int posX1 = Integer.parseInt(String.valueOf(convertPosition(slices[0]).split(":")[0]));
        int posX2 = Integer.parseInt(String.valueOf(convertPosition(slices[0]).split(":")[1]));
        int posY1 = Integer.parseInt(String.valueOf(convertPosition(slices[1]).split(":")[0]));
        int posY2 = Integer.parseInt(String.valueOf(convertPosition(slices[1]).split(":")[1]));
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
        if (size == 0) {
            throw new NotValidPositionException("Wrong size");
        }
        validFormat(pos);
        validPositionInline(pos);
        checkLength(size, pos, maxSize);
    }
}
