package bleier.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawingComponent extends JComponent {

    private final BufferedImage image = new BufferedImage(
            800,
            600,
            BufferedImage.TYPE_INT_RGB
    );
    private int oldx = -1;
    private int oldy = -1;
    private int startx = -1;
    private int starty = -1;
    private int endx = -1;
    private int endy = -1;
    private boolean isDrawingLine = false;
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

        if (isDrawingLine) {
            g.setColor(color);
            g.drawLine(startx, starty, endx, endy);
        }

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void drawFromMouse(int x, int y) {
        Graphics g = image.getGraphics();
        g.setColor(color);
        if (oldx != -1 && oldy != -1) {
            g.drawLine(oldx, oldy, x, y);
        }
        oldx = x;
        oldy = y;
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
    }

    public void reset() {
        oldx = -1;
        oldy = -1;
    }
}
