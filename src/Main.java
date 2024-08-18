import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //int[] arr = {10, 5, 6, 1, 4, 3, 2, 9, 8, 7};
        int[] arr = {10, 5, 6, 1, 4, 1, 2, 9, 1, 7};
        System.out.println("QUICK SORT:");
        System.out.println("Before: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("After: " + Arrays.toString(arr));
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

}