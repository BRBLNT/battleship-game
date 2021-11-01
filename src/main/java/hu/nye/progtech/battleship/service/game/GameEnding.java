package hu.nye.progtech.battleship.service.game;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;
import hu.nye.progtech.battleship.model.Player;
import hu.nye.progtech.battleship.service.menu.MenuController;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import hu.nye.progtech.battleship.ui.draw.PrintWrapper;

/**
 * Game end. Player lose or win.
 */
public class GameEnding {

    /**
     * LOSE the game .
     */
    public static void lose(Player p) {
        p.setNumberOfGames(p.getNumberOfGames() + 1);
        PrintWrapper.printSpace(10);
        text("game.text.lose");
        MenuController.chooseMenu(p);
    }

    /**
     * WIN the game .
     */
    public static void win(Player p) {
        p.setNumberOfGames(p.getNumberOfGames() + 1);
        p.setNumberOfWins(p.getNumberOfWins() + 1);
        PrintWrapper.printSpace(10);
        text("game.text.win");
        MenuController.chooseMenu(p);
    }

    private static void text(String prop) {
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(120).height(20);
        builder.element(new PseudoText(ConfigReader.getPropertyFromConfig(prop)));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(s);
    }
}
