package bleier.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintFrame extends JFrame {

    private final DrawingComponent canvas = new DrawingComponent();
    private final JButton pencilButton = new JButton("Pencil");
    private final JButton lineButton = new JButton("Line");
    private boolean isPencil = false;
    private boolean isLine = false;
    private final JButton colorButton = new JButton("Color");

    public PaintFrame() {
        setTitle("Drawing Component");

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3, 1));
        add(canvas, BorderLayout.CENTER);
        southPanel.add(pencilButton);
        southPanel.add(lineButton);
        southPanel.add(colorButton);
        add(southPanel, BorderLayout.SOUTH);

        pencilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!isPencil) {
                    isPencil = true;
                    isLine = false;
                } else {
                    isPencil = false;
                    isLine = true;
                }
            }
        });

        lineButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               if (!isLine) {
                   isLine = true;
                   isPencil = false;
               } else {
                   isLine = false;
                   isPencil = true;
               }
           }
        });

        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Choose a color", canvas.getColor());
                if (color != null) {
                    canvas.setColor(color);
                }
            }
        });

        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent event) {
                if (isPencil) {
                    canvas.drawFromMouse(event.getX(), event.getY());
                }
                if (isLine) {
                    canvas.drawLine(event.getX(), event.getY());
                }
            }

            @Override
            public void mouseMoved(MouseEvent event) {

            }
        });

        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPencil) {
                    canvas.drawFromMouse(e.getX(), e.getY());
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (isPencil) {
                    canvas.reset();
                }
                if (isLine) {
                    canvas.startLine(e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isLine) {
                    canvas.endLine(e.getX(), e.getY());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    public static void main(String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}
