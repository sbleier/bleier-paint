package bleier.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EraserTool implements Tool {

    private int x;
    private int y;
    private int size;
    private BasicStroke stroke;

    //constructor to set oval size;
    public EraserTool(int size) {
        stroke = new BasicStroke(size);
    }

    @Override
    public void pressed(BufferedImage image, Graphics2D g, int x, int y) {
        this.x = x;
        this.y = y;
        g.setColor(Color.WHITE);
        g.setStroke(stroke);
        g.drawLine(x, y, x, y);

    }

    @Override
    public void dragged(Graphics2D g, int x, int y) {
        /*g.setColor(Color.WHITE);
        g.fillOval(x - size / 2, y - size / 2, size, size);
        this.x = x;
        this.y = y; */
        g.setColor(Color.WHITE);
        g.setStroke(stroke);
        g.drawLine(this.x, this.y, x, y);
        this.x = x;
        this.y = y;

    }

    //when mouse dragged, oval is outlined in black so user knows where mouse is
    @Override
    public void preview(Graphics2D g) {
        /*g.setColor(Color.BLACK);
        g.drawOval(x - size / 2, y - size / 2, size, size); */

    }

    @Override
    public void released(Graphics2D g, int x, int y) {
        /*g.setColor(Color.WHITE);
        g.fillOval(x - size / 2, y - size / 2, size, size);

        //this changes last x and y so previewed outline disappears - I couldn't figure out a smarter way
        this.x = -100;
        this.y = -100; */

    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getSize() {
        return size;
    }


}
