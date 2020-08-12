import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Draw extends JPanel implements ActionListener {

    Timer t = new Timer(1, this);
    Point vMouse;
    Point vCell;
    Point vOffset;
    Point vSelected;
    BufferedImage spriteSheet;
    int tilesQnt = 8;
    int scale = 2;
    int tileSet = 0;
    int[] set = {0};

    boolean mouse1;

    {
        try {
            spriteSheet = ImageIO.read(new File("src/imgs/isometric_demo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Draw() {
        for (int i = 0; i < World.world.length; i++) {
            World.world[i] = 1;
            World.world2[i] = World.world[i] + 1;
        }
        t.start();
        setFocusable(true);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    mouse1 = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                    mouse1 = false;
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
                if (mouseWheelEvent.getWheelRotation() == -1) {
                    tileSet = set[0]++ % tilesQnt;
                }
                if (mouseWheelEvent.getWheelRotation() == 1) {
                    tileSet = set[0]-- % tilesQnt;
                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        //Setup Stuff
        vMouse = getMousePosition();
        vMouse = new Point(vMouse.x / scale, vMouse.y / scale);
        vCell = new Point(vMouse.x / World.vTileSize.x, vMouse.y / World.vTileSize.y);
        vOffset = new Point(vMouse.x % World.vTileSize.x, vMouse.y % World.vTileSize.y);
        vSelected = new Point((vCell.y - World.vOrigin.y) + (vCell.x - World.vOrigin.x), (vCell.y - World.vOrigin.y) - (vCell.x - World.vOrigin.x));
        vSelected = ProcessColor.setVSelected(spriteSheet,vOffset,vSelected);
        if (mouse1) {
            if (vSelected.x >= 0 && vSelected.x < World.vWorldSize.x && vSelected.y >= 0 && vSelected.y < World.vWorldSize.y) {
                World.world[vSelected.y * World.vWorldSize.x + vSelected.x] = tileSet % tilesQnt;
            }
        }
        super.paintComponent(graphics);
        this.setBackground(Color.WHITE);
        Graphics2D g = (Graphics2D) graphics;
        g.scale(scale, scale);
        World.drawWorld(g,spriteSheet);
        Point vSelectedWorld = World.ToScreen(vSelected.x, vSelected.y);
        g.drawImage(spriteSheet.getSubimage(0, 0, World.vTileSize.x, World.vTileSize.y), vSelectedWorld.x, vSelectedWorld.y, null);
        //Debug Output
        g.setFont(new Font("Small Fonts", Font.PLAIN, 10));
        g.setColor(Color.black);
        g.drawString("Mouse : " + vMouse.x + ", " + vMouse.y, 4, 14);
        g.drawString("Cell : " + vCell.x + ", " + vCell.y, 4, 24);
        g.drawString("Selected In World Space : " + vSelected.x + ", " + vSelected.y, 4, 34);
        World.drawSelectedTile(g,spriteSheet,tileSet);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }
}
