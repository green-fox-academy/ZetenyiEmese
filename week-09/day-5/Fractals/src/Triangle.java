import java.awt.*;

public class Triangle {
    private int x0;
    private int y0;
    private int size;

    public Triangle(int x0, int y0, int size) {
        this.x0 = x0;
        this.y0 = y0;
        this.size = size;
    }

    public void draw(Graphics g) {
        int[] xCoordinates = {x0, x0 + size/2, x0 - size/2};
        int[] yCoordinates = {y0, y0 + (int)(Math.sqrt(3)/2*size), y0 + (int)(Math.sqrt(3)/2*size)};
        g.drawPolygon(xCoordinates, yCoordinates, 3);
    }

    public void drawBase(Graphics g) {
        int[] xCoordinates = {x0 - size, x0 + size, x0};
        int[] yCoordinates = {y0, y0, y0 + (int)(Math.sqrt(3)*size)};
        g.drawPolygon(xCoordinates, yCoordinates, 3);
    }
}
