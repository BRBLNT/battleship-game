package hu.nye.progtech.battleship.service.coordinate;

import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import hu.nye.progtech.battleship.service.validate.impl.PositionValidatorImpl;

/**
 * Convert coordinates from full form to number or calculate distance between positions.
 * example: A1 to 11 or C1 to 31.
 */
public final class CoordinateConverter {

    private static final PositionValidatorImpl pvi = new PositionValidatorImpl();

    /**
     * Calculate distance between 2 position.
     * example: A1:A2 size is 2.
     */
    public int sizeCalculator(String pos) throws CoordinateFormatException {
        int size = -1;
        String[] slices;
        if (pos.length() < 4 || pos.length() > 7) {
            throw new CoordinateFormatException("Wrong format");
        }
        slices = pos.split(":");
        String posX = slices[0];
        String posY = slices[1];
        int posX1 = Integer.parseInt(String.valueOf(pvi.convertPosition(posX).split(":")[0]));
        int posX2 = Integer.parseInt(String.valueOf(pvi.convertPosition(posX).split(":")[1]));
        int posY1 = Integer.parseInt(String.valueOf(pvi.convertPosition(posY).split(":")[0]));
        int posY2 = Integer.parseInt(String.valueOf(pvi.convertPosition(posY).split(":")[1]));
        if (posX1 == posY1) {
            size = posY2 - posX2;
        } else if (posX2 == posY2) {
            size = posY1 - posX1;
        }
        //System.out.println(pos + "size: " + size +" " + posX1 + " " + posX2 + " " + posY1 + " " + posY2 + "  " + posX + " - " + posY);
        return size + 1;
    }
}
