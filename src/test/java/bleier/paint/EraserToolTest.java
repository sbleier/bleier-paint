package bleier.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class EraserToolTest {

    private Graphics2D g = mock();
    private final BufferedImage image = new BufferedImage(
            800,
            600,
            BufferedImage.TYPE_INT_RGB
    );

    @Test
    void pressed() {
        //given
        EraserTool tool = new EraserTool(20);

        //when
        tool.pressed(image, g, 50, 100);

        //then
        assertEquals(50, tool.getX());
        assertEquals(100, tool.getY());
        verify(g).setColor(Color.WHITE);
        verify(g).fillOval(40, 90, 20, 20);
    }

    @Test
    void dragged() {
        //given
        EraserTool tool = new EraserTool(20);

        //when
        tool.dragged(g, 200, 150);

        //then
        assertEquals(200, tool.getX());
        assertEquals(150, tool.getY());
        verify(g).setColor(Color.WHITE);
        verify(g).fillOval(190, 140, 20, 20);
    }

    @Test
    void preview() {
        //given
        EraserTool tool = new EraserTool(20);
        tool.pressed(image, g, 50, 100);

        //when
        tool.preview(g);

        //then
        verify(g).setColor(Color.BLACK);
        verify(g).drawOval(40, 90, 20, 20);
    }

    @Test
    void released() {
        //given
        EraserTool tool = new EraserTool(20);

        //when
        tool.released(g, 50, 100);

        //then
        verify(g).setColor(Color.WHITE);
        verify(g).fillOval(40, 90, 20, 20);
    }
}