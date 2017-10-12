package com.jbhunt.sandbox.patterns.bestpractice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class OverridingObjectMethods {

    @RequiredArgsConstructor
    @Getter
    private static class Foo {
        private final String value;

        // you should only override equals when you care about logical equality
        // if a superclass has already overriden equals, that may be sufficient
        // general contract for equals:
        // 1. x.equals(x) must return true
        // 2. x.equals(y) == y.equals(x)
        // 3. x.equals(y) == y.equals(z) == x.equals(z)
        // 4. multiple invocations of x.equals(y) should consistently return true
        // 5. x.equals(null) must return false
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Foo)) {
                return false;
            }

            Foo other = (Foo)obj;
            return this.getValue().equals(other.getValue());
        }
    }
}
