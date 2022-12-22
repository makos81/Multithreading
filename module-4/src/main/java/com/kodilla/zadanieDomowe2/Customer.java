package com.kodilla.zadanieDomowe2;

public class Customer {
    private String name;
    private String surname;

    public Customer(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    @Override
    public String toString() {
        return "imie : " + this.name + " nazwisko: " + this.surname;
    }
}
