import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {
    public static void mainDraw(Graphics graphics){
        // draw four different size and color rectangles.
        // avoid code duplication.
        for (int i = 0; i < 3; i++) {
            drawRectangle(graphics);
        }
    }

    public static void drawRectangle(Graphics g){
        g.setColor(new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
        int a = (int)(Math.random()*WIDTH);
        int b = (int)(Math.random()*HEIGHT);
        int x0 = WIDTH/2;
        int y0 = HEIGHT/2;
        g.drawLine(x0 - a/2, y0 - b/2, x0 + a/2, y0 - b/2);
        g.drawLine(x0 + a/2, y0 - b/2, x0 + a/2, y0 + b/2);
        g.drawLine(x0 + a/2, y0 + b/2, x0 - a/2, y0 + b/2);
        g.drawLine(x0 - a/2, y0 + b/2, x0 - a/2, y0 - b/2);
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


