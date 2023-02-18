public class CounterThread extends Thread {
    private Counter counter;
    private boolean increment;

    public CounterThread(Counter counter, boolean increment) {
        this.counter = counter;
        this.increment = increment;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                if (increment) {
                    counter.increment();
                } else {
                    counter.decrement();
                }
            } catch(InterruptedException e) {
                System.out.println("Interrupted: " + e);
            }
        }
    }
}
