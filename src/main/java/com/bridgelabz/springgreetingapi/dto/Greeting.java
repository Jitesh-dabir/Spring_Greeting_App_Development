package com.bridgelabz.springgreetingapi.dto;

public class Greeting {
    private final long incrementAndGet;
    private final String format;

    public Greeting(long incrementAndGet, String format) {
        this.incrementAndGet=incrementAndGet;
        this.format=format;
    }

    public long getIncrementAndGet() {
        return incrementAndGet;
    }

    public String getFormat() {
        return format;
    }
}
