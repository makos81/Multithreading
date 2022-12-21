package parallel.com.kodilla.multi.latch.zadanieDomowe2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ExampleTask implements Runnable {

    private CountDownLatch theLatch;

    public ExampleTask(CountDownLatch theLatch) {
        this.theLatch = theLatch;
        for (int i=0; i<5; i++){
            new Thread(this).start();
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        int latency = random.nextInt(1000);
        try {
            Thread.sleep(latency);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ExampleTask.run with latency of: " + latency);
        doTask();
    }

    private void doTask() {
        System.out.println("Running the task");
        theLatch.countDown();
    }
}
