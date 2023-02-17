
public class Main {
    public static void main(String[] args) {
        // init counter
        Counter counter = new Counter();
        // create threads
        int numberOfThreads = 2;
        CounterThread[] workers = new CounterThread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            if (i % 2 == 0) {
                workers[i] = new CounterThread(counter, '+');
            } else {
                workers[i] = new CounterThread(counter, '-');
            }
        }

        // run all threads
        for (int i = 0; i < numberOfThreads; i++) {
            workers[i].start();
        }

        // wait all thread to finish
        for (int i = 0; i < numberOfThreads; i++) {
            try {
                workers[i].join();
            }
            catch (InterruptedException e) {
            }
        }

        System.out.println(counter.value);
    }
}