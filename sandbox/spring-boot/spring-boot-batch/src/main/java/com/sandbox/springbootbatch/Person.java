package com.sandbox.springbootbatch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // required for Spring to create a new instance via reflection
@AllArgsConstructor
public class Person {
    private String lastName;
    private String firstName;

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }
}
