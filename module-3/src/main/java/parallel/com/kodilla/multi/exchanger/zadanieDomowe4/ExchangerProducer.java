package parallel.com.kodilla.multi.exchanger.zadanieDomowe4;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ExchangerProducer implements Runnable {

    private Exchanger<Book> exchanger;
    private Random random;

    ExchangerProducer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        random = new Random();
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int n = 0; n < 10; n++) {
            try {
                int titleNumber = this.random.nextInt(10);
                int authorNumber = this.random.nextInt(20);
                exchanger.exchange(new Book("Title " + titleNumber, "Author " + authorNumber));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
