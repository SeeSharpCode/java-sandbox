package com.sandbox.springbootrestclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Quote {
    private String type;
    private Value value;

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
