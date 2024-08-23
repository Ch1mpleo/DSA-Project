import java.util.Arrays;
import java.util.Random;

public class BubbleSortExample {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Hoán đổi arr[j] và arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Nếu không có hoán đổi nào xảy ra, kết thúc sớm
            if (!swapped) break;
        }
    }

    // Hàm in mảng
    public static void main(String[] args) {
        int[] arr = new int[2000000];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000000);
        }

        System.out.println("Mảng ban đầu:");
        printArray(arr);

        long startTime = System.currentTimeMillis();

        // Use a more efficient sorting algorithm
        // Sort tối ưu
        //Arrays.sort(arr);
        bubbleSort(arr);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Mảng sau khi sắp xếp:");
        printArray(arr);

        System.out.println("Thời gian sắp xếp: " + duration + " milliseconds");
    }

    // Utility method to print array (you may want to print only a small part to avoid too much output)
    public static void printArray(int[] arr) {
        for (int i = 0; i < Math.min(arr.length, 2000000); i++) { // Print only the first 100 elements
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
