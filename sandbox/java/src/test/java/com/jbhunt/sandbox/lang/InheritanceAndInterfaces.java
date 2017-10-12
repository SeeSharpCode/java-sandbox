package com.jbhunt.sandbox.lang;

// Java does NOT support multiple inheritance
public class InheritanceAndInterfaces {
    private interface Repository<T> {
        void save(T t);
    }

    private static class BaseRepository<T> implements Repository<T> {
        @Override
        public void save(T t) {

        }
    }

    // extends must come before implements
    private static class FooRepository extends BaseRepository<Foo> {
        public void foo() {
            save(new Foo());
        }
    }

    private static class Foo { }
}
