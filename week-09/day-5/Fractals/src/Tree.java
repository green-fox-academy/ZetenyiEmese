import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Tree {

    public static void mainDraw(Graphics graphics) {
        drawTree(300, 400, 0, 45, 8, graphics);
    }

    public static void drawTree(int x0, int y0, int angle, int size, int n, Graphics g) {
        drawLine(x0, y0, angle, size, g);

        if (n > 0) {
            int dx = (int)(size * Math.sin(Math.toRadians(angle)));
            int dy = (int)(size * Math.cos(Math.toRadians(angle)));

            drawTree(x0 - dx, y0 - dy, angle, size, n-1, g);
            drawTree(x0 - dx, y0 - dy, angle + 25, 9*size/10, n-1, g);
            drawTree(x0 - dx, y0 - dy, angle - 25, 9*size/10, n-1, g);
        }
    }

    public static void drawLine(int x0, int y0, int angle, int size, Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawLine(x0, y0, x0 - (int)(size * Math.sin(Math.toRadians(angle))), y0 - (int)(size * Math.cos(Math.toRadians(angle))) );
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
            this.setBackground(new Color(0, 0, 102));
            mainDraw(graphics);
        }
    }
}
