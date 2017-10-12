package com.sandbox.springbootjms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String to;
    private String body;

    @Override
    public String toString() {
        return "Email{" +
                "to='" + to + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
