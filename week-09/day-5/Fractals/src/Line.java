import java.awt.*;

public class Line {
    private int x0;
    private int y0;
    private int angle;
    private int size;
    private Graphics graphics;
    private Color color;

    public Line(int x0, int y0, int angle, int size, Graphics graphics, Color color) {
        this.x0 = x0;
        this.y0 = y0;
        this.angle = angle;
        this.size = size;
        this.graphics = graphics;
        this.color = color;

        draw();
    }

    public void draw(){
        graphics.setColor(color);
        graphics.drawLine(x0, y0, x0 - (int)(size * Math.sin(Math.toRadians(angle))), y0 - (int)(size * Math.cos(Math.toRadians(angle))));
    }
}
