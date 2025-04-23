package bleier.paint;

import java.awt.*;

public class EraserTool implements Tool {

    private int x;
    private int y;
    private int size;

    //constructor to set oval size;
    public EraserTool(int size) {
        this.size = size;
    }

    @Override
    public void pressed(Graphics g, int x, int y) {
        this.x = x;
        this.y = y;
        g.setColor(Color.WHITE);
        g.fillOval(x - size / 2, y - size / 2, size, size);

    }

    @Override
    public void dragged(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        g.fillOval(x - size / 2, y - size / 2, size, size);
        this.x = x;
        this.y = y;

    }

    //when mouse dragged, oval is outlined in black so user knows where mouse is
    @Override
    public void preview(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(x - size / 2, y - size / 2, size, size);

    }

    @Override
    public void released(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        g.fillOval(x - size / 2, y - size / 2, size, size);

        //this changes last x and y so previewed outline disappears - I couldn't figure out a smarter way
        this.x = -100;
        this.y = -100;

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
