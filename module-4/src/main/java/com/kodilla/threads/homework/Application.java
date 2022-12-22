package com.kodilla.threads.homework;

public class Application{
    public static void main(String[] args) {
        int num = 1;
        while (num < 51){
            int finalNum = num;
            new Thread(()->{
                System.out.println("Hello from Thread number " + finalNum);
            }).start();
            num++;
        }
    }
}
