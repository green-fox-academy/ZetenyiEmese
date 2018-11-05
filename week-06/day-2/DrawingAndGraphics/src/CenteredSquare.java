import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenteredSquare {
    public static void mainDraw(Graphics graphics){
        //Draw a green 10x10 square to the canvas' center.
        graphics.setColor(Color.GREEN);
        int x0 = WIDTH/2;
        int y0 = HEIGHT/2;
        int[] xpoints = {x0-5, x0+5, x0+5, x0-5, x0-5};
        int[] ypoints = {y0-5, y0-5, y0+5, y0+5, y0-5};
        int npoints = 5;
        graphics.drawPolygon(xpoints, ypoints, npoints);
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
