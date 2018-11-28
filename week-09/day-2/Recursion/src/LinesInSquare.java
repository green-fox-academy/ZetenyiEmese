import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinesInSquare {

    public static void mainDraw(Graphics graphics) {
        drawLinesInSquare(0, 0, WIDTH, 4, graphics);
    }

    public static void drawLinesInSquare(int x0, int y0, int size, int n, Graphics g){
        drawLines(x0, y0, size, g);

        if (n > 0) {
            drawLinesInSquare(x0 + size/3, y0, size/3, n-1, g);
            drawLinesInSquare(x0 + 2*size/3, y0 + size/3, size/3, n-1, g);
            drawLinesInSquare(x0 + size/3, y0 + 2*size/3, size/3, n-1, g);
            drawLinesInSquare(x0, y0 + size/3, size/3, n-1, g);
        }
    }

    public static void drawLines(int x0, int y0, int size, Graphics g){
        g.drawLine(x0 + size/3, y0, x0 + size/3, y0 + size);
        g.drawLine(x0 + 2*size/3, y0, x0 + 2*size/3, y0 + size);
        g.drawLine(x0, y0 + size/3, x0 + size, y0 + size/3);
        g.drawLine(x0, y0 + 2*size/3, x0 + size, y0 + 2*size/3);
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
