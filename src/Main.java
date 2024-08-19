import collections.MyArrayList;
import collections.MyLinkedList;
import collections.MyList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // QUICK SORT
        System.out.println("-------------- QUICK SORT ------------------");
        //int[] arr = {10, 5, 6, 1, 4, 3, 2, 9, 8, 7};
        int[] arr = {10, 5, 6, 1, 4, 1, 2, 9, 1, 7};
        System.out.println("QUICK SORT:");
        System.out.println("Before: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After: " + Arrays.toString(arr));

        // BUBBLE SORT
        System.out.println("-------------- BUBBLE SORT ------------------");
        int[] arr2 = {10, 5, 6, 1, 4, 1, 2, 9, 1, 7};
        System.out.println("BUBBLE SORT:");
        System.out.println("Before: " + Arrays.toString(arr2));
        bubbleSort(arr2);
        System.out.println("After: " + Arrays.toString(arr2));

        // MERGE SORT
        System.out.println("-------------- MERGE SORT ------------------");
        int[] arr3 = {10, 5, 6, 1, 4, 1, 2, 9, 1, 7};
        System.out.println("MERGE SORT:");
        System.out.println("Before: " + Arrays.toString(arr3));

        // MyArrayList HOMEWORK-1
        System.out.println("-------------- ARRAY LIST ------------------");
        MyList<String> myList = new MyArrayList<>();
        myList.add("First");
        myList.add("Second");
        myList.add("Third");
        myList.add("Fourth");
        myList.add("Fifth");
        myList.add("Sixth");
        myList.add("Seventh");

        System.out.println("FOREACH:");
        myList.forEach(o -> System.out.println("> " + o));

        System.out.println("ALL: " + myList);
        System.out.println("REMOVED FIRST: " + myList.remove(0) + " RESULT: " + myList);
        String removeItem = myList.get(0);
        System.out.println("REMOVED ITEM: " + myList.remove(removeItem) + " RESULT: " + myList);
        System.out.println("GET ITEM: " + myList.get(0));
        myList.set(0, "NEW VALUE");
        System.out.println("SET ITEM \"NEW VALUE\": " + myList);
        System.out.println("SIZE: " + myList.size());
        System.out.println("SUB LIST 1-3: " + myList.subList(1, 3));

        // MyLinkedList HOMEWORK-1
        System.out.println("-------------- LINKED LIST ------------------");
        MyList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("First");
        myLinkedList.add("Second");
        myLinkedList.add("Third");
        myLinkedList.add("Fourth");
        myLinkedList.add("Fifth");
        myLinkedList.add("Sixth");
        myLinkedList.add("Seventh");

        System.out.println("FOREACH:");
        myLinkedList.forEach(o -> System.out.println("> " + o));

        System.out.println("ALL: " + myLinkedList);
        System.out.println("REMOVED FIRST: " + myLinkedList.remove(0) + " RESULT: " + myLinkedList);
        String removeItemLL = myLinkedList.get(0);
        System.out.println("REMOVED ITEM: " + myLinkedList.remove(removeItemLL) + " RESULT: " + myLinkedList);
        System.out.println("GET ITEM: " + myLinkedList.get(0));
        myLinkedList.set(0, "NEW VALUE");
        System.out.println("SET ITEM \"NEW VALUE\": " + myLinkedList);
        System.out.println("SIZE: " + myLinkedList.size());
        System.out.println("SUB LIST 1-3: " + myLinkedList.subList(1, 3));
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