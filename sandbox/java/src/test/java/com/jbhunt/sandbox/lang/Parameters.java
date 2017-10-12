package com.jbhunt.sandbox.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

public class Parameters {
    @Test
    public void varArgsTest() {
        varArgs("foo", "bar", "baz");
        varArgs(new String[]{"foo", "bar"});
    }

    // ONLY the FINAL parameter can use varargs
    private void varArgs(String... list) {
    }

    @Test
    public void parameterImmutabilityTest() {
        int foo = 1;
        int bar = 2;

        swap(foo, bar);

        Assert.assertEquals(1, foo);
        Assert.assertEquals(2, bar);

        Foo foo1 = new Foo(1);
        Foo foo2 = new Foo(2);

        swap(foo1, foo2);

        Assert.assertEquals(1, foo1.getX());
        Assert.assertEquals(2, foo2.getX());

        Foo foo3 = new Foo(1);

        changeReference(foo3);

        Assert.assertEquals(5, foo3.getX());
    }

    private void swap(int i, int j) {
        int k = i;
        i = j;
        j = k;
    }

    private void swap(Foo foo1, Foo foo2) {
        Foo foo3 = foo1;
        foo1 = foo2;
        foo2 = foo3;
    }

    private void changeReference(Foo foo) {
        Foo foo1 = foo;
        foo1.setX(5);
    }

    @Data
    @AllArgsConstructor
    private static class Foo {
        int x;
    }
}
