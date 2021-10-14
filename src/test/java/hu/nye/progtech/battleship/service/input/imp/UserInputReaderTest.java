package hu.nye.progtech.battleship.service.input.imp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link UserInputReader}.
 */
public class UserInputReaderTest {
    private static final String NAME = "Test Name";
    private UserInputReader uir;

    @Test
    public void testUserInputReaderScannerInput(){
        //given
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(NAME.getBytes());
        System.setIn(in);
        uir = new UserInputReader(new Scanner(System.in));
        //when
        String result = uir.readInput();
        //then
        assertEquals(NAME,result);
    }
}
