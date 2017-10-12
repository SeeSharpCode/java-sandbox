package com.jbhunt.sandbox.patterns.bestpractice;

import lombok.Data;

// immutable objects are inherently thread-safe
public class Immutability {
    // making a class immutable:
    // 1. don't provide any mutators
    // 2. ensure it can't be extended (final)
    // 5. ensure exclusive access to any mutable components
    @Data
    private static final class ImmutableClass {
        private final String value; // 3-4. make all fields final and private
    }
}
