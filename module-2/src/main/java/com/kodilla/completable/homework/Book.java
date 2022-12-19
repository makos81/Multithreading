package com.kodilla.completable.homework;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Book {
    private String signature;
    private String title;
    private String author;
    private LocalDate dateOfPublishing;

    public Book(String title, String author, LocalDate dateOfPublishing){
        this.title = title;
        this.author = author;
        this.dateOfPublishing = dateOfPublishing;
    }

    public void setSignature(String signature){
        this.signature = signature;
    }


    @Override
    public String toString(){
        return "Book-> title = " + this.getTitle() + " author = " + this.getAuthor() + " publishing date = " +
                this.getDateOfPublishing() + " signature: " + this.getSignature();
    }
}
