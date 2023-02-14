import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    public static BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    private static int ballsInHoles = 0;
    private BallThread addBall(Color c) {
        Ball b = new Ball(canvas, c);
        canvas.add(b);
        BallThread thread = new BallThread(b);
        thread.start();
        System.out.println("Thread name = " + thread.getName());
        return thread;
    }
    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");
        BounceFrame.canvas = new BallCanvas(WIDTH, HEIGHT);
        System.out.println("In Frame thread name = " + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(BounceFrame.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BallThread redThread = addBall(Color.RED);
                try {
                    redThread.join(3000);
                } catch(InterruptedException err) {
                    err.printStackTrace();
                }
                for(int i=0; i<5; i++) {
                    addBall(Color.BLUE);
                }
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
