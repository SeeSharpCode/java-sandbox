package com.jbhunt.sandbox.lang;

public class Enums {
    public enum JobTitle {
        Programmer,
        ProgrammingAnalyst,
        ProgrammingSpecialist
    }

    private static class Employee {
        JobTitle jobTitle;
    }
}
