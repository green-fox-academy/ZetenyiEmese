import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
    public static void mainDraw(Graphics graphics) {
        drawLowerLeftLines(graphics);
        drawUpperRightLines(graphics);
    }

    public static void drawLowerLeftLines(Graphics g){
        int x0 = 0;
        int y0 = 0;
        g.setColor(Color.GREEN);

        for (int i = 0; i < 15; i++) {
            g.drawLine(x0, y0 + stepY + i*stepY, x0 + stepX + i*stepX, y0 + HEIGHT);
        }
    }

    public static void drawUpperRightLines(Graphics g){
        int x0 = 0;
        int y0 = 0;
        g.setColor(new Color(139, 91, 212));

        for (int i = 0; i < 15; i++) {
            g.drawLine(x0 + stepX + i*stepX, y0, x0 + WIDTH, y0 + stepY + i*stepY);
        }
    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    static int stepX = WIDTH / 16;
    static int stepY = HEIGHT / 16;

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
