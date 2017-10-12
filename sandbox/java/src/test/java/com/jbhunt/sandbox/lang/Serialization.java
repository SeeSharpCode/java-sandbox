package com.jbhunt.sandbox.lang;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Serialization {
    // requirements for serialization:
    // - implement Serializable
    // - members are serializable (primitives are serializable by default)

    @Data
    private static class Foo implements Serializable {
        private final int id;
        private final String name;
        // transient excludes this field from serialization
        private transient String value;
    }

    @Test
    public void serialize() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/test/resources/serialized.txt")))) {
            outputStream.writeObject(new Foo(1, "Bob"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deserialize() {
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("src/test/resources/serialized.txt")))) {
            Foo foo = (Foo)inputStream.readObject();
            Assert.assertEquals("Bob", foo.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
