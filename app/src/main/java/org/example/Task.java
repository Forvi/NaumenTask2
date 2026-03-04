package org.example;

public interface Task<T> {
    void start(long time, Runner runner);
    void stop();
}
