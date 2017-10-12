package com.jbhunt.sandbox.patterns;

public class Singleton {
    // old way
    private static class MySingleton {
        public static final MySingleton INSTANCE = new MySingleton();
        private MySingleton() {}
    }

    // new - and less popular - enum way
    private enum Elvis {
        INSTANCE;
        void foo() {}
    }
}
