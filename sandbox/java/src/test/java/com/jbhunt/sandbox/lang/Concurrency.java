package com.jbhunt.sandbox.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Concurrency {
    @Test
    public void concurrencyIssues() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Worker.BankAccount account = new Worker.BankAccount(100);
        // while this code seems to work, it could break if multiple worker threads tried changing the amount simultaneously
        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker(account);
            executorService.submit(worker);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Data
    private static class Worker implements Runnable {
        private final BankAccount account;

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                int startBalance = account.getBalance();
                account.deposit(10);
                int endBalance = account.getBalance();
                System.out.println(startBalance + " | " + endBalance);
            }
        }

        @Data
        @AllArgsConstructor
        private static class BankAccount {
            private int balance;

            void deposit(int amount) {
                balance += amount;
            }
        }
    }

    @Test
    public void synchronizedMethods() {
        // protect modification by multiple threads
        // reading value that might be modified by another thread
        // has significant overhead, use only in multithreading scenarios
        // constructors are never synchronized

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        SynchronizedWorker.SynchronizedBankAccount account = new SynchronizedWorker.SynchronizedBankAccount(100);
        // while this code seems to work, it could break if multiple worker threads tried changing the amount simultaneously
        for (int i = 0; i < 5; i++) {
            SynchronizedWorker worker = new SynchronizedWorker(account);
            executorService.submit(worker);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Data
    private static class SynchronizedWorker implements Runnable {
        private final SynchronizedBankAccount account;

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                int startBalance = account.getBalance();
                account.deposit(10);
                int endBalance = account.getBalance();
                System.out.println(startBalance + " | " + endBalance);
            }
        }

        @Data
        @AllArgsConstructor
        private static class SynchronizedBankAccount {
            private int balance;

            synchronized void deposit(int amount) {
                balance += amount;
            }

            public synchronized int getBalance() {
                return balance;
            }
        }
    }

    @Test
    public void synchronizedBlocks() {
        // synchronization blocks allow you to use thread-safe code in non-thread safe classes
        // protects complex blocks of code

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        WorkerWithSynchronizedBlocks.BankAccount account = new WorkerWithSynchronizedBlocks.BankAccount(100);
        // while this code seems to work, it could break if multiple worker threads tried changing the amount simultaneously
        for (int i = 0; i < 5; i++) {
            WorkerWithSynchronizedBlocks worker = new WorkerWithSynchronizedBlocks(account);
            executorService.submit(worker);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Data
    private static class WorkerWithSynchronizedBlocks implements Runnable {
        private final BankAccount account;

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (account) {
                    int startBalance = account.getBalance();
                    account.deposit(10);
                    int endBalance = account.getBalance();
                    System.out.println(startBalance + " | " + endBalance);
                }
            }
        }

        @Data
        @AllArgsConstructor
        private static class BankAccount {
            private int balance;

            void deposit(int amount) {
                balance += amount;
            }
        }
    }
}
