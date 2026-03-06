package org.example;

public interface Task {
    // я решил добавить время выполнения и задачу

    /** Запускает задачу */
    void start(long time, Runner runner);

    /** Останавливает задачу */
    void stop();
}