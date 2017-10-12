package com.jbhunt.sandbox.patterns.bestpractice;

import org.junit.Test;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ObsoleteObjectReferences {
    @Test
    public void stack() {
        Stack stack = new Stack();
        stack.push("foo");
        stack.push("bar");
        stack.push("baz");
        stack.push("quirk");
    }

    private static class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 3;

        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }

            Object result = elements[--size];
            elements[size] = null; // eliminate obsolete reference
            return result;
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
    }
}