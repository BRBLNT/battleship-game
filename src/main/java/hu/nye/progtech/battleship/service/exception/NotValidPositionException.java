package hu.nye.progtech.battleship.service.exception;

/**
 * Not valid position exception.
 * If coordinate not inline.
 */
public class NotValidPositionException extends Exception {
    public NotValidPositionException(String message) {
        super(message);
    }
}
