package com.thinkf.chapter10.c08;

public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    protected Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
