package hu.nye.progtech.battleship.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import hu.nye.progtech.battleship.persistance.SavePlayersToRepository;
import hu.nye.progtech.battleship.persistance.impl.SavePlayersToRepositoryJDBC;
import hu.nye.progtech.battleship.service.game.GameController;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration.
 */
@Configuration
public class ApplicationConfiguration {

    @Bean(initMethod = "start")
    public GameController gameController(String config, UserInputReader userInputReader, Connection connection) {
        return new GameController(config, userInputReader, connection);
    }

    @Bean
    public UserInputReader userInputReader() {
        return new UserInputReader(new Scanner(System.in));
    }

    @Bean
    public String config() {
        return "config.properties";
    }

    @Bean
    public Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:./bs", "sa", "");
    }

}
