package hu.nye.progtech.battleship.service.modify;

import java.util.ArrayList;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.model.Ship;
import hu.nye.progtech.battleship.service.exception.ConfigurationNotFoundException;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link FullShipHit}
 */
public class FullShipHitTest {

    private FullShipHit underTest;

    @Test
    public void testFullShipHit() throws ConfigurationNotFoundException {
        underTest = new FullShipHit();
        ConfigReader cr = new ConfigReader("");
        Player p = new Player(new Board(Integer.parseInt((ConfigReader.getPropertyFromConfig("board.setting.board.size")))), 2);
        ArrayList<Ship> ships = new ArrayList<Ship>();
        Ship temp;
        temp = new Ship(1);
        temp.setPosX("1:1");
        temp.setPosY("1:1");
        ships.add(temp);
        temp = new Ship(2);
        temp.setPosX("3:1");
        temp.setPosY("3:2");
        ships.add(temp);
        p.setShips(ships);
        //underTest.addShipsToListPlayer(p, new ArrayList<Board>());
    }
}
