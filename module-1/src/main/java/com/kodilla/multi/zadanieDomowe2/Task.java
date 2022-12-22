package com.kodilla.multi.zadanieDomowe2;

import java.util.Random;

public class Task implements Runnable {

    private int[] elements1;
    private int[] elements2;
    private long[] results;

    public Task(int[] elements1, int[] elements2){
        this.elements1 = elements1;
        this.elements2 = elements2;
        this.results = new long[this.elements2.length];
    }

    public void printResults(){
        for(int i=0; i<results.length; i++){
            System.out.println("element : " + i + " value: " + this.results[i]);
        }
    }

    private void multiply(){
        for(int i=0; i<results.length; i++){
            this.results[i] = this.elements1[i] * this.elements2[i];
        }
    }

    @Override
    public void run() {
        taskBody();
    }

    private void taskBody() {
        Random random = new Random();
        int delay = random.nextInt(100);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (Task.class) {
            multiply();
            System.out.println(Thread.currentThread().getName() + " finished");
        }
    }
}