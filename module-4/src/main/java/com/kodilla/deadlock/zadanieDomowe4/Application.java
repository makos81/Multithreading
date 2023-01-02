package com.kodilla.deadlock.zadanieDomowe4;

public class Application {
    public static void main(String[] args) {
        Resource resourceA = new ResourceA();
        Resource resourceB = new ResourceB();
        Process process = new Process();

        for (int n = 0; n < 500; n++) {
            new Thread(() -> process.run("ProcessA", resourceA, resourceB)).start();
            new Thread(() -> process.run("ProcessB", resourceB, resourceA)).start();
        }
    }
}
