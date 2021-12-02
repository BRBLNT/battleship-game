package hu.nye.progtech.battleship.service.modify;

import java.util.ArrayList;

import hu.nye.progtech.battleship.model.Board;
import hu.nye.progtech.battleship.model.OpponentAI;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.model.Ship;
import hu.nye.progtech.battleship.service.properties.ConfigReader;

/**
 * Change + to / if all coordinate is in attack.
 */
public class FullShipHit {
    /*
    Under development.
     */

    private static Player player;
    private static OpponentAI ai;

    private static ArrayList<Board> shipsPlayer = new ArrayList<>();
    private static ArrayList<Board> shipsAI = new ArrayList<>();

    public static void init() {
        addShipsToListPlayer(player, shipsPlayer);
    }

    public static void setPlayer(Player playerP) {
        player = playerP;
    }

    public static void setAi(OpponentAI aiI) {
        ai = aiI;
    }


    public static Board newBoardForPlayer() {
        return compareMatrix(shipsPlayer, player.getCleanBoard());
    }

    public static Board newBoardForAi() {
        return compareMatrix(shipsAI, ai.getBoard());
    }



    private static Board compareMatrix(ArrayList<Board> ships, Board board) {
        Board newBoard = board;
        boolean fullHit = false;
        for (Board ship : ships) {
            for (int i = 0; i < ship.getMatrixForBoard().length; i++) {
                for (int j = 0; j < ship.getMatrixForBoard().length; j++) {
                    if (ship.getMatrixForBoard()[i][j] == '1') {
                        if (board.getMatrixForBoard()[i][j] == '1') {
                            fullHit = true;
                        } else {
                            fullHit = false;
                        }
                    }
                }
            }
            if (fullHit) {
                for (int i = 0; i < ship.getMatrixForBoard().length; i++) {
                    for (int j = 0; j < ship.getMatrixForBoard().length; j++) {
                        if (ship.getMatrixForBoard()[i][j] == '1') {
                            if (board.getMatrixForBoard()[i][j] == '1') {
                                board.getMatrixForBoard()[i][j] = '/';
                            }
                        }
                    }
                    newBoard = board;
                }
            }
        }
        return newBoard;
    }




    private static void addShipsToListPlayer(Player p, ArrayList<Board> boards) {
        ArrayList<Ship> temp = p.getShips();
        add(temp, boards);
    }



    private static void add(ArrayList<Ship> temp, ArrayList<Board> boards) {
        for (Ship ship : temp) {
            Board add = new Board(Integer.parseInt((ConfigReader.getPropertyFromConfig("board.setting.board.size"))));
            int posX1 = Integer.parseInt(ship.getPosX().split(":")[0]);
            int posY1 = Integer.parseInt(ship.getPosY().split(":")[0]);
            int posX2 = Integer.parseInt(ship.getPosX().split(":")[1]);
            int posY2 = Integer.parseInt(ship.getPosY().split(":")[1]);
            boolean start = false;
            int counter = 1;
            char[][] newBoardMatrix = add.getMatrixForBoard();
            for (int i = 0; i <= add.getBoardSize(); i++) {
                for (int j = 0; j <= add.getBoardSize(); j++) {
                    if (posX1 == posY1) {
                        if (j == posX2 - 1) {
                            start = true;
                        }
                        if (start && counter <= ship.getSize() && posX1 - 1 == i && posX2 - 1 <= j) {
                            newBoardMatrix[i][j] = '1';
                            counter++;
                        }
                    } else if (posX2 == posY2) {
                        if (i == posX1 - 1) {
                            start = true;
                        }
                        if (start && counter <= ship.getSize() && posX2 - 1 == j && posX1 - 1 <= i) {
                            newBoardMatrix[i][j] = '1';
                            counter++;
                        }
                    }
                }

            }
            boards.add(add);
        }
    }
}
