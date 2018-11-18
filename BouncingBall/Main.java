package Drawing.BouncingBall;

public class Main {

    public static void main(String[] args)
    {
        BallGame game = new BallGame();
        game.addBalls(10);
        game.play(10);
    }
}
