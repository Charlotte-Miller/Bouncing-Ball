package Drawing.BouncingBall;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.Stopwatch;

import java.awt.*;
import java.util.ArrayList;

public class BallGame {

    private ArrayList<BouncingBall> balls;
    private Canvas canvas;
    private int bumpsNo = 0;
    private Stopwatch stopwatch;

    public BallGame()
    {
        this.balls = new ArrayList<BouncingBall>();
        canvas = new Canvas(Color.BLACK, 1000);
        this.stopwatch = new Stopwatch();
        StdDraw.enableDoubleBuffering();
    }

    public void play(int delay)
    {
        canvas.draws();

        while (true)
        {
            canvas.clear();

            showClock();

            for (BouncingBall ball : balls)
            {
                for (BouncingBall checkedBall : balls)
                {
                    if (ball.collidesWith(checkedBall))
                    {
                        ball.turnsAround();
                        checkedBall.turnsAround();

                        ball.boost(10);
                        checkedBall.boost(10);
                    }
                }
                if (ball.hitsEdge()) ball.changeDirection();

                ball.moves();
            }
            StdDraw.show();
            StdDraw.pause(delay);
        }
    }

    public void addBalls(int numberOfBall)
    {
        for (int i = 0; i < numberOfBall; i++)
        {
            addBall();
        }
    }

    private void addBall()
    {
        BouncingBall addedBall = new BouncingBall(canvas.getSize());

        while (isTooCloseToOtherBalls(addedBall) || addedBall.isTooCloseToEdge())
        {
            addedBall = new BouncingBall(canvas.getSize());
        }
        balls.add(addedBall);
    }

    private boolean isTooCloseToOtherBalls(BouncingBall checkedBall)
    {
        for (BouncingBall currentBall : balls)
        {
            if (currentBall.distanceTo(checkedBall) < currentBall.getRadius() + checkedBall.getRadius()) return true;
        }
        return false;
    }

    private void showClock()
    {
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.text(0, 900, stopwatch.elapsedTime() +"");
    }
}
