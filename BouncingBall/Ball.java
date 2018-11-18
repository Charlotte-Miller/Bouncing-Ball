package Drawing.BouncingBall;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.Random;

public class Ball extends Shape {

    private double radius;

    public Ball(double x, double y, double radius)
    {
        super(x, y);
        this.radius = radius;

    }

    public Ball(double x, double y, Color color, double radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public void moveInRandomDirection() {
        double dx = new Random().nextDouble() / 10;
        double dy = new Random().nextDouble() / 10;

        move(dx, dy);
    }

    public void move(double dx, double dy) {
        setX(this.getX() + dx);
        setY(this.getY() + dy);
        draws();
    }

    @Override
    public void draws() {
        StdDraw.setPenColor(this.getColor());
        StdDraw.filledCircle(this.getX(), this.getY(), radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }
}
