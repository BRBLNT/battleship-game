package hu.nye.progtech.battleship;

import hu.nye.progtech.battleship.service.game.GameLogic;

public class Main {
    public static void main(String[] args) {
        GameLogic gl = new GameLogic();
        gl.init("config.properties");
        gl.chooseMenu();
    }


}
