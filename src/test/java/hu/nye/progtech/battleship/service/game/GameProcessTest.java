package hu.nye.progtech.battleship.service.game;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import ch.qos.logback.core.encoder.EchoEncoder;
import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.model.Ship;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.input.MapReader;
import hu.nye.progtech.battleship.service.players.PlayerIsExist;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link GameProcess}
 */
public class GameProcessTest {

    private GameProcess underTest;

    private final String NAME = "C:1";
    private ConfigReader cr;
    private Player p;
    private OpponentAI ai;
    private ArrayList<Ship> ships;

    @Test
    public void testGameProcessInitShouldNotThrownException() throws ConfigurationNotFoundException {
        //given
        PlayerIsExist pie = new PlayerIsExist();
        underTest = new GameProcess();
        cr = new ConfigReader("");
        p = new Player(new Board(Integer.parseInt(cr.getPropertyFromConfig("board.setting.board.size"))),
                Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
        ai = new OpponentAI();
        MapReader mp = new MapReader();
        ai.setBoard(mp.getBoard());
        ByteArrayInputStream in = new ByteArrayInputStream(NAME.getBytes());
        System.setIn(in);
        ships = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            ships.add(new Ship(i));
        }
        ships.get(0).setPosX("1:1");
        ships.get(0).setPosY("1:1");

        ships.get(1).setPosX("2:1");
        ships.get(1).setPosY("2:2");

        ships.get(2).setPosX("3:1");
        ships.get(2).setPosY("3:3");

        ships.get(3).setPosX("4:1");
        ships.get(3).setPosY("4:4");

        ships.get(4).setPosX("5:1");
        ships.get(4).setPosY("5:5");
        //when
        p.setShips(ships);
        underTest.initParticipants(p, ai);
        try {
            underTest.game();
        } catch (Exception e) {
            System.out.println(e);
        }
        //then - excp
    }
}
