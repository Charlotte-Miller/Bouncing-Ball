package Drawing.BouncingBall;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class Canvas extends Shape {

    private int size;

    public Canvas(Color color, int size) {
        super(0, 0, color);
        this.size = size;
    }

    @Override
    public void draws() {
        StdDraw.setCanvasSize(size, size);
        StdDraw.setXscale(-size, size);
        StdDraw.setYscale(-size, size);
        clear();
    }

    public void clear() {
        StdDraw.clear(this.getColor());
    }

    public int getSize()
    {
        return size;
    }
}
