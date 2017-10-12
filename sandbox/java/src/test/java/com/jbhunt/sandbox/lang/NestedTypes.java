package com.jbhunt.sandbox.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

public class NestedTypes {
    // nested static classes provide structure but are not associated with an instance of the outer class
    // non-static nested classes are associated with an instance of the outer class
    @Data
    @AllArgsConstructor
    public static class Passenger {
        private RewardsProgram rewardsProgram;

        static class RewardsProgram {
        }
    }

    @Test
    public void nestedTypes() {
        Passenger passenger = new Passenger(new Passenger.RewardsProgram());
    }
}
