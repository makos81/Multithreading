package com.kodilla.com.kodilla.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.*;

import static com.kodilla.util.SleepUtil.sleep;

public class LockedWarehouse {
    private final Map<Product, Integer> products = new HashMap<>();
    private final StampedLock lock = new StampedLock();

    public void add(Product product, String by) {
        System.out.println("I'm " + by + " and want to add " + product);
        final long stampWrite = lock.writeLock();
        try {
            sleep(2);
            products.merge(product, 1, Integer::sum);
            System.out.println("Product " + product + " added by " + by + ". Now is  " + countProducts());
        } finally {
            lock.unlockWrite(stampWrite);
        }
    }

    private int countProducts() {
        return products.values().stream().reduce(0, Integer::sum);
    }

    public void showProducts(String inventoryWorkerName) {
        System.out.println("I'm " + inventoryWorkerName + " and want to check INVENTORY");
        final long stamp = lock.readLock();
        try {
            products.forEach((key, value) ->
                    System.out.println("[" + inventoryWorkerName + "]" + "Product: " + key + " quantity: " + value));
        } finally {
            lock.unlockRead(stamp);
        }
    }

    public void removeProducts(Product product, String cleanerWorker) {
        System.out.println("I'm " + cleanerWorker + " and want to remove product " + product + " from INVENTORY");
        final long stampWrite = lock.writeLock();
        try {
            if (products.entrySet().contains(product)){
                products.entrySet().remove(product);
            }
        } finally {
            lock.unlockWrite(stampWrite);
        }
    }
}
