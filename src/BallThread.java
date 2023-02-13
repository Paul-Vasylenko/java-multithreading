public class BallThread extends Thread {
    private Ball b;

    public BallThread(Ball ball, int priority) {
        b = ball;
        this.setPriority(priority);
    }

    @Override
    public void run() {
        try {
            for (int i=1; i<10000; i++) {
                b.move();
                if (b.isInHole()){
                    System.out.println("Thread to be interrupted priority = " + Thread.currentThread().getPriority());
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
