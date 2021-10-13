package hu.nye.progtech.battleship.ui.draw;

/**
 * Util class used to wrap operations that print to stdout.
 * Created for making unit testing easier.
 */
public class PrintWrapper {

    /**
     * Prints a line to stdout.
     *
     * @param string the string to print
     */
    public void print(String string) {
        System.out.print(string);
    }
}
