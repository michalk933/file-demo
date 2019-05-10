package com.example.filedemo.dto;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Counter {
    private final AtomicInteger value = new AtomicInteger(0);

    public String getNextValueFormatECMS() {
        return String.format("%07d", value.incrementAndGet());
    }

    public void clearCounter() {
        value.set(0);
    }
}
