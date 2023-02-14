import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {
    public static ArrayList<Ball> balls = new ArrayList<>();
    private int width, height;

    public void add(Ball b) {
        this.balls.add(b);
    }

    public BallCanvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i=0; i<balls.size(); i++) {
            Ball b = balls.get(i);
            b.draw(g2);
        }
    }
}
