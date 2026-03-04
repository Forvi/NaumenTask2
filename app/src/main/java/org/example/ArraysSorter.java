package org.example;

import java.util.ArrayList;
import java.util.Comparator;

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

}