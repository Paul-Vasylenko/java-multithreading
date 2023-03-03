class PrintThread extends Thread {
    private String symbol;

    public PrintThread(String symbol) {
        this.symbol = symbol;
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.print(symbol);
        }
    }
}