package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * Задание №1, Вариант №1
 */
public class ArraysComparator<T extends Number> {

    private T[] arr;

    public ArraysComparator(T[] arr) {
        this.arr = arr;
    }

    /**
     * Находит абсолютное максимальное значение в массиве.
     */
    public Optional<T> findAbsMax() {
        return Arrays
                .stream(arr)
                .max(Comparator.comparing(e -> Math.abs(e.doubleValue())));
    }

    public static void main(String[] args) {
        // p.s. Добавил отрицательные значения, несмотря на условие [0, ∞),
        // т.к. суть задания - найти АБСОЛЮТНОЕ значение
        Integer[] numbers = { -1, -23, 1, 4, 6, 7, 15 };
        System.out.println("Исходный массив: " + Arrays.toString(numbers));

        var arrayComparator = new ArraysComparator<>(numbers);
        Optional<Integer> result = arrayComparator.findAbsMax();
        result.ifPresentOrElse(
                v ->
                        System.out.println("Максимальное значение по модулю: " + Math.abs(v)),
                () -> System.out.println("Произошла ошибка при обработке массива"));
    }

}
