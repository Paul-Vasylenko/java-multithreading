import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {
    public static BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

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
                for (int i = 0; i < 5; i++) {
                    Ball b = new Ball(canvas, Color.BLUE);
                    canvas.add(b);
                    BallThread thread = new BallThread(b, Thread.MIN_PRIORITY);
                    thread.start();
                    System.out.println("Thread name = " + thread.getName());
                }

                Ball b = new Ball(canvas, Color.RED);
                canvas.add(b);
                BallThread thread = new BallThread(b, Thread.MAX_PRIORITY);
                thread.start();
                System.out.println("Thread name = " + thread.getName());
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
