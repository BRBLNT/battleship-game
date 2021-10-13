package hu.nye.progtech.battleship.service.exception;

/**
 * Not valid position for this size exception.
 * If coordinate distance longer than ship size throw exception.
 */
public class PositionNotValidForSizeException extends Exception {
    public PositionNotValidForSizeException(String message) {
        super(message);
    }
}
