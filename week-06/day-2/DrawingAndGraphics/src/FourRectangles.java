import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {
    public static void mainDraw(Graphics graphics){
        // draw four different size and color rectangles.
        // avoid code duplication.

        for (int i = 0; i < 4; i++) {
            drawRectangle(graphics);
        }
    }

    public static Color newColor(){
        return new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
    }

    public static void drawRectangle(Graphics g){
        g.setColor(newColor());
        int a = (int)(Math.random() * WIDTH); //the one size of the rectangle
        int b = (int)(Math.random() * HEIGHT); //the other size of the rectangle

        int x = (int)(Math.random() * (WIDTH - a)); //the x coordinate of the rectangle's upper-left corner
        int y = (int)(Math.random() * (HEIGHT - b)); //the y coordinate of the rectangle's upper-left corner
        g.drawRect(x, y, a, b);
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


