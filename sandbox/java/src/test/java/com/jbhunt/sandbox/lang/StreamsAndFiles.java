package com.jbhunt.sandbox.lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StreamsAndFiles {
    @Test
    public void readers() {
        char[] buff = new char[8];
        int length;
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/foo.txt"))) {
            while ((length = reader.read(buff)) >= 0) {
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++) {
                    System.out.print(buff[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bufferedStreams() {
        try {
            // buffered streams are more efficient because they store the data in memory, so there is less interaction
            // with the underlying stream
            // buffered streams also handle line breaks for you (BufferedWriter.newline())
            try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/foo.txt"))) {
                String inValue;
                while ((inValue = reader.readLine()) != null) {
                    System.out.println(inValue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void files() {
        // java.io File* streams are deprecated

        try {
            List<String> lines = Files.readAllLines(Paths.get("src/test/resources/foo.txt"));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
