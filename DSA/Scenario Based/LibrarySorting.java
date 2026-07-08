import java.util.Random;

public class LibrarySorting {

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    // Quick Sort (Lomuto Partition)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Counting Sort (Genre Codes 1-20)
    public static void countingSort(int[] arr) {

        int[] count = new int[21];

        for (int value : arr)
            count[value]++;

        int index = 0;

        for (int i = 1; i <= 20; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    // Generate random years
    public static int[] generateYears(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
            arr[i] = 1900 + rand.nextInt(126);

        return arr;
    }

    // Generate random genre codes (1-20)
    public static int[] generateGenres(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(20) + 1;

        return arr;
    }

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000};

        System.out.printf("%-10s %-18s %-18s %-18s%n",
                "Size", "Merge(ns)", "Quick(ns)", "Counting(ns)");

        for (int size : sizes) {

            int[] mergeArr = generateYears(size);
            int[] quickArr = mergeArr.clone();
            int[] countArr = generateGenres(size);

            long start = System.nanoTime();
            mergeSort(mergeArr, 0, mergeArr.length - 1);
            long mergeTime = System.nanoTime() - start;

            start = System.nanoTime();
            quickSort(quickArr, 0, quickArr.length - 1);
            long quickTime = System.nanoTime() - start;

            start = System.nanoTime();
            countingSort(countArr);
            long countTime = System.nanoTime() - start;

            System.out.printf("%-10d %-18d %-18d %-18d%n",
                    size, mergeTime, quickTime, countTime);
        }
    }
}