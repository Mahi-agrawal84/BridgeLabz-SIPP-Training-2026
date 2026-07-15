import java.util.Scanner;

public class BankFraudDetection {

    static long count = 0;

    public static void mergeSort(int[] arr, int left, int right) {

        if (left >= right)
            return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        int j = mid + 1;

        for (int i = left; i <= mid; i++) {

            while (j <= right && arr[i] > 3L * arr[j])
                j++;

            count += (j - (mid + 1));
        }

        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left, k = 0; i <= right; i++, k++)
            arr[i] = temp[k];
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            mergeSort(arr, 0, n - 1);

            System.out.println(count);
        }
    }
}