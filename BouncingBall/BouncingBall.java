package Drawing.BouncingBall;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class BouncingBall extends Ball {

    private double velocity;
    private double angle;
    private double canvasSize;

    public BouncingBall(double canvasSize)
    {
        this(new Random().nextDouble() *2000 -1000, new Random().nextDouble() *2000 -1000, new Random().nextDouble() * 40 + 10,
                15,new Random().nextDouble() * 360, canvasSize);
    }

    public BouncingBall(double x, double y, double radius, double velocity, double angle, double canvasSize)
    {
        super(x, y, radius);
        this.velocity = velocity;
        this.angle = angle;
        this.canvasSize = canvasSize;
    }

    public BouncingBall(double x, double y, Color color, double radius, double canvasSize)
    {
        super(x, y, color, radius);
        this.canvasSize = canvasSize;
    }

    public void boost(double speed)
    {
        if (velocity < 100) velocity += speed;
    }

    public void turnsAround()
    {
        this.angle += 180;
    }

    public void changeDirection()
    {
        angle += new Random().nextDouble() *180;
    }

    public boolean isTooCloseToEdge()
    {
        return getX() + getRadius() > canvasSize || getY() + getRadius() > canvasSize;
    }

    public boolean hitsEdge()
    {
        return hitsSideEdge() || hitsTopOrBottom();
    }

    private boolean hitsSideEdge()
    {
        return Math.abs(this.getX() + dx()) + this.getRadius() > canvasSize;
    }

    private boolean hitsTopOrBottom()
    {
        return Math.abs(this.getY() + dy()) + this.getRadius() > canvasSize;
    }

    public boolean collidesWith(BouncingBall checkedBall)
    {
        return  (distanceTo(checkedBall) <= (this.getRadius() + checkedBall.getRadius() + velocity) && this != checkedBall);
    }

    public double distanceTo(BouncingBall checkedBall)
    {
        Point2D.Double ballOne = new Point2D.Double(this.getX(), this.getY());
        Point2D.Double ballTwo = new Point2D.Double(checkedBall.getX(), checkedBall.getY());

        return ballOne.distance(ballTwo);
    }

    public void moves()
    {
        this.move(dx(), dy());
    }

    private double dx()
    {
        return velocity * Math.cos(Math.toRadians(angle));
    }

    private double dy()
    {
        return velocity * Math.sin(Math.toRadians(angle));
    }
}
