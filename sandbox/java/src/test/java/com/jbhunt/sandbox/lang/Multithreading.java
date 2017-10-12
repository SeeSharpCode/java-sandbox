package com.jbhunt.sandbox.lang;

import lombok.Data;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.*;

public class Multithreading {
    @Test
    public void runnable() {
        String[] inFiles = {"1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt"};
        String[] outFiles = {"out1.txt", "out2.txt", "out3.txt", "out4.txt", "out5.txt", "out6.txt"};

        ExecutorService service = Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            service.submit(adder);
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " ms");

        try {
            service.shutdown();
            service.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Data
    private static class Adder implements Runnable {
        private final String inFile;
        private final String outFile;

        public void doAdd() throws IOException {
            int total = 0;
            String line;
            try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/test/resources", inFile))) {
                while ((line = reader.readLine()) != null) {
                    total += Integer.parseInt(line);
                }
            }
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Apps", outFile))) {
                writer.write("Total: " + total);
            }
        }

        @Override
        public void run() {
            try {
                doAdd();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void callable() {
        String[] inFiles = {"1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt"};
        String[] outFiles = {"out1.txt", "out2.txt", "out3.txt", "out4.txt", "out5.txt", "out6.txt"};

        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<Integer>[] results = new Future[inFiles.length];

        for (int i = 0; i < inFiles.length; i++) {
            CallableAdder adder = new CallableAdder(inFiles[i], outFiles[i]);
            results[i] = service.submit(adder);
        }

        for (Future<Integer> result : results) {
            try {
                int value = result.get();
                System.out.println(value);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        try {
            service.shutdown();
            service.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Data
    private static class CallableAdder implements Callable<Integer> {
        private final String inFile;
        private final String outFile;

        public int doAdd() throws IOException {
            int total = 0;
            String line;
            try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/test/resources", inFile))) {
                while ((line = reader.readLine()) != null) {
                    total += Integer.parseInt(line);
                }
            }
            return total;
        }

        @Override
        public Integer call() throws Exception {
            return doAdd();
        }
    }

    @Test
    public void readFirstLineFromFile(String path) {
        foo();
    }

    public void foo(String... strings) {

    }
}
