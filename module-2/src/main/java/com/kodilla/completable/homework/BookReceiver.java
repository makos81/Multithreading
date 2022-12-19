package com.kodilla.completable.homework;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import static com.kodilla.util.SleepUtil.sleep;

public class BookReceiver {
    public CompletableFuture<Book> receive() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Waiting for book...");
            sleep(5);
            return new Book("Krol", "Twaroch", LocalDate.of(2007,1,1));
        });
    }
}
