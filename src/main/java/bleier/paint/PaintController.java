package bleier.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PaintController {
    private Tool tool;
    private final DrawingComponent canvas;

    public PaintController(DrawingComponent canvas) {
        tool = new PencilTool();
        this.canvas = canvas;
        canvas.setTool(tool);
        addMouseListeners();
    }

    private void addMouseListeners() {
        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                tool.dragged(g, e.getX(), e.getY());
                canvas.repaint();

            }

            @Override
            public void mouseMoved(MouseEvent event) {

            }
        });

        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                tool.pressed(g, e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Graphics g = canvas.getImage().getGraphics();
                g.setColor(Color.BLACK);
                tool.released(g, e.getX(), e.getY());
                canvas.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void setTool(Tool tool) {
        this.tool = tool;
        canvas.setTool(tool);
    }
}
