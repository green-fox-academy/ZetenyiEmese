
import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard2{
    public static void mainDraw(Graphics graphics){
        int x0 = 50;
        int y0 = 50;
        int size = 20;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0){
                    drawBlackSquare(x0 + j*size, y0 + i*size, size, graphics);
                } else {
                    drawWhiteSquare(x0 + j*size, y0 + i*size, size, graphics);
                }
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

