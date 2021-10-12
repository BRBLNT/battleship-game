package hu.nye.progtech.battleship.service.exception;

public class PositionNotValidForSizeException extends Exception{
    public PositionNotValidForSizeException(String message) {
        super(message);
    }
}
