package parallel.com.kodilla.multi.barrier.zadanieDomowe3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class PartialStep implements Runnable {

    private final CyclicBarrier barrier;
    private final int number;

    public PartialStep(CyclicBarrier barrier, int number) {
        this.barrier = barrier;
        this.number = number;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Thread number " + number + " has been launched");
        Random random = new Random();
        int sumaA = 1000;;
        int sumaB = 0;

        while(sumaA > sumaB){
            sumaA+=random.nextInt(9);
            sumaB+=random.nextInt(49);
        }
        System.out.println("Thread number " + number + " has been finished");
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
