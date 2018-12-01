import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {

    public static void mainDraw(Graphics graphics) {
        int x0 = 300;
        int y0 = 50;
        int size = 200;

        drawBaseTriangle(x0, y0, size, graphics);
        drawTriangles(x0, y0, size, 5, graphics);
    }

    public static void drawTriangles(int x0, int y0, int size, int n, Graphics g) {
        drawTriangle(x0, y0, size, g);

        if (n > 0) {
            drawTriangles(x0 + size/2, y0, size/2, n-1, g);
            drawTriangles(x0 - size/2, y0, size/2, n-1, g);
            drawTriangles(x0, y0 + (int)(Math.sqrt(3)/2*size), size/2, n-1, g);
        }
    }

    public static void drawTriangle(int x0, int y0, int size, Graphics g) {
        int[] xCoordinates = {x0, x0 + size/2, x0 - size/2};
        int[] yCoordinates = {y0, y0 + (int)(Math.sqrt(3)/2*size), y0 + (int)(Math.sqrt(3)/2*size)};
        g.drawPolygon(xCoordinates, yCoordinates, 3);
    }

    public static void drawBaseTriangle(int x0, int y0, int size, Graphics g){
        int[] xCoordinates = {x0 - size, x0 + size, x0};
        int[] yCoordinates = {y0, y0, y0 + (int)(Math.sqrt(3)*size)};
        g.drawPolygon(xCoordinates, yCoordinates, 3);
    }

    // Don't touch the code below
    static int WIDTH = 600;
    static int HEIGHT = 600;

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
