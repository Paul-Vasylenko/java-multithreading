class PrintThread extends Thread {
    private String symbol;
    private SharedTurn turn;

    public PrintThread(String symbol, SharedTurn turn) {
        this.symbol = symbol;
        this.turn = turn;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                turn.waitForTurn(symbol);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(symbol);
            turn.nextTurn();
        }
    }
}