import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters16 {
    public static void mainDraw(Graphics graphics) {
        int xStart = 0;
        int yStart = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                drawLowerLeftLines(xStart, yStart, WIDTH/4, HEIGHT/4, graphics);
                drawUpperRightLines(xStart, yStart, WIDTH/4, HEIGHT/4, graphics);
                xStart += WIDTH/4;
            }
            xStart = 0;
            yStart += HEIGHT/4;
        }
    }

    public static void drawLowerLeftLines(int xStart, int yStart, int xWidth, int yHeight, Graphics g){
        int stepX = xWidth/16;
        int stepY = yHeight/16;
        int x0 = xStart;
        int y0 = yStart;

        g.setColor(Color.GREEN);
        for (int i = 0; i < 17; i++) {
            g.drawLine(x0, y0 + i*stepY, x0 + i*stepX, y0 + yHeight);
        }
    }

    public static void drawUpperRightLines(int xStart, int yStart, int xWidth, int yHeight, Graphics g){
        int stepX = xWidth/16;
        int stepY = yHeight/16;
        int x0 = xStart;
        int y0 = yStart;

        g.setColor(new Color(139, 91, 212));
        for (int i = 0; i < 17; i++) {
            g.drawLine(x0 + i*stepX, y0, x0 + xWidth, y0 + i*stepY);
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

