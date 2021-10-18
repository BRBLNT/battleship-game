package hu.nye.progtech.battleship.service.menu;

import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;
import hu.nye.progtech.battleship.service.properties.ConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exit from the game.
 */
public final class Exit {

    private static final Logger LOGGER = LoggerFactory.getLogger(Exit.class);

    private static void exitText() {
        IRender render = new Render();
        IContextBuilder builder = render.newBuilder();
        builder.width(120).height(20);
        builder.element(new PseudoText(ConfigReader.getPropertyFromConfig("game.text.exit.text")));
        ICanvas canvas = render.render(builder.build());
        String s = canvas.getText();
        System.out.println(s);
    }

    /**
     * Exiting form the app.
     */
    public static void exit() {
        exitText();
        LOGGER.info("Exit game");
        System.exit(0);
    }
}
