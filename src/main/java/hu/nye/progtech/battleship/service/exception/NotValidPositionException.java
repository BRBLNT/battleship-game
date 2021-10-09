package hu.nye.progtech.battleship.service.exception;

public class NotValidPositionException extends Exception {
    public NotValidPositionException(String message) {
        super(message);
    }
}
