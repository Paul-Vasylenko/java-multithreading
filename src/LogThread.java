public class LogThread extends Thread {
    private char symbol;

    public LogThread(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<50; i++){
                System.out.println(symbol);
            }
        } catch (Exception ex) {
            System.out.println("Error: "+ex);
        }
    }
}
