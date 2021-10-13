package hu.nye.progtech.battleship.service.input.imp;

import java.util.Scanner;

import hu.nye.progtech.battleship.service.input.UserInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User input reader from command line.
 */
public class UserInputReader implements UserInput {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInputReader.class);

    private final Scanner reader;

    public UserInputReader(Scanner reader) {
        this.reader = reader;
    }

    @Override
    public String readInput() {
        String input = null;
        try {
            input = reader.nextLine();
        } catch (Exception e) {
            LOGGER.error("Exception occurred while reading user input", e);
        }

        return input;
    }

}
