package hu.nye.progtech.battleship.service.validate;

import java.util.Locale;

import hu.nye.progtech.battleship.model.Player;
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
        if (slices.length < 2) {
            return false;
        }
        int size = 0;
        for (char a = 'A'; a <= 'Z'; a++) {
            if (slices[0].toUpperCase().charAt(0) == a) {
                break;
            }
            size++;
        }
        if (size > maxSize || Integer.parseInt(slices[1]) - 1 > maxSize) {
            return false;
        }
        return true;
    }


    /**
     * Check position not hit before.
     */
    public static boolean positionNotHiteBefore(String pos, Player p) {
        String[] slices = pos.split(":");
        if (slices.length < 2) {
            return false;
        }
        int size = 0;
        for (char a = 'A'; a <= 'Z'; a++) {
            if (slices[0].toUpperCase().charAt(0) == a) {
                break;
            }
            size++;
        }
        if (p.getHits()[size][Integer.parseInt(slices[1]) - 1]) {
            return false;
        }
        return true;
    }
}
