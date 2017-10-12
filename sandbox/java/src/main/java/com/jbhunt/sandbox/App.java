package com.jbhunt.sandbox;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        try {
            throw new Exception("hey");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}