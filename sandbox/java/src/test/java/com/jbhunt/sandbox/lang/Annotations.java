package com.jbhunt.sandbox.lang;

import java.lang.annotation.*;

public class Annotations {

    private static class Foo {
        @Override
        public String toString() {
            return super.toString();
        }

        @MyAnnotation(foo = true)
        public void foo() {

        }

        @Deprecated
        public void deprecatedMethod() { }
    }

    // @SuppressWarnings("deprecation")
    private static class Bar {
        // @SuppressWarnings("deprecation")
        public Bar() {
            Foo foo = new Foo();
            foo.deprecatedMethod();
            Annotation[] annotations = foo.getClass().getAnnotations();
        }
    }

    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    private @interface MyAnnotation {
        boolean foo() default true;
    }
}
