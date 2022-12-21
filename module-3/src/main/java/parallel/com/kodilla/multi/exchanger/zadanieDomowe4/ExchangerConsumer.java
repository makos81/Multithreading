package parallel.com.kodilla.multi.exchanger.zadanieDomowe4;

import java.util.concurrent.Exchanger;

public class ExchangerConsumer implements Runnable {

    private Exchanger<Book> exchanger;

    ExchangerConsumer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        Book returnBook = new Book("test", "test");
        for (int n = 0; n < 10; n++) {
            Book msg = null;
            try {
                msg = exchanger.exchange(returnBook);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("received: " + msg);
        }
    }
}
