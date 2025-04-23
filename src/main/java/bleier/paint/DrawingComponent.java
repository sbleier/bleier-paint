package bleier.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/*
* Draw the BufferedImage to the screen.
 */
public class DrawingComponent extends JComponent {

    private final BufferedImage image = new BufferedImage(
            800,
            600,
            BufferedImage.TYPE_INT_RGB
    );

    private Tool tool;
    private Color color = Color.BLACK;

    public DrawingComponent() {
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, null);

        if (tool != null) {
            tool.preview(g);
        }

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    /*public void drawFromMouse(int x, int y) {
        Graphics g = image.getGraphics();
        g.setColor(color);
        tool.dragged(g, x, y);
        repaint();

    }

    public void startLine(int x, int y) {
        startx = x;
        starty = y;
        isDrawingLine = true;
    }

    public void drawLine(int x, int y) {
        endx = x;
        endy = y;
        repaint();
    }

    public void endLine(int x, int y) {
        Graphics g = image.getGraphics();
        g.setColor(color);
        if (startx != -1 && starty != -1) {
            g.drawLine(startx, starty, x, y);
        }
        startx = -1;
        starty = -1;
        endx = -1;
        endy = -1;
        repaint();
    } */


    public BufferedImage getImage() {
        return image;
    }
}
