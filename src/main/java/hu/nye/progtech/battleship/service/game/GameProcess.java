package hu.nye.progtech.battleship.service.game;

import java.lang.instrument.ClassDefinition;

import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.input.imp.UserInputReader;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import hu.nye.progtech.battleship.service.validate.ValidateHit;
import hu.nye.progtech.battleship.ui.draw.PrintWrapper;
import hu.nye.progtech.battleship.ui.draw.impl.CommandLineDrawImpl;

/**
 * This class manage game process.
 */
public class GameProcess {
    private static final CommandLineDrawImpl CLDI = new CommandLineDrawImpl();
    private static Player player;
    private static OpponentAI ai;

    /**
     * Store who step last for check who win.
     * true : player
     * false : bot .
     */
    private static boolean lastStep = true;

    public static void initParticipants(Player p, OpponentAI oai) {
        player = p;
        ai = oai;
    }

    /**
     * Players always start the game.
     */
    public static void game() {
        PrintWrapper.printLine(
                ConfigReader.getPropertyFromConfig("game.text.opponentname") + " " + ai.getName() + " !");

    }

    private static void playerStep() {
        lastStep = true;
        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.playerturn"));
        PrintWrapper.printSpace(2);
        CLDI.drawBoard(player.getCleanBoard());
        PrintWrapper.printSpace(2);
        PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.playerturnhelp"));
        String input;
        boolean run = true;
        boolean again = false;
        do {
            input = UserInputReader.readInput();
            if (ValidateHit.positionOnBoard(input,
                    Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.board.size")))) {
                run = false;
                break;
            }
            PrintWrapper.printLine(ConfigReader.getPropertyFromConfig("game.text.targetnotvalid"));
        } while (run);

        //check hit if hit again = true

        if (again) {
            again = false;
            playerStep();
        } else {
            botStep();
        }
    }

    private static void botStep() {
        lastStep = false;
    }


    private boolean win() {
        return false;
    }
}
