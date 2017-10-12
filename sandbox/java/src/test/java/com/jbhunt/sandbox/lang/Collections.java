package com.jbhunt.sandbox.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Collections {
    @Test
    public void collections() {
        List<String> list = new ArrayList<>();
        list.add("Steve");

        Assert.assertEquals(1, list.size());

        list.remove("Steve");

        Assert.assertEquals(0, list.size());
    }

    @Test
    public void collectionsAndArrays() {
        List<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        String[] array = list.toArray(new String[0]);

        Assert.assertEquals(2, array.length);

        List<String> convertedList = Arrays.asList(array);

        Assert.assertEquals(2, convertedList.size());
    }

    @Test
    public void maps() {
        Map<String, String> map = new HashMap<>();
        map.put("foo", "bar");
        map.put("test", "woo");
        map.putIfAbsent("foo", "baz");

        Assert.assertEquals(2, map.size());
        Assert.assertEquals("bar", map.get("foo"));
        Assert.assertEquals("default", map.getOrDefault("baz", "default"));

        // map.values(), map.keys()
        map.forEach((k, v) -> System.out.println(k + " | " + v));

        map.replaceAll((k, v) -> v.toUpperCase());

        map.forEach((k, v) -> System.out.println(k + " | " + v));
    }

    @Test
    public void sortedMaps() {
        SortedMap<String, String> map = new TreeMap<>();
        map.put("2", "b");
        map.put("3", "c");
        map.put("1", "a");
        map.put("4", "d");

        map.forEach((k, v) -> System.out.println(k + " | " + v));

        // headMap returns entries from the map whose keys are less than 3
        // headMap EXCLUDES the key passed in
        SortedMap<String, String> headMap = map.headMap("3");

        Assert.assertArrayEquals(new String[] { "1", "2" }, headMap.keySet().toArray());

        SortedMap<String, String> tailMap = map.tailMap("2");

        // tailMap returns entries from the map whose keys are more than 2
        // tailMap INCLUDES the key passed in
        Assert.assertArrayEquals(new String[] { "2", "3", "4" }, tailMap.keySet().toArray());
    }

    @Test
    public void lambdas() {
        List<String> list = new ArrayList<>();
        list.add("foo1");
        list.add("foo2");
        list.add("bar");

        list.forEach(System.out::println);
        list.removeIf(s -> s.equalsIgnoreCase("foo1"));

        Assert.assertEquals(2, list.size());
    }

    @Test
    public void sorting() {
        TreeSet<Foo> tree1 = new TreeSet<>();
        tree1.add(new Foo("a"));
        tree1.add(new Foo("b"));
        tree1.add(new Foo("c"));

        tree1.forEach(System.out::println);

        TreeSet<Foo> tree2 = new TreeSet<>(new MyComparator());
        tree2.add(new Foo("a"));
        tree2.add(new Foo("b"));
        tree2.add(new Foo("c"));

        tree2.forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    private static class Foo implements Comparable<Foo> {
        private String value;

        @Override
        public int compareTo(Foo other) {
            return value.compareToIgnoreCase(other.getValue());
        }
    }

    @Data
    @AllArgsConstructor
    private static class MyComparator implements Comparator<Foo> {
        @Override
        public int compare(Foo o1, Foo o2) {
            return o1.getValue().compareToIgnoreCase(o2.getValue());
        }
    }
}
