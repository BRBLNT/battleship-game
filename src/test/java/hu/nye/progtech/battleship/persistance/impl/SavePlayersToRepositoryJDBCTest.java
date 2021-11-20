package hu.nye.progtech.battleship.persistance.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.persistance.SavePlayersToRepository;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Unit tests for {@link SavePlayersToRepositoryJDBC}
 */
public class SavePlayersToRepositoryJDBCTest {

    @Mock
    private String wrongCommand = "SEL";
    @InjectMocks
    private SavePlayersToRepositoryJDBC underTest;
    private Connection connection;
    private ConfigReader cr;



    @Test
    public void testShouldNotThrownExceptions() {
        //given
        try {
            connection = DriverManager.getConnection("jdbc:h2:./bs", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cr = new ConfigReader("");
        } catch (ConfigurationNotFoundException e) {
            e.printStackTrace();
        }
        underTest = new SavePlayersToRepositoryJDBC(connection);
        //when
        underTest.load();
        //then - exception
    }

    @Test
    public void testShouldNotThrownExceptionsWhenPlayerExist() {
        //given
        try {
            connection = DriverManager.getConnection("jdbc:h2:./bs", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cr = new ConfigReader("");
        } catch (ConfigurationNotFoundException e) {
            e.printStackTrace();
        }
        String name = "Montana";
        int win = 0;
        Player temp = new Player(new Board(
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        temp.setName(name);
        temp.setNumberOfWins(win);
        underTest = new SavePlayersToRepositoryJDBC(connection);

        //when
        underTest.save(temp);
        //then - exception
    }

    @Test
    public void testShouldNotThrownExceptionsWhenPlayerNotExist() {
        //given
        try {
            connection = DriverManager.getConnection("jdbc:h2:./bs", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            cr = new ConfigReader("");
        } catch (ConfigurationNotFoundException e) {
            e.printStackTrace();
        }
        String name = "Omar";
        int win = 0;
        Player temp = new Player(new Board(
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        temp.setName(name);
        temp.setNumberOfWins(win);
        underTest = new SavePlayersToRepositoryJDBC(connection);

        //when
        underTest.save(temp);
        //then - exception
    }


}
