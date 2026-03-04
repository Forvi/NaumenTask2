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

    @Override
    public void start(long totalTime, Runner runner) {
        if (totalTime <= 0) {
            runner.run();
            return;
        }

        thread = new Thread(() -> {
            this.isRunning = true;
            long startTime = System.currentTimeMillis();

            try {
                while (isRunning && !Thread.currentThread().isInterrupted()) {
                    Thread.sleep(1000);

                    long elapsed = System.currentTimeMillis() - startTime;
                    long remaining = totalTime - elapsed;

                    System.out.println(format(Math.max(0, remaining)));
                    if (elapsed >= totalTime) {
                        if (isRunning && !Thread.currentThread().isInterrupted()) {
                            runner.run();
                        }

                        break;
                    }
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

    @Override
    public void stop() {
        if (thread != null && isRunning) {
            isRunning = false;
            thread.interrupt();
        }
    }

    private String format(long time) {
        long total = time / 1000;
        long minutes = total / 60;
        long seconds = total % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

}