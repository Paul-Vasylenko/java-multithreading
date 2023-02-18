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
            if (increment) {
                synchronized (counter) {
                    counter.increment();
                }
            } else {
                synchronized (counter) {
                    counter.decrement();
                }
            }
        }
    }
}
