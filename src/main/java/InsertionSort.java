import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 7, 6, 5, 8};

        System.out.println("Array previous:");
        System.out.println(Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("Array after sorting by Insertion algorithm:");
        System.out.println(Arrays.toString(arr));
    }
}
