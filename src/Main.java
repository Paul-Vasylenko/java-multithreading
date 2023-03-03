public class Main {
    public static void main(String[] args) {
        try {
            for(int i=0; i<100; i++){
                PrintThread thread1 = new PrintThread("-");
                PrintThread thread2 = new PrintThread("|");
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
