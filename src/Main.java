public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread incrementThread = new CounterThread(counter, true);
        Thread decrementThread = new CounterThread(counter, false);

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter value: " + counter.getCount());
    }
}




