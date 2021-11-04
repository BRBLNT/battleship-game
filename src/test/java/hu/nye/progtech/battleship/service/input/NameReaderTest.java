package hu.nye.progtech.battleship.service.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link NameReader}
 */
public class NameReaderTest {

    private static final String DEFAULT_NAME = "Alejandro Sosa";

    private static ArrayList<String> names = new ArrayList<>();
    private static String NAME_OF_NAMES_FILE = "ai/names.txt";
    private static String WRONG_NAME_OF_NAMES_FILE = "i/na.txt";

    private NameReader underTest;

    /*
    @Test
    public void testRandomNameWhenNoFileShouldReturnDefaultName() {
        //given
        underTest = new NameReader();
        underTest.setNameOfNamesFile(WRONG_NAME_OF_NAMES_FILE);
        String temp;
        //when
        temp = underTest.readRandomNameForTheBot();
        //then
        assertEquals(DEFAULT_NAME, temp);
    }

     */

    @Test
    public void testFileReaderReadFileSuccessfullyAndCheckContainedNames() {
        //given
        underTest = new NameReader();
        upload(NAME_OF_NAMES_FILE);
        underTest.setNameOfNamesFile(NAME_OF_NAMES_FILE);
        String temp;
        //when
        temp = underTest.readRandomNameForTheBot();
        //then
        assertTrue(names.contains(temp));
    }

    private static void upload(String file) {
        try {
            InputStream is = MapReader.class.getClassLoader().getResourceAsStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (Exception ex) {
            //not needed
        }
    }
}
