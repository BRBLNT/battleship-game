package hu.nye.progtech.battleship.service.menu;

import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.persistance.SavePlayersToRepository;
import hu.nye.progtech.battleship.persistance.impl.SavePlayersToRepositoryJDBC;
import hu.nye.progtech.battleship.service.ai.GenerateOpponent;
import hu.nye.progtech.battleship.service.game.GameController;
import hu.nye.progtech.battleship.service.game.GameProcess;
import hu.nye.progtech.battleship.service.players.PlayerIsExist;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import hu.nye.progtech.battleship.ui.draw.PrintWrapper;

/**
 * Start game menu.
 */
public final class StartGame {
    /**
     * Start game if everything is set.
     */
    public static void startGame(Player player) {
        if (player.getName() == null) {
            PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.name.notset"));
            MenuController.chooseMenu(player);
        } else if (!MenuController.isIsShipsSet()) {
            PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.ship.notset"));
            MenuController.chooseMenu(player);
        } else {
            int wins = PlayerIsExist.numberOfWinsSet(player, MenuController.getPlayerList());
            if (wins != 0) {
                player.setNumberOfWins(wins);
            } else {
                GameController.savePlayer(player);
            }
            GameProcess.initParticipants(player, GenerateOpponent.generate());
            GameProcess.game();
        }
    }
}
