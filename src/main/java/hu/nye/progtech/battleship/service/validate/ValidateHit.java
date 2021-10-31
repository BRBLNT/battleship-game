package hu.nye.progtech.battleship.service.validate;

import java.util.Locale;

import hu.nye.progtech.battleship.service.exception.TargetPositionNotValid;

/**
 * During the game this class checks players input coordinate.
 */
public class ValidateHit {

    /**
     * Check position in board.
     */
    public static boolean positionOnBoard(String pos, int maxSize) {
        String[] slices = pos.split(":");
        if (slices.length < 1) {
            return false;
        }
        int size = 1;
        for (char a = 'A'; a <= 'Z'; a++) {
            if (slices[0].toUpperCase().charAt(0) == a) {
                break;
            }
            size++;
        }
        if (size > maxSize || Integer.parseInt(slices[2]) > maxSize) {
            return false;
        }
        return true;
    }
}
