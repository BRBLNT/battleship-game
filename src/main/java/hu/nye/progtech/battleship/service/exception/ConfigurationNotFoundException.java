package hu.nye.progtech.battleship.service.exception;

/**
 * Configuration not found exception.
 * When the game cannot load the configuration the game not works.
 */
public class ConfigurationNotFoundException extends Exception {

    public ConfigurationNotFoundException(String message) {
        super(message);
    }
}
