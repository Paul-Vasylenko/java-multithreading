import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

public class Ball {
    private Component canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private Color color;

    public Ball(Component c, Color color) {
        this.canvas = c;
        this.color = color;
        x=BallCanvas.WIDTH/2;
        y=BallCanvas.HEIGHT;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(this.color);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }

    public void move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight() - YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }

    public boolean isInHole() {
        ArrayList<Hole> holes = BallCanvas.holes;
        int ballCenterX = x + XSIZE/2;
        int ballCenterY = y + YSIZE/2;

        for (Hole hole : holes) {
            if (hole.contains(ballCenterX, ballCenterY)) {
                return true;
            }
        }

        return false;
    }

    public void removeFromCanvas() {
        BallCanvas.balls.remove(this);
    }
}
