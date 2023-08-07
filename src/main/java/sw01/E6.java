package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

/**
 * The E6 class provides methods to color an area in a 2D array of colors using recursion.
 * It contains a 2D array representing the area with different colors and methods to color specific areas within it.
 */
public class E6 {

    /**
     * Logger for logging information and results.
     */
    private static final Logger Log = LogManager.getLogger();

    /**
     * Counter to keep track of the number of colorArea method calls.
     */
    private static int counterColorPixel;

    /**
     * Counter to keep track of the number of pixels colored by the colorArea method.
     */
    private static int counterColorArea;

    /**
     * Retrieves the area with colors.
     *
     * @return The 2D array representing the area with colors.
     */
    public static Color[][] getArea() {
        return area;
    }


    /**
     * 2D array representing the area with different colors.
     */
    private static Color[][] area = new Color[][] {
            { Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black },
            { Color.black, Color.white, Color.white, Color.white, Color.white, Color.white, Color.white, Color.white, Color.white, Color.black },
            { Color.black, Color.white, Color.white, Color.white, Color.black, Color.black, Color.black, Color.black, Color.white, Color.black },
            { Color.black, Color.white, Color.white, Color.white, Color.black, Color.black, Color.black, Color.black, Color.white, Color.black },
            { Color.black, Color.black, Color.white, Color.white, Color.white, Color.white, Color.white, Color.black, Color.white, Color.black },
            { Color.black, Color.black, Color.white, Color.white, Color.white, Color.black, Color.white, Color.black, Color.white, Color.black },
            { Color.black, Color.black, Color.black, Color.white, Color.white, Color.black, Color.white, Color.black, Color.white, Color.black },
            { Color.black, Color.black, Color.black, Color.white, Color.white, Color.black, Color.white, Color.white, Color.white, Color.black },
            { Color.black, Color.black, Color.white, Color.white, Color.white, Color.black, Color.black, Color.black, Color.black, Color.black },
            { Color.black, Color.black, Color.white, Color.white, Color.white, Color.black, Color.black, Color.black, Color.black, Color.black },
            { Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black, Color.black }
    };

    /**
     * Recursively colors an area in the 2D array starting from the given coordinates (x, y) with the specified fillColor.
     * The color outside the area is represented by outsideColor.
     *
     * @param x           The x-coordinate of the starting point.
     * @param y           The y-coordinate of the starting point.
     * @param fillColor   The color to be used for coloring the area.
     * @param outsideColor The color representing the outside of the area.
     */
    public static void colorArea(final int x, final int y, final Color fillColor, final Color outsideColor) {
        Color actualColor = area[x - 1][y - 1];
        counterColorArea++;
        if ((actualColor != outsideColor) && (actualColor != fillColor)) {
            area[x - 1][y - 1] = fillColor;
            counterColorPixel++;
            Log.info(String.format("x: %d, y: %d", x, y));
            colorArea(x + 1, y, fillColor, outsideColor);
            colorArea(x, y + 1, fillColor, outsideColor);
            colorArea(x - 1, y, fillColor, outsideColor);
            colorArea(x, y - 1, fillColor, outsideColor);
        }
    }

    /**
     * Main method for testing the colorArea method and logging the number of function calls and colored pixels.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        colorArea(4, 3, Color.GRAY, Color.BLACK);
        Log.info("Aufrufe: " + counterColorArea + " color Area, "  + counterColorPixel + " colorPixel.");
    }
}
