package com.sandbox.springbootrestservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Foo {
    @Id
    @GeneratedValue
    private Long id;

    // @Column - unnecessary unless overriding defaults
    private String name;
}
