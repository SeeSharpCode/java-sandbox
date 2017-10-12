package com.sandbox.springbootrestservice.controller;

import com.sandbox.springbootrestservice.entity.Foo;
import com.sandbox.springbootrestservice.repository.FooRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/foo")
@RestController
public class FooController {
    // @NonNull - was using for @RequiredArgsConstructor, but final also works
    private final FooRepository fooRepository;

    @Value("${foo}")
    private String foo;

    @Value("${my.list}")
    private List<String> list;

    // @GetMapping - empty path would map to localhost:8080/ if the @RequestMapping class annotation was missing
    @GetMapping("/simple")
    public String findFooSimple() {
        return foo;
    }

    @GetMapping("/{id}")
    public Foo findFooById(@PathVariable("id") Long id) {
        return fooRepository.findById(id);
    }

    @PostMapping(value = "/update")
    public void updateFoo(@RequestBody Foo foo) {
        fooRepository.save(foo);
    }

    @GetMapping("/list")
    public List<String> list() {
        return list;
    }
}
