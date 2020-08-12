import java.awt.*;
import java.awt.image.BufferedImage;

public class World {

    public static Point vWorldSize = new Point(10, 10);
    public static Point vTileSize = new Point(40, 20);
    public static Point vOrigin = new Point(10, 2);
    public static int[] world = new int[vWorldSize.x * vTileSize.y];
    public static int[] world2 = new int[vWorldSize.x * vTileSize.y];

    public static void drawWorld(Graphics2D g, BufferedImage spriteSheet)
    {
        for (int y = 0; y < vWorldSize.y; y++) {
            for (int x = 0; x < vWorldSize.x; x++) {
                Point vWorld = ToScreen(x, y);
                switch (world[y * vWorldSize.x + x]) {//Null Tile
                    case 0:
                        g.drawImage(spriteSheet.getSubimage(1 * vTileSize.x, 0 * vTileSize.y, vTileSize.x, vTileSize.y), vWorld.x, vWorld.y, null);
                        break;
                    //Visible Tile
                    case 1:
                        g.drawImage(spriteSheet.getSubimage(2 * vTileSize.x, 0 * vTileSize.y, vTileSize.x, vTileSize.y), vWorld.x, vWorld.y, null);
                        break;
                    //Tree
                    case 2:
                        g.drawImage(spriteSheet.getSubimage(0 * vTileSize.x, 1 * vTileSize.y, vTileSize.x, vTileSize.y * 2), vWorld.x, vWorld.y - vTileSize.y, null);
                        break;
                    //Spooky Tree
                    case 3:
                        g.drawImage(spriteSheet.getSubimage(1 * vTileSize.x, 1 * vTileSize.y, vTileSize.x, vTileSize.y * 2), vWorld.x, vWorld.y - vTileSize.y, null);
                        break;
                    //Sand Tile
                    case 4:
                        g.drawImage(spriteSheet.getSubimage(2 * vTileSize.x, 1 * vTileSize.y, vTileSize.x, vTileSize.y * 2), vWorld.x, vWorld.y - vTileSize.y, null);
                        break;
                    //Water Tile
                    case 5:
                        g.drawImage(spriteSheet.getSubimage(3 * vTileSize.x, 1 * vTileSize.y, vTileSize.x, vTileSize.y * 2), vWorld.x, vWorld.y - vTileSize.y, null);
                        break;
                    case 6:
                        g.drawImage(spriteSheet.getSubimage(0 * vTileSize.x, 3 * vTileSize.y, vTileSize.x, vTileSize.y * 2), vWorld.x, vWorld.y - vTileSize.y, null);
                        break;
                    case 7:
                        g.drawImage(spriteSheet.getSubimage(1 * vTileSize.x, 3 * vTileSize.y, vTileSize.x, vTileSize.y * 2), vWorld.x, vWorld.y - vTileSize.y, null);
                        break;

                }
            }
        }
    }
    public static void drawSelectedTile(Graphics2D g, BufferedImage spriteSheet,int tileSet)
    {
        switch (tileSet) {//Null Tile
            case 0:
                g.drawImage(spriteSheet.getSubimage(1 * vTileSize.x, 0 * vTileSize.y, vTileSize.x, vTileSize.y), 10, 120, null);
                break;
            //Visible Tile
            case 1:
                g.drawImage(spriteSheet.getSubimage(2 * vTileSize.x, 0 * vTileSize.y, vTileSize.x, vTileSize.y), 10, 120, null);
                break;
            //Tree
            case 2:
                g.drawImage(spriteSheet.getSubimage(0 * vTileSize.x, 1 * vTileSize.y, vTileSize.x, vTileSize.y * 2), 10, 120 - vTileSize.y, null);
                break;
            //Spooky Tree
            case 3:
                g.drawImage(spriteSheet.getSubimage(1 * vTileSize.x, 1 * vTileSize.y, vTileSize.x, vTileSize.y * 2), 10, 120 - vTileSize.y, null);
                break;
            //Sand Tile
            case 4:
                g.drawImage(spriteSheet.getSubimage(2 * vTileSize.x, 1 * vTileSize.y, vTileSize.x, vTileSize.y * 2), 10, 120 - vTileSize.y, null);
                break;
            //Water Tile
            case 5:
                g.drawImage(spriteSheet.getSubimage(3 * vTileSize.x, 1 * vTileSize.y, vTileSize.x, vTileSize.y * 2), 10, 120 - vTileSize.y, null);
                break;
            case 6:
                g.drawImage(spriteSheet.getSubimage(0 * vTileSize.x, 3 * vTileSize.y, vTileSize.x, vTileSize.y * 2),10, 120 - vTileSize.y, null);
                break;
            case 7:
                g.drawImage(spriteSheet.getSubimage(1 * vTileSize.x, 3 * vTileSize.y, vTileSize.x, vTileSize.y * 2),10, 120 - vTileSize.y, null);
                break;
        }
    }
    public static Point ToScreen(int x, int y) {
        Point p;
        int sx = (vOrigin.x * vTileSize.x) + (x - y) * (vTileSize.x / 2);
        int sy = (vOrigin.y * vTileSize.y) + (x + y) * (vTileSize.y / 2);
        p = new Point(sx, sy);
        return p;
    }
}
