package hu.nye.progtech.battleship.persistance;

import java.util.List;

import hu.nye.progtech.battleship.model.Player;

/**
 * Interface for persistence store.
 */
public interface SavePlayersToRepository {

    void save(Player player);

    List<Player> load();
}
