import java.awt.*;
import java.awt.image.BufferedImage;

public class ProcessColor {
    public static Point setVSelected(BufferedImage spriteSheet,Point vOffset,Point vSelected)
    {
        int color = spriteSheet.getRGB(3 * World.vTileSize.x + vOffset.x, vOffset.y);
        Color c = readColor(color);
        if (c.equals(new Color(255, 0, 0))) vSelected = new Point(vSelected.x - 1, vSelected.y + 0);
        if (c.equals(new Color(0, 0, 255))) vSelected = new Point(vSelected.x + 0, vSelected.y - 1);
        if (c.equals(new Color(0, 255, 0))) vSelected = new Point(vSelected.x + 0, vSelected.y + 1);
        if (c.equals(new Color(255, 255, 0))) vSelected = new Point(vSelected.x + 1, vSelected.y + 0);
        return vSelected;
    }
    private static Color readColor(int color) {
        int blue = color & 0xff;
        int green = (color & 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;
        return new Color(red, green, blue);

    }
}
