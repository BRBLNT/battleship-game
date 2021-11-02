package hu.nye.progtech.battleship.service.input;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Read name for the bot if names file not exist give a default name.
 */
public class NameReader {
    private static final ArrayList<String> names = new ArrayList<>();
    private static final String NAME_OF_NAMES_FILE = "ai/names.txt";
    private static final Logger LOGGER = LoggerFactory.getLogger(NameReader.class);
    private static final String DEFAULT_NAME = "Alejandro Sosa";

    /**
     * Read a random name for the bot from a txt.
     */
    public static String readRandomNameForTheBot() {
        upload(NAME_OF_NAMES_FILE);
        if (names.isEmpty()) {
            return DEFAULT_NAME;
        }
        int random = (int) (Math.random() * names.size());
        return names.get(random);
    }

    private static void upload(String file) {

        InputStream is = MapReader.class.getClassLoader().getResourceAsStream(file);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException ex) {
            LOGGER.error("no names file use default name");
        }
    }
}
