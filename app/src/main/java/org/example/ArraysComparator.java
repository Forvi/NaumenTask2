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
    
}
