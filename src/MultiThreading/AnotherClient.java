package MultiThreading;

public class AnotherClient {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++){
//            NumberPrinter x = new NumberPrinter(i);
            TimeElapsed x = new TimeElapsed();
            Thread t = new Thread(x);
            t.start();
        }
    }
}
