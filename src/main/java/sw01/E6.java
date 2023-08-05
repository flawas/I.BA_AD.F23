package sw01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class E6 {

    private static final Logger Log = LogManager.getLogger();
    private static int counterColorPixel;
    private static int counterColorArea;


    public static Color[][] getArea() {
        return area;
    }



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

    public static void main(String[] args) {
        colorArea(4, 3, Color.GRAY, Color.BLACK);
        Log.info("Aufrufe: " + counterColorArea + " color Area, "  + counterColorPixel + " colorPixel.");
    }
}
