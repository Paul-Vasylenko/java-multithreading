public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball) {
        b = ball;
    }

    @Override
    public void run() {
        try {
            for (int i=1; i<10000; i++) {
                b.move();
                if (b.isInHole()){
                    System.out.println("Thread is interrupted " + Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                    b.removeFromCanvas();
                    BounceFrame.incrementBallsInHoles();
                    BounceFrame.canvas.repaint();
                }
                System.out.println("Thread name = " + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        } catch(InterruptedException ex) {

        }
    }
}
