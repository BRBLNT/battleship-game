package hu.nye.progtech.battleship;

import hu.nye.progtech.battleship.service.game.GameController;

public class Main {
    public static void main(String[] args) {
        GameController gl = new GameController();
        gl.init("config.properties");
        gl.chooseMenu();
    }


}
