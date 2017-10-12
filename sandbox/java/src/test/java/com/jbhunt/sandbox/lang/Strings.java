package com.jbhunt.sandbox.lang;

import org.junit.Assert;
import org.junit.Test;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {
    @Test
    public void stringImmutability() {
        String foo = "Hello";
        // Since strings are immutable, this creates a new object reference and points foo to it.
        // This can be inefficient and use more memory since it places more object references on the heap.
        foo += " World";

        // don't be an idiot
        String crap = new String("Why are you doing this?");
    }

    @Test
    public void usefulStringMethods() {
        String foo = "Hello, World!";

        // changing string
        Assert.assertEquals("1", String.valueOf(new Integer(1)));
        Assert.assertEquals("Hello World!", "Hello".concat(" World!"));
        Assert.assertEquals("Hello Tyler!", "Hello World!".replace("World", "Tyler"));
        Assert.assertArrayEquals(new String[] { "Hello", " World"}, "Hello, World".split(","));

        // formatting
        Assert.assertEquals("Hello World!", String.format("Hello %s", "World!"));

        // substring
        Assert.assertEquals('e', "Hello".charAt(1));
        Assert.assertEquals("Hello", "Hello, World!".substring(0, 5));
        Assert.assertTrue("Hello".contains("e"));
        Assert.assertTrue("Hello".startsWith("H"));
        Assert.assertTrue("Hello".endsWith("o"));
        Assert.assertEquals(0, "Hello".indexOf("H"));
        Assert.assertEquals(3, "Hello".lastIndexOf("l"));

        // comparison
        Assert.assertTrue("".isEmpty());
    }

    @Test
    public void stringBuilder() {
        // StringBuilder is a more efficient, mutable way to manipulate strings and avoid creating new string object references

        // specify the size for best performance
        // will grow automatically if needed
        StringBuilder foo = new StringBuilder(40);
        foo.append("Hello ").append("World!").insert(5, ",");

        Assert.assertEquals("Hello, World!", foo.toString());
    }

    @Test
    public void stringJoiner() {
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("foo").add("bar");

        Assert.assertEquals("foo, bar", joiner.toString());
    }

    @Test
    public void regex() {
        String foo = "apple, apple and orange please";
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(foo);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
