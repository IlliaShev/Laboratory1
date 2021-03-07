package utils;

import java.lang.reflect.Array;
import java.util.Comparator;

public class Quicksort {

    public static Object[] quickSort(Object[] array, int from, int to, Comparator comparator) {
        if (from < to) {
            int divideElem = partition(array, from, to, comparator);
            quickSort(array, from, divideElem - 1, comparator);
            quickSort(array, divideElem, to, comparator);
        }
        return array;
    }

    private static int partition(Object[] array, int from, int to, Comparator comparator) {
        int leftIndex = from;
        int rightIndex = to;
        Object pivot = array[(from + to) / 2];
        while (leftIndex <= rightIndex) {

            while (comparator.compare(array[leftIndex], pivot) < 0) {
                leftIndex++;
            }

            while (comparator.compare(array[rightIndex], pivot) > 0) {
                rightIndex--;
            }


            if (leftIndex <= rightIndex) {
                swapElem(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swapElem(Object[] array, int leftIndex, int rightIndex) {
        Object temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
