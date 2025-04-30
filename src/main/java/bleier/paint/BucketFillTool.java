package bleier.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BucketFillTool implements Tool {

    private int x;
    private int y;
    private int target;
    private int replace;
    private int fillCount;

    @Override
    public void pressed(BufferedImage image, Graphics2D g, int x, int y) {
        this.x = x;
        this.y = y;
        target = image.getRGB(x, y);
        replace = g.getColor().getRGB();
        if (target != replace) {
            fillBucket(image, x, y, target, replace);
        }

    }

    @Override
    public void dragged(Graphics2D g, int x, int y) {

    }

    @Override
    public void preview(Graphics2D g) {

    }

    @Override
    public void released(Graphics2D g, int x, int y) {

    }

    public void fillBucket(BufferedImage image, int x, int y, int target, int replace) {
        if (x < 0 || x >= image.getWidth() || y < 0
                || y >= image.getHeight() || image.getRGB(x, y) != target || fillCount > 1000) {
            fillCount = 0;
            return;
        }
        fillCount++;
        image.setRGB(x, y, replace);

        fillBucket(image, x + 1, y, target, replace);
        fillBucket(image, x - 1, y, target, replace);
        fillBucket(image, x, y - 1, target, replace);
        fillBucket(image, x, y + 1, target, replace);
    }
}
