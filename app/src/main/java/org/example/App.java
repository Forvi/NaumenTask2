package org.example;

public class App {

    public static void main(String[] args) {
        Task task = new TaskImpl();

        // По завершению таймеры выполняется коллбэк функция
        System.out.println("Timer start");
        task.start(10000, () -> {
            System.out.println("Timer stop");
        });

        // Но если досрочно завершить выполнение поток - задача не выполнится
        // Thread.sleep(1000);
        // task.stop();
    }
}
