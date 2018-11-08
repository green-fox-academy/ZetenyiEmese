import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
    public static int xStart = 0;
    public static int yStart = 300;
    public static int size = 20;
    public static double sin30 = Math.sin(Math.toRadians(30));
    public static double cos30 = Math.cos(Math.toRadians(30));

    public static void mainDraw(Graphics graphics) {
        drawPyramid(16, graphics); //the first parameter defines the size of the pyramid (how many triangles are at the base)
    }

    public static void drawPyramid(int n, Graphics g){
        for (int i = 0; i < n; i++) {
            drawTrianglesRow(n-i, g);
            xStart += (int)(size * sin30);
            yStart -= (int)(size * cos30);
        }
    }

    //draws a row of n triangles
    public static void drawTrianglesRow(int n, Graphics g) {
        int x0 = xStart;
        int y0 = yStart;

        for (int i = 0; i < n ; i++) {
            int[] xCoordinates = {x0, x0 + (int)(size * sin30), x0 + size};
            int[] yCoordinates = {y0 + (int)(size * cos30), y0, y0 + (int)(size * cos30)};
            g.drawPolygon(xCoordinates, yCoordinates, 3);
            x0 += size;
        }
    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}

