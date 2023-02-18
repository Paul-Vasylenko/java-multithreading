public class Counter {
    int value;
    public synchronized void increment() {
        value = value+1;
    }
    public synchronized void decrement() {
        value = value-1;
    }
    int getCount() {
        return value;
    }
}
