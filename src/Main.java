import collections.MyArrayList;
import collections.MyList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        // QUICK SORT
        //int[] arr = {10, 5, 6, 1, 4, 3, 2, 9, 8, 7};
        int[] arr = {10, 5, 6, 1, 4, 1, 2, 9, 1, 7};
        System.out.println("QUICK SORT:");
        System.out.println("Before: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After: " + Arrays.toString(arr));

        // BUBBLE SORT
        int[] arr2 = {10, 5, 6, 1, 4, 1, 2, 9, 1, 7};
        System.out.println("------------------------------");
        System.out.println("BUBBLE SORT:");
        System.out.println("Before: " + Arrays.toString(arr2));
        bubbleSort(arr2);
        System.out.println("After: " + Arrays.toString(arr2));

        // MERGE SORT
        int[] arr3 = {10, 5, 6, 1, 4, 1, 2, 9, 1, 7};
        System.out.println("------------------------------");
        System.out.println("MERGE SORT:");
        System.out.println("Before: " + Arrays.toString(arr3));

//        MyList<String> myList = new MyArrayList<>();
//        myList.add("First");
//        myList.add("Second");
//        myList.add("Third");
//        myList.add("Fourth");
//        myList.add("Fifth");
//        myList.add("Sixth");
//        myList.add("Seventh");
//
//        myList.forEach(System.out::println);
//
//        System.out.println(myList.subList(0, 4));



    }

    public static void quickSort(int[] arr, int start, int end) {

        int pivot = arr[start + (end - start) / 2];
        int s = start, e = end;

        while (s < e) {

            while (arr[s] < pivot)
                s++;

            while (arr[e] > pivot)
                e--;

            if (s < e) {
                if (arr[s] == arr[e]) {
                    s++;
                    e--;
                } else {
                    int val = arr[s];
                    arr[s] = arr[e];
                    arr[e] = val;
                }
            }

            if (arr[s] == arr[e])
                break;
        }

        if (s - start > 1)
            quickSort(arr, start, --s);

        if (end - e > 1)
            quickSort(arr, ++e, end);
    }

    public static void bubbleSort(int[] arr) {

        for (int i = 0, z = arr.length - 1; i < arr.length; i++, z--) {
            for (int s = 0; s < z; s++) {
                if (arr[s] > arr[s + 1]) {
                    int val = arr[s + 1];
                    arr[s + 1] = arr[s];
                    arr[s] = val;
                }
            }
        }
    }

    public static void mergeSort(int[] arr) {

        

    }
}