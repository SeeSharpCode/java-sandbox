package com.jbhunt.sandbox.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {
    @Test
    public void iterator() {
        List<Foo> list = new ArrayList<>();
        list.add(new Foo("foo"));
        list.add(new Foo("bar"));
        list.add(new Foo("baz"));

        // throws exception
//        for (Foo foo : list) {
//            list.remove(foo);
//        }

        Iterator<Foo> iterator = list.iterator();

        // apparently the only valid case for using an iterator, but this should actually be list.removeIf
        while (iterator.hasNext()) {
            Foo current = iterator.next();
            if (current.getValue().startsWith("b")) {
                iterator.remove();
            }
        }

        Assert.assertTrue(list.contains(new Foo("replaced")));
    }

    @Data
    @AllArgsConstructor
    private static class Foo {
        private String value;
    }
}
