package org.example;

/**
 * Задание №5, Вариант 1
 */
public class TaskImpl implements Task {

    private Thread thread;
    private volatile boolean isRunning;

    public TaskImpl() {
        this.isRunning = false;
    }

    /** Запускает таймер и задачу, которая должна выполниться по завершению */
    @Override
    public void start(long time, Runner runner) {
        if (time <= 0) {
            runner.run();
            return;
        }

        thread = new Thread(() -> {
            isRunning = true;

            try {
                Thread.sleep(time);
                if (isRunning && !Thread.currentThread().isInterrupted()) {
                    runner.run();
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

            } finally {
                isRunning = false;
            }
        });

        thread.setDaemon(false);
        thread.start();
    }

    /** Останавливает выполнения поток */
    @Override
    public void stop() {
        if (thread != null && isRunning) {
            isRunning = false;
            thread.interrupt();
        }
    }
}
