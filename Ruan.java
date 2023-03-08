import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class Main {

    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    ArrayList<Coordinates> coo = new ArrayList<>();
    double zoom = 1d;

    public Main() {
        for (int i = 0; i < d.height; i += 4) {
            for (int j = 0; j < d.width; j += 4) {
                // g.drawLine(j, i, j, i);
                int middleWidth = d.width / 2;
                int middleHeight = d.height / 2;
                if (j > middleWidth - 10 && middleWidth + 10 > j ||
                        i > middleHeight - 10 && middleHeight + 10 > i) {
                    coo.add(new Coordinates(j, i, Color.RED));
                } else {
                    coo.add(new Coordinates(j, i, Color.WHITE));
                }
            }
        }
        JPanel jp = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                coo.clear();
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());

                // Test
                double screenWidth = 800d;
                double screenHeight = 800d;
                for (int i = 10; i < (screenHeight * zoom); i += 2) {
                    for (int j = 10; j < (screenWidth * zoom); j += 2) {
                        double middleWidth = (screenWidth * zoom) / 2;
                        double middleHeight = (screenHeight * zoom) / 2;
                        if (j <= 20 || j > (screenWidth * zoom) - 20) {
                            g.setColor(Color.RED);
                            coo.add(new Coordinates(j, i, Color.RED));
                        }
                        if (i <= 20 || i > (screenHeight * zoom) - 20) {
                            g.setColor(Color.RED);
                            coo.add(new Coordinates(j, i, Color.RED));
                        }
                        if (j > middleWidth - 10 && middleWidth + 10 > j ||
                                i > middleHeight - 10 && middleHeight + 10 > i) {
                            g.setColor(Color.RED);
                            coo.add(new Coordinates(j, i, Color.RED));
                        } else {
                            g.setColor(Color.WHITE);
                            coo.add(new Coordinates(j, i, Color.WHITE));
                        }
                        g.drawLine(j, i, j, i);
                    }
                }
                // Working
                /*
                 * for (int i = 10; i < getHeight() - 10; i += 2) {
                 * for (int j = 10; j < getWidth() - 10; j += 2) {
                 * int middleWidth = getWidth() / 2;
                 * int middleHeight = getHeight() / 2;
                 * if (j <= 20 || j > getWidth() - 20) {
                 * g.setColor(Color.RED);
                 * coo.add(new Coordinates(j, i, Color.RED));
                 * }
                 * if (i <= 20 || i > getHeight() - 20) {
                 * g.setColor(Color.RED);
                 * coo.add(new Coordinates(j, i, Color.RED));
                 * }
                 * if (j > middleWidth - 10 && middleWidth + 10 > j ||
                 * i > middleHeight - 10 && middleHeight + 10 > i) {
                 * g.setColor(Color.RED);
                 * coo.add(new Coordinates(j, i, Color.RED));
                 * } else {
                 * g.setColor(Color.WHITE);
                 * coo.add(new Coordinates(j, i, Color.WHITE));
                 * }
                 * g.drawLine(j, i, j, i);
                 * }
                 * }
                 */

            }
        };
        jp.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                for (Coordinates c : coo) {
                    if (c.x == e.getX() && c.y == e.getY()) {
                        c.c = Color.RED;
                        System.out.println("Color changed at X " + e.getX() + "\tY " + e.getY());
                    }
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mouseMoved(e);
                for (Coordinates c : coo) {
                    if (c.x == e.getX() && c.y == e.getY()) {
                        System.out.println("Color " + new Color(c.c.getRGB()).toString());
                    }
                }
            }
        });
        jp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                super.mousePressed(e);
                System.out.println("X " + e.getX() + "\tY " + e.getY());
                for (Coordinates c : coo) {
                    if (c.x == e.getX() && c.y == e.getY()) {
                        c.c = Color.RED;
                        System.out.println("Color changed at X " + e.getX() + "\tY " + e.getY());
                    }
                }
            }
        });
        jp.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                System.out.println(e.getWheelRotation());
                if (e.getWheelRotation() < 0 && zoom < 2d) {
                    zoom += 0.1;
                } else {
                    if (zoom > 0d)
                        zoom -= 0.1;
                }
                jp.repaint();
            }
        });
        JScrollPane jsp = new JScrollPane(jp, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JViewport viewport = jsp.getViewport();
        viewport.setViewSize(d);
        viewport.setExtentSize(new Dimension(d.width / 2, d.height / 2));
        JFrame jf = new JFrame();
        jf.add(jp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(d.width / 2, d.height / 2);
        jf.setVisible(true);
    }

    private class Coordinates {

        int x;
        int y;
        Color c;

        public Coordinates(int x, int y, Color c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

    }

    public static void main(String[] args) {
        new Main();
        /*
         * GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
         * GraphicsDevice[] screenDevices = ge.getScreenDevices();
         * System.out.println(screenDevices.length);
         * for (GraphicsDevice gd : screenDevices) {
         * System.out.println("Width " + gd.getDisplayMode().getWidth());
         * System.out.println("Height " + gd.getDisplayMode().getHeight());
         * }
         */
    }

}
