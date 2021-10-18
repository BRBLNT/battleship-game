package hu.nye.progtech.battleship.service.menu;

import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Set name menu we can set name for the player.
 */
public final class SetName {

    private static final Logger LOGGER = LoggerFactory.getLogger(SetName.class);

    private static String getPlayerName() {
        String readName;
        do {
            System.out.println(ConfigReader.getPropertyFromConfig("game.text.name.get"));
            readName = UserInputReader.readInput();
            if (readName.length() < 3) {
                System.out.println(ConfigReader.getPropertyFromConfig("game.text.name.length"));
                LOGGER.warn("name length not enough");
            }
        } while (readName.length() < 3);
        System.out.println(ConfigReader.getPropertyFromConfig("game.text.name.welcome") + " " + readName + "!\n");
        LOGGER.info("name set successfully actual name:" + readName);
        return readName;
    }

    /**
     * Set name for the player.
     */
    public static void setName(Player player) {
        player.setName(getPlayerName());
        if (player.getName() != null || player.getName() != "") {
            MenuController.chooseMenu(player);
        }
    }
}
