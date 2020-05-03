package com.bridgelabz.springgreetingapi;

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
