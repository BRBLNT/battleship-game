package hu.nye.progtech.battleship;



import hu.nye.progtech.battleship.service.GameLogic;


public class Main {



    public static void main(String[] args) {
        GameLogic gl = new GameLogic();
        gl.init();
        gl.chooseMenu();
    }



}
