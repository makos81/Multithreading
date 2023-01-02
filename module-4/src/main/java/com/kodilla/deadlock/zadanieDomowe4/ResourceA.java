package com.kodilla.deadlock.zadanieDomowe4;

public class ResourceA extends Resource{
    @Override
    protected void printName(){
        System.out.println("Resource A");
    }
}
