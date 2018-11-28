import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class KochLine {

    public static void mainDraw(Graphics graphics) {
        drawKochLine(50, 300, 0, 500, 3, graphics);
    }

    public static void drawKochLine(int x0, int y0, int angle, int size, int n, Graphics g) {
        if (n == 0){
            drawLine(x0, y0, angle, size, g);
        }

        if (n > 0) {
            int dx = (int)(size/3 * Math.cos(Math.toRadians(angle)));
            int dy = (int)(size/3 * Math.sin(Math.toRadians(angle)));
            int ddx = (int)(size/3 * Math.cos(Math.toRadians(angle + 60)));
            int ddy = (int)(size/3 * Math.sin(Math.toRadians(angle + 60)));

            drawKochLine(x0, y0, angle, size/3, n-1, g);
            drawKochLine(x0 + dx, y0 - dy, angle + 60, size/3, n-1, g);
            drawKochLine(x0 + dx + ddx, y0 - dy - ddy, angle - 60, size/3, n-1, g);
            drawKochLine(x0 + 2*dx, y0 - 2*dy, angle, size/3, n-1, g);
        }
    }

    public static void drawLine(int x0, int y0, int angle, int size, Graphics g) {
        g.drawLine(x0, y0, x0 + (int)(size * Math.cos(Math.toRadians(angle))), y0 - (int)(size * Math.sin(Math.toRadians(angle))) );
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
