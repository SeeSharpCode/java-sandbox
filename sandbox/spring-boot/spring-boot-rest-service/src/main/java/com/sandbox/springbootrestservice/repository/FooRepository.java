package com.sandbox.springbootrestservice.repository;

import com.sandbox.springbootrestservice.entity.Foo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FooRepository extends CrudRepository<Foo, Long> {
    List<Foo> findAll();
    Foo findById(Long id);
}