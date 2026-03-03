package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Задание №2, Вариант №1
 */
public class ArraysSorter<T extends Number> {

    /** Рекурсивно делит список надвое и сортирует на основе comparator'а */
    public ArrayList<T> sortMerge(ArrayList<T> list, Comparator<T> comparator) {
        int mid = list.size() / 2;
        var a = new ArrayList<>(list.subList(0, mid));
        var b = new ArrayList<>(list.subList(mid, list.size()));

        if (a.size() > 1) a = sortMerge(a, comparator);
        if (b.size() > 1) b = sortMerge(b, comparator);

        return unionLists(a, b, comparator);
    }

    /** Объединяет два списка */
    private ArrayList<T> unionLists(ArrayList<T> a, ArrayList<T> b, Comparator<T> comparator) {
        ArrayList<T> res = new ArrayList<>();

        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (comparator.compare(a.get(i), b.get(j)) <= 0) {
                res.add(a.get(i++));
            } else {
                res.add(b.get(j++));
            }
        }

        while (i < a.size()) res.add(a.get(i++));
        while (j < b.size()) res.add(b.get(j++));

        return res;
    }

    public static void main(String[] args) {
        var arr = new ArrayList<>(Arrays.asList(6, 3, 24, 64, 12, 75));

        var sorter = new ArraysSorter<Integer>();
        var res = sorter.sortMerge(arr, Integer::compareTo);

        System.out.println("Исходный список: " + arr);
        System.out.println("Отсортированный список: " + res);

        // Исходный список: [6, 3, 24, 64, 12, 75]
        // Отсортированный список: [3, 6, 12, 24, 64, 75]
    }
}
