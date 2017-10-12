package com.jbhunt.sandbox.lang;

import java.util.Iterator;

public class AnonymousClasses {
    private class Foo {
        public Iterator<Bar> iterator () {
            return new Iterator<Bar>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public Bar next() {
                    return null;
                }
            };
        }

        public class Bar {

        }
    }
}
