package bleier.paint;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LineToolTest {

    private Graphics2D g = mock();

    @Test
    void pressed() {
        //given
        LineTool tool = new LineTool();

        //when
        tool.pressed(g, 50, 100);

        //then
        assertEquals(50, tool.getX());
        assertEquals(100, tool.getY());
        verify(g).drawLine(50, 100, 50, 100);

    }

    @Test
    void dragged() {
        //given
        LineTool tool = new LineTool();
        tool.pressed(g, 50, 100);

        //when
        tool.dragged(g, 200, 150);

        //then
        assertEquals(50, tool.getX());
        assertEquals(100, tool.getY());
        assertEquals(200, tool.getX2());
        assertEquals(150, tool.getY2());
    }

    @Test
    void released() {
        //given
        LineTool tool = new LineTool();
        tool.pressed(g, 50, 100);

        //when
        tool.released(g, 200, 150);

        //then
        verify(g).drawLine(50, 100, 200, 150);
    }

    @Test
    void preview() {
        //given
        LineTool tool = new LineTool();
        tool.pressed(g, 50, 100);
        tool.dragged(g, 200, 150);

        //when
        tool.preview(g);

        //then
        verify(g).drawLine(50, 100, 200, 150);
    }


}