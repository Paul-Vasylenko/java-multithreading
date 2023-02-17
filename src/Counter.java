public class Counter {
    int value;
    synchronized void increment() {
        value = value+1;
    }
    synchronized void decrement() {
        value = value-1;
    }
    int getCount() {
        return value;
    }
}
