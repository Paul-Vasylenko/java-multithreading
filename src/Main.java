public class Main {
    public static void main(String[] args) {
        try {
            for(int i=0; i<100; i++){
                SharedTurn turn = new SharedTurn();
                PrintThread thread1 = new PrintThread("-", turn);
                PrintThread thread2 = new PrintThread("|", turn);
                thread1.start();
                thread2.start();

                thread1.join();
                thread2.join();

                System.out.println();
            }
        } catch(InterruptedException err) {

        }
    }
}
