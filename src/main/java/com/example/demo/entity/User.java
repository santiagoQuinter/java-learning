package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class User {
    @Getter @Setter private String name;
    @Getter @Setter private int age;
}
