package com.kodilla.completable.homework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.kodilla.util.SleepUtil.sleep;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final BookReceiver bookReceiver = new BookReceiver();
        final CompletableFuture<Void> futureBook = bookReceiver.receive()
                .thenApply(book-> {book.setSignature("Twardoch"); return book;})
                .thenAccept(book -> System.out.println("Received book " + book));

        sleep(1);
        System.out.println("Doing something else");

        futureBook.get();
    }
}
