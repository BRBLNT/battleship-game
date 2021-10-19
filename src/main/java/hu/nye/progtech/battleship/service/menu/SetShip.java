package hu.nye.progtech.battleship.service.menu;

import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.model.Ship;
import hu.nye.progtech.battleship.service.coordinate.CoordinateConverter;
import hu.nye.progtech.battleship.service.exception.CoordinateFormatException;
import hu.nye.progtech.battleship.service.exception.NotValidPositionException;
import hu.nye.progtech.battleship.service.exception.PositionNotValidForSizeException;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import hu.nye.progtech.battleship.service.modify.BoardModifier;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import hu.nye.progtech.battleship.service.validate.EmptyPositionChecker;
import hu.nye.progtech.battleship.service.validate.impl.PositionValidatorImpl;
import hu.nye.progtech.battleship.ui.draw.PrintWrapper;
import hu.nye.progtech.battleship.ui.draw.impl.CommandLineDrawImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Player set ships on the board.
 */
public class SetShip {

    private static final PositionValidatorImpl POSITION_VALIDATOR = new PositionValidatorImpl();
    private static final CoordinateConverter COORDINATE_CONVERTER = new CoordinateConverter();
    private static final BoardModifier BOARD_MODIFIER = new BoardModifier();
    private static final Logger LOGGER = LoggerFactory.getLogger(SetShip.class);

    /**
     * Set ship method player set ships on the board.
     */
    public static void setShip(Player player) {
        new CommandLineDrawImpl().drawBoard(player.getBoard());
        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.set.ship.info"));
        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.ship.avaiablesizes") + " " +
                ConfigReader.getPropertyFromConfig("board.setting.numberofships"));
        int i = 0;
        do {
            re:
            {
                PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.ship.avaiablesizesnotset"));
                for (Ship ship : player.getShips()) {
                    if (ship.getPosY().equals("") && ship.getPosX().equals("")) {
                        PrintWrapper.print(ship.getSize() + " ");
                    }
                }
                PrintWrapper.printLine("");
                String line = UserInputReader.readInput();
                try {
                    POSITION_VALIDATOR.validate(COORDINATE_CONVERTER.sizeCalculator(line), line,
                            Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.numberofships")));
                } catch (PositionNotValidForSizeException | CoordinateFormatException | NotValidPositionException e) {
                    LOGGER.warn("coordinates fault");
                    PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.set.ship.warn"));
                    PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.set.ship.info"));
                    break re;
                }
                try {
                    EmptyPositionChecker.positionIsEmpty(player.getBoard(), line);
                } catch (CoordinateFormatException | NotValidPositionException e) {
                    LOGGER.warn("coordinates fault");
                    PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.set.ship.warn"));
                    PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.set.ship.info"));
                break re;
                }
                for (Ship ship : player.getShips()) {
                    int actualSize = 0;
                    try {
                        actualSize = COORDINATE_CONVERTER.sizeCalculator(line);
                    } catch (CoordinateFormatException e) {
                        LOGGER.warn("coordinates fault");
                        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.set.ship.warn"));
                        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.set.ship.info"));
                        break re;
                    }
                    if (ship.getSize() == actualSize && ship.getPosX().equals("") && ship.getPosY().equals("")) {
                        ship.setPosX(
                                POSITION_VALIDATOR.convertPosition(line.split(":")[0]));
                        ship.setPosY(
                                POSITION_VALIDATOR.convertPosition(line.split(":")[1]));
                        player.getBoard().setMatrixForBoard(BOARD_MODIFIER.modifyBoard(player.getBoard(), ship));
                        new CommandLineDrawImpl().drawBoard(player.getBoard());
                        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.ship.add"));
                        i++;
                    } else if (ship.getSize() == actualSize && !ship.getPosX().equals("") && !ship.getPosY().equals("")) {
                        LOGGER.warn("ship not free");
                        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.set.ship.warn"));
                        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.set.ship.info"));
                        break re;
                    }
                }
                if (line.length() > 5 || !line.contains(":")) {
                    PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.set.ship.info"));
                }
                break re;
            }
        } while (i != player.getNumberOfShips());
        MenuController.setIsShipsSet(true);
        MenuController.chooseMenu(player);
    }


}
