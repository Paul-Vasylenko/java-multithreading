public class CounterThread extends Thread {
    private Counter counter;
    private char action;
//    private int reps = 100000;
    private int reps = 5;

    public CounterThread(Counter counter, char action) {
        this.counter = counter;
        this.action = action;
    }

    @Override
    public void run() {
        for (int i=0; i<reps; i++){
            if (action == '+') {
                counter.increment();
            } else {
                counter.decrement();
            }
            System.out.println("Value now: " + counter.value);
        }
    }
}
