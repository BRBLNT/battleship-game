package hu.nye.progtech.battleship.service.properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import org.junit.jupiter.api.Test;


/**
 * Unit tests for {@link ConfigReader}.
 */
public class ConfigReaderTest {

    private final String WRONG_NAME = "config.prop";
    private ConfigReader underTest;

    @Test
    public void testReadPropertiesShouldThrowException() {
        //given
        boolean thrown = false;

        //when
        try {
            underTest = new ConfigReader(WRONG_NAME);
        } catch (ConfigurationNotFoundException e) {
            thrown = true;
        }
        //then
        assertTrue(thrown);
    }
}
