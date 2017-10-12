package com.jbhunt.sandbox.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Test;

public class Equality {
    @Test
    public void referenceEquality() {
        Foo foo1 = new Foo(1);
        Foo foo2 = new Foo(1);

        // reference equality
        Assert.assertFalse(foo1 == foo2);

        // default implementation of equals uses reference equality
        Assert.assertNotEquals(foo1, foo2);

        Bar bar1 = new Bar(1);
        Bar bar2 = new Bar(1);

        // lombok-generated equals method checks for equality based on field values
        Assert.assertEquals(bar1, bar2);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class Foo {
        private int x;
    }

    @Data
    @AllArgsConstructor
    private static class Bar {
        private int x;
    }

    @Test
    public void primitiveVsWrapperEquality() {
        int foo = 1;
        int bar = 1;

        Assert.assertTrue(foo == bar);

        Integer baz = 10 * 10 * 10;
        Integer quirk = 100 * 10;

        Assert.assertFalse(baz == quirk);

        // boxing conversions for integers always return the same wrapper class instance if the value is in the range -128 to 127
        Integer a = 4 * 2;
        Integer b = 2 * 2 * 2;

        Assert.assertTrue(a == b);

        Integer i1 = 1000;
        int i2 = 1000;

        Assert.assertTrue(i1 == i2);
    }

    @Test
    public void stringEquality() {
        String foo = "foo";
        String bar = "foo";

        Assert.assertTrue(foo == bar);

        String foo1 = "foo ";
        foo1 += "bar";
        String bar1 = "foo";
        bar1 += " bar";

        Assert.assertFalse(foo1 == bar1);
        Assert.assertEquals(foo1, bar1); // use String.equals for most string comparisons

        // reference equality is more performance-friendly, so this can be used for multiple comparisons
        String foo2 = foo1.intern();
        String bar2 = bar1.intern();

        Assert.assertTrue(foo2 == bar2);
    }
}
