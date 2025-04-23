package bleier.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintFrame extends JFrame {

    private final DrawingComponent canvas = new DrawingComponent();
    private final JButton pencilButton = new JButton("Pencil");
    private final JButton lineButton = new JButton("Line");
    private final JButton eraserButton = new JButton("Eraser");
    private final JButton colorButton = new JButton("Color");
    private final PaintController controller;

    //private Tool tool;

    public PaintFrame() {
        setTitle("Drawing Component");

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 1));
        add(canvas, BorderLayout.CENTER);
        southPanel.add(pencilButton);
        southPanel.add(lineButton);
        southPanel.add(eraserButton);
        southPanel.add(colorButton);
        add(southPanel, BorderLayout.SOUTH);

        controller = new PaintController(canvas);



        pencilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.setTool(new PencilTool());

            }
        });

        lineButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               controller.setTool(new LineTool());
               canvas.setTool(new LineTool());

           }
        });

        eraserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JSpinner sizeSpinner = new JSpinner(new SpinnerNumberModel(20, 5, 100, 1));
                int result = JOptionPane.showConfirmDialog(
                        null, sizeSpinner, "Select Eraser Size", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    int size = (Integer) sizeSpinner.getValue();
                    controller.setTool(new EraserTool(size));
                    canvas.setTool(new EraserTool(size));
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

        /*
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
        */

    }

    public static void main(String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}
