import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Hole {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 30;

    private final int x;
    private final int y;

    static final Color color = Color.BLUE;

    public Hole(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Hole.color);
        g2.fill(new Ellipse2D.Double(this.x, this.y, this.WIDTH, this.HEIGHT));
    }

    public static ArrayList<Hole> generateHoles() {
        ArrayList<Hole> result = new ArrayList<>();

        result.add(new Hole(100, 0));

        return result;
    }

    public boolean contains(int x, int y) {
        return x >= this.x && x < this.x + this.WIDTH && y >= this.y && y < this.y + this.HEIGHT;
    }
}
