package hu.nye.progtech.battleship.persistance.impl;

import java.sql.Connection;
import java.util.List;

import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.persistance.SavePlayersToRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements interface for JDBC.
 */
public class SavePlayersToRepositoryJDBC implements SavePlayersToRepository, AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(SavePlayersToRepositoryJDBC.class);

    private static final String INSERT_STATEMENT = "INSERT INTO game_saves (name, wins) VALUES (?, ?);";
    private static final String SELECT_STATEMENT = "SELECT * FROM game_saves WHERE name = ?;";
    private static final String SELALL_STATEMENT = "SELECT * FROM game_saves;";
    private static final String DELETE_STATEMENT = "DELETE FROM game_saves WHERE name = ?;";
    private static final String UPDATE_STATEMENT = "UPDATE game_saves SET wins = ? WHERE name = ?;";

    private Connection connection;

    private List<Player> players;

    public SavePlayersToRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void close() throws Exception {
        connection.close();
    }


    @Override
    public void save(Player player) {

    }

    @Override
    public List<Player> load() {
        return null;
    }
}
