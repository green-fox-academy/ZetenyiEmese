import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBox {
    public static void mainDraw(Graphics graphics) {
        //draw a box that has different colored lines on each edge
        graphics.setColor(Color.RED);
        graphics.drawLine(20, 20, 220, 20);

        graphics.setColor(Color.GREEN);
        graphics.drawLine(220, 20, 220, 120);

        graphics.setColor(Color.ORANGE);
        graphics.drawLine(220, 120, 20, 120);

        graphics.setColor(Color.BLUE);
        graphics.drawLine(20, 120, 20, 20);
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
