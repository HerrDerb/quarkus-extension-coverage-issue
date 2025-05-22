package com.example;

import lombok.Getter;

@Getter
public class BaseClient {
    private final String name;

    public BaseClient(String name) {
        this.name = name;
    }
}
