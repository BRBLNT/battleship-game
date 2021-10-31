package hu.nye.progtech.battleship.service.exception;

/**
 * Not valid position for the hit.
 * Target not exist or wrong format.
 */
public class TargetPositionNotValid extends Exception {
    public TargetPositionNotValid(String message) {
        super(message);
    }
}
