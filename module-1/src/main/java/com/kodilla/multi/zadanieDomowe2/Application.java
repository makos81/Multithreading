package com.kodilla.multi.zadanieDomowe2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args){
        int numberOfElements = 10;
        int [] elements1 = new int[numberOfElements];
        int [] elements2 = new int[numberOfElements];
        Random random = new Random();

        for (int n = 0; n < numberOfElements; n++) {
            elements1[n] = random.nextInt(100);
            elements2[n] = random.nextInt(100);
            System.out.println("Initial array1, of element: " + n + " value: " + elements1[n]);
            System.out.println("Initial array2, of element: " + n + " value: " + elements2[n]);
        }

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        Task task = new Task(elements1, elements2);

        for (int n = 0; n < numberOfElements; n++) {
            executor.submit(task);
        }
        task.printResults();
        executor.shutdown();
    }
}
