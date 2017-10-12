package com.jbhunt.sandbox.lang;

import org.junit.Assert;
import org.junit.Test;

public class Reflection {
    @Test
    public void classInstance() throws IllegalAccessException, InstantiationException {
        Assert.assertEquals("Foo", Foo.class.getSimpleName());
        Foo foo = Foo.class.newInstance();
    }

    private static class Foo { }
}
