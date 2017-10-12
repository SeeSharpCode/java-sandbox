package com.jbhunt.sandbox.lang;

import org.junit.Assert;
import org.junit.Test;

public class PrimitivesAndWrappers {
    @Test
    public void primitiveTypeConversion() {
        // "widening" conversions are automatic, i.e. going from a smaller (int) type to a wider (long) type
        int i = 1;
        long l = i;

        Assert.assertEquals(1, l);
    }

    @Test
    public void primitiveWrappers() {
        // classes provide convenience, but primitives provide efficiency
        // wrapper classes are immutable

        // conversion handled for you
        Integer foo = 3;
        int bar = foo;
        Integer baz = bar;

        // explicit conversion
        int a = 3;
        Integer b = Integer.valueOf(a); // boxing
        int c = b.intValue(); // unboxing

        String s = "1.2";
        double d = Double.parseDouble(s);
        double e = Double.valueOf(s);
    }

    @Test
    public void primitiveShouldPerformBetterThanWrapper() {
        long startTime1 = System.currentTimeMillis();
        sumUsingWrapper();
        long endTime1 = System.currentTimeMillis();
        System.out.println("Inefficient way took " + (endTime1 - startTime1) + " ms");

        long startTime2 = System.currentTimeMillis();
        sumUsingPrimitive();
        long endTime2 = System.currentTimeMillis();
        System.out.println("Efficient way took " + (endTime2 - startTime2) + " ms");

        Assert.assertTrue((endTime2 - startTime2) < (endTime1 - startTime1));
    }

    public void sumUsingWrapper() {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public void sumUsingPrimitive() {
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
