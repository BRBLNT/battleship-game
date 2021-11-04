package hu.nye.progtech.battleship.service.input;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import hu.nye.progtech.battleship.model.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Read pre-made maps from file.
 */
public class MapReader {

    private static Board board;
    private static final int DEFAULT_SIZE = 10;
    private static String nameOfMapFile = "ai/boards.txt";
    private static ArrayList<String> lines = new ArrayList<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(MapReader.class);

    public static String getNameOfMapFile() {
        return nameOfMapFile;
    }

    public static void setNameOfMapFile(String nameOfMapFile) {
        MapReader.nameOfMapFile = nameOfMapFile;
    }

    private static void readMapDefaultSize() {
        board = new Board(DEFAULT_SIZE);
        upload(nameOfMapFile);
        int random = (int) (Math.random() * lines.size());
        board.setMatrixForBoard(mapFormatter(lines.get(random)));
    }

    private static void upload(String file) {
        LOGGER.info("read board for bot");
        try {
            InputStream is = MapReader.class.getClassLoader().getResourceAsStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception ex) {
            LOGGER.error("no boards file");
        }
    }

    private static char[][] mapFormatter(String s) {
        char[][] matrix = new char[10][10];
        String[] slices = s.split(";");
        for (int i = 0; i < slices.length; i++) {
            for (int j = 0; j < slices[i].length(); j++) {
                matrix[i][j] = slices[i].charAt(j);
            }
        }
        return matrix;
    }

    /**
     * Read map if the map is 10x10 and have 5 ships.
     */
    public static Board getBoard() {
        readMapDefaultSize();
        return board;
    }
}
