package hu.nye.progtech.battleship.service.exception;

/**
 * Not valid coordinate format.
 * If coordinate not contains 2 number, 2 letter and 1 ':' throw exception.
 */
public class CoordinateFormatException extends Exception {
    public CoordinateFormatException(String message) {
        super(message);
    }
}
