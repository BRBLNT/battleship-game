package hu.nye.progtech.battleship.service.input;

import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserInputReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInputReader.class);

    private final Scanner reader;

    public UserInputReader(Scanner reader) {
        this.reader = reader;
    }

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
