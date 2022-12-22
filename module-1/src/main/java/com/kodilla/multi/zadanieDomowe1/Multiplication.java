package com.kodilla.multi.zadanieDomowe1;

public class Multiplication implements Runnable{
    private int n;
    private int[] elements;
    private int lowerIndex;
    private int upperIndex;

    public Multiplication(int n, int[] elements, int lowerIndex, int upperIndex){
        this.n = n;
        this.elements = elements;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
    }

    public void printElements(){
        for (int i=0; i < this.elements.length; i++){
            System.out.println("element: " + i + " value " + elements[i]);
        }
    }

    @Override
    public void run() {
        for(int i=lowerIndex; i<=upperIndex; i++){
            elements[i]*=n;
            System.out.println("Thread " + Thread.currentThread().getId() +  " multiplication result: " + elements[i]);
        }
    }
}
