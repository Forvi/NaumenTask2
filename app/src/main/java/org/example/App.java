package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Лавров Никита, Вариант №1");
        boolean isRunning = true;

        while (isRunning) {
            System.out.print("\nВыберите номер задания (1-5, 0 - выход): ");
            int number = scanner.nextInt();

            switch (number) {
                case 0:
                    System.out.println("Выход из программы");
                    isRunning = false;
                    break;
                case 1:
                    app.startTask1();
                    break;
                case 2:
                    app.startTask2();
                    break;
                case 3:
                    app.startTask3();
                    break;
                case 4:
                    app.startTask4();
                    break;
                case 5:
                    app.startTask5();
                    break;
                default:
                    System.out.println("Неверный номер. Выберите от 1 до 5 (0 - выход)");
                    break;
            }
        }

        scanner.close();
    }

    private void startTask1() {
        Integer[] numbers = { -1, -23, 1, 4, 6, 7, 15 };
        System.out.println("Исходный массив: " + Arrays.toString(numbers));

        var arrayComparator = new ArraysComparator<>(numbers);
        Optional<Integer> result = arrayComparator.findAbsMax();
        result.ifPresentOrElse(
                v -> System.out.println("Максимальное значение по модулю: " + Math.abs(v)),
                        () -> System.out.println("Произошла ошибка при обработке массива"));
    }

    private void startTask2() {
        var arr = new ArrayList<>(Arrays.asList(6, 3, 24, 64, 12, 75));

        var sorter = new ArraysSorter<Integer>();
        var res = sorter.sortMerge(arr, Integer::compareTo);

        System.out.println("Исходный список: " + arr);
        System.out.println("Отсортированный список: " + res);
    }

    private void startTask3() {
        var employeeList = new ArrayList<Employee>();
        App.fillList(employeeList);

        System.out.println("Исходный список:");
        employeeList.forEach(System.out::println);
        System.out.println("\n Итог:");

        var result = employeeList.stream().filter(e -> e.getAge() > 30);
        result.forEach(System.out::println);
    }

    private static void fillList(ArrayList<Employee> list) {
        list.add(new Employee("Петров Петр Петрович", 32, "IT", 65_000.0));
        list.add(new Employee("Иванов Иван Иванов", 23, "Marketing", 58_000.0));
        list.add(new Employee("Васильев Василий Васильевич", 37, "Management", 120_000.0));
        list.add(new Employee("Попова Анна Владимировна", 18, "Design", 35_000.0));
        list.add(new Employee("Лавров Никита Алексеевич", 22, "IT", 60_000.0));
    }

    private void startTask4() {
        var ip = HttpBin.getIp();
        System.out.println(ip);
    }

    private void startTask5() throws InterruptedException {
        Task task = new TaskImpl();

        System.out.println("Timer start");
        task.start(10000, () -> {
            System.out.println("Timer stop");
        });

        Thread.sleep(11000);
        task.stop();
    }
}
