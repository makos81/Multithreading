package com.kodilla.multi.zadanieDomowe1;

import java.util.Random;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        int[] anArray = new int[10];
        for (int n = 0; n < anArray.length; n++) {
            anArray[n] = random.nextInt(100);
            System.out.println("Initial array, of element: " + n + " value: " + anArray[n]);
        }

        Multiplication multiplication1 = new Multiplication(3, anArray,0, 4);
        Multiplication multiplication2 = new Multiplication(3, anArray,5, 9);
        Thread thread1 = new Thread(multiplication1);
        Thread thread2 = new Thread(multiplication2);

        thread1.run();
        thread2.run();

        thread1.join();
        thread2.join();

        multiplication2.printElements();

    }
}
