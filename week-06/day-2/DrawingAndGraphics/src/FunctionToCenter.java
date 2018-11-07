import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {
    public static void mainDraw(Graphics graphics) {
        // Create a line drawing function that takes 2 parameters:
        // The x and y coordinates of the line's starting point
        // and draws a line from that point to the center of the canvas.
        // Fill the canvas with lines from the edges, every 20 px, to the center.

        int x0 = 0;
        int y0 = 0;
        int startX;
        int startY;

        for (int i = 0; i <= 1 ; i++) {
            for (int j = 0; j <= WIDTH/20; j++) {
                startX = x0 + j * 20;
                startY = y0 + i*HEIGHT;
                drawLineToCenter(startX, startY, graphics);
            }
        }

        for (int i = 0; i <= 1 ; i++) {
            for (int j = 0; j <= HEIGHT/20; j++) {
                startX = x0 + i*WIDTH;
                startY = y0 + j*20;
                drawLineToCenter(startX, startY, graphics);
            }
        }

    }

    public  static  void drawLineToCenter(int startX, int startY, Graphics g){
        g.drawLine(startX, startY, WIDTH/2, HEIGHT/2);
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



