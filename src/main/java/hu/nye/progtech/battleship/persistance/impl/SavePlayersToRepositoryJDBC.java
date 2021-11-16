package hu.nye.progtech.battleship.persistance.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.persistance.SavePlayersToRepository;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements interface for JDBC.
 */
public class SavePlayersToRepositoryJDBC implements SavePlayersToRepository, AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(SavePlayersToRepositoryJDBC.class);

    private static final String INSERT_STATEMENT = "INSERT INTO game_saves (name, wins) VALUES (?, ?);";
    private static final String SELECT_STATEMENT = "SELECT * FROM game_saves WHERE name = ?;";
    private static final String SELALL_STATEMENT = "SELECT * FROM GAME_SAVES ORDER BY WINS DESC;";
    private static final String DELETE_STATEMENT = "DELETE FROM game_saves WHERE name = ?;";
    private static final String UPDATE_STATEMENT = "UPDATE game_saves SET wins = ? WHERE name = ?;";


    private static final String CREATE_TABLE = "CREATE TABLE game_saves (\n" +
            "    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
            "    name varchar(255) NOT NULL,\n" +
            "    wins int NOT NULL\n" +
            ");";

    private Connection connection;

    private List<Player> players;

    public SavePlayersToRepositoryJDBC(Connection connection) {
        players = new ArrayList<>();
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

        try {
            loadAll();
            return players;
        } catch (SQLException throwables) {
            System.out.println(throwables);
            LOGGER.warn(throwables + "sql error while select all");
        }
        return null;
    }

    private void loadAll() throws SQLException {
        Statement statement = connection.createStatement();
        //statement.execute("INSERT INTO game_saves (name, wins) VALUES ('Montana', 2);");
        ResultSet resultSet = statement.executeQuery(SELALL_STATEMENT);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int win = Integer.parseInt(resultSet.getString("wins"));
            Player temp = new Player(new Board(
                    Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.board.size"))),
                    Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
            temp.setName(name);
            temp.setNumberOfWins(win);
            players.add(temp);
        }
    }
}
