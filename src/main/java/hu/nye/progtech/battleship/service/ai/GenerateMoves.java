package hu.nye.progtech.battleship.service.ai;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import hu.nye.progtech.battleship.ui.draw.impl.CommandLineDrawImpl;

/**
 * Choose moves for the bot.
 */
public class GenerateMoves {

    private static final int size = Integer.parseInt(ConfigReader.getPropertyFromConfig("board.setting.board.size"));
    private static final CommandLineDrawImpl CLDI = new CommandLineDrawImpl();

    private static boolean randomTwoOption() {
        int num = (int) ((Math.random() * 100) + 1);
        return num % 2 == 0;

    }

    private static int generateX() {
        return (int) (Math.random() * size);
    }

    private static int generateY() {
        return (int) (Math.random() * size);
    }

    private static boolean notHitBefore(OpponentAI bot, int x, int y) {
        boolean[][] hits = bot.getHits();
        return !hits[x][y];
    }

    private static boolean hit(Player p, int x, int y) {
        System.out.println(x + " " + y);
        return p.getBoard().getMatrixForBoard()[x][y] == '1';
    }

    /**
     * If bot is the next choose coordinate checks not hit before and when it is a hit choose a +-1 cord.
     */
    public static boolean botStep(Player p, OpponentAI bot) {
        int x = generateX();
        int y = generateY();
        if (!notHitBefore(bot, x, y) || x >= size || y >= size) {
            do {
                x = generateX();
                y = generateY();
            } while (!notHitBefore(bot, x, y));
        }
        Board temp = p.getBoard();
        char[][] matrix  = temp.getMatrixForBoard();
        if (hit(p, x, y)) {

            matrix[x][y] = '+';
            boolean run = true;
            do {
                if (randomTwoOption()) {
                    if (randomTwoOption() || x == 9) {
                        x = x - 1;
                    } else {
                        x = x + 1;
                    }
                } else {
                    if (randomTwoOption() || y == 9) {
                        y = y - 1;
                    } else {
                        y = y + 1;
                    }
                }
                if (hit(p, x, y)) {
                    matrix[x][y] = '+';
                } else {
                    matrix[x][y] = 'X';
                    run = false;
                }
            } while (run);
        } else {
            matrix[x][y] = 'X';

        }
        temp.setMatrixForBoard(matrix);
        p.setBoard(temp);
        CLDI.drawBoard(p.getBoard());
        return false;
    }

}
