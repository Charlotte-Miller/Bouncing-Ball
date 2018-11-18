package Drawing.BouncingBall;

import java.awt.*;
import java.util.Random;

public abstract class Shape {

    private double x;
    private double y;
    private Color color;

    public Shape(double x, double y)
    {
        this(x, y, Color.WHITE);
        setColor(randomColor());
    }

    public Shape(double x, double y, Color color) {
        this.setX(x);
        this.setY(y);
        this.setColor(color);
    }

    public abstract void draws();

    public Color randomColor() {
        float r = new Random().nextFloat();
        float g = new Random().nextFloat();
        float b = new Random().nextFloat();

        return new Color(r, g, b);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
