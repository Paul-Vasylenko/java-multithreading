
public class Main {
    public static void main(String[] args) {
        LogThread first = new LogThread('-');
        LogThread second = new LogThread('|');

        first.start();
        second.start();
    }
}