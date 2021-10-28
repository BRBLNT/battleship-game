package hu.nye.progtech.battleship.service.ai;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.model.Player;

/**
 * Choose moves for the bot.
 */
public class GenerateMoves {

    private boolean randomTwoOption() {
        int num = (int)((Math.random()*100)+1);
        if (num % 2 == 0) {
            return true;
        }
        return false;

    }

    private static int generateX(OpponentAI bot) {
        return (int) (Math.random()*bot.getBoard().getBoardSize())+0;
    }

    private static int generateY(OpponentAI bot) {
        return (int) (Math.random()*bot.getBoard().getBoardSize())+0;
    }

    private boolean notHitBefore(OpponentAI bot, int x, int y) {
        boolean[][] hits = bot.getHits();
        if (hits[x][y] == true) {
            return false;
        }
        return true;
    }

    private boolean hit(Player p, int x, int y) {
        if (p.getBoard().getMatrixForBoard()[x][y] == '1') {
            return true;
        }
        return false;
    }

    /**
     * If bot is the next choose coordinate checks not hit before and when it is a hit choose a +-1 cord.
     */
    public void botStep(Player p, OpponentAI bot) {
        int x = generateX(bot);
        int y = generateY(bot);
        if (!notHitBefore(bot, x, y)) {
            do {
                x = generateX(bot);
                y = generateY(bot);
            } while (!notHitBefore(bot, x, y));
        }
        Board temp = p.getBoard();
        char[][] matrix  = temp.getMatrixForBoard();
        if (hit(p, x, y)) {

            matrix[x][y] = '+';
            boolean run = true;
            do {
                if (randomTwoOption()) {
                    if (randomTwoOption()) {
                        x = x-1;
                    } else {
                        x = x+1;
                    }
                } else {
                    if (randomTwoOption()) {
                        y = y-1;
                    } else {
                        y = y+1;
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
    }

}
