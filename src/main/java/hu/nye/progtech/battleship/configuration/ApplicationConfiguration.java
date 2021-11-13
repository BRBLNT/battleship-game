package hu.nye.progtech.battleship.configuration;

import java.util.Scanner;

import hu.nye.progtech.battleship.service.game.GameController;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration.
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public GameController gameController(String config, UserInputReader userInputReader) {
        return new GameController(config, userInputReader);
    }

    @Bean
    public UserInputReader userInputReader() {
        return new UserInputReader(new Scanner(System.in));
    }

    @Bean
    public String config() {
        return "config.properties";
    }
}
