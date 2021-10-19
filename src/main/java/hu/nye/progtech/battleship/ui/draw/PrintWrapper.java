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
    public static void print(String string) {
        System.out.print(string);
    }

    public static void printLine(String string) {
        System.out.println(string);
    }

    /**
     * Print more empty line.
     *
     * @param lines the numbers of empty lines
     */
    public static void printSpace(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.println("");
        }
    }

    /**
     * Print more thing in line.
     */
    public static void printMore(int times, String string) {
        for (int i = 0; i < times; i++) {
            System.out.print(string);
        }
    }
}
