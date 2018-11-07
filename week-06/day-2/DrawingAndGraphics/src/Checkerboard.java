import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard{
    public static void mainDraw(Graphics graphics){
        int x = 0;
        int y = 0;
        int size = WIDTH / 8;

        for (int i = 0; i < 8; i++) {
           if (i%2 == 0) {
               drawLine1(x, y, size, graphics);
               y += size;
           } else {
               drawLine2(x, y, size, graphics);
               y += size;
           }
        }
    }

    public static void drawBlackSquare(int x, int y, int size, Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(x, y, size, size);
    }

    public static void drawWhiteSquare(int x, int y, int size, Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, size, size);
    }

    public static void drawLine1(int x, int y, int size, Graphics g){
        for (int j = 0; j < 4; j++) {
            drawBlackSquare(x, y, size, g);
            x += size;
            drawWhiteSquare(x, y, size, g);
            x += size;
        }
    }

    public static void drawLine2(int x, int y, int size, Graphics g){
        for (int j = 0; j < 4; j++) {
            drawWhiteSquare(x, y, size, g);
            x += size;
            drawBlackSquare(x, y, size, g);
            x += size;
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

