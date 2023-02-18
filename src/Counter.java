import java.util.concurrent.Semaphore;

public class Counter {
    int value;
    private final Semaphore semaphore = new Semaphore(1);
    public void increment() throws InterruptedException {
        semaphore.acquire();
        try{
            value++;
        } finally {
            semaphore.release();
        }
    }
    public void decrement() throws InterruptedException {
        semaphore.acquire();
        try{
            value--;
        } finally {
            semaphore.release();
        }
    }
    int getCount() {
        return value;
    }
}
