import java.util.Arrays;

public class BubbleSortTest {
    public static int[] bubbleSort(int[] array) {
        int n = array.length;

        // number of swaps for all array iterations
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {
            // number of swaps for current array iteration
            int numSwaps = 0;

            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    numSwaps++;
                    totalSwaps++;
                }
            }

            if (numSwaps == 0) {
                System.out.printf("Array is sorted in %d swaps.\n", totalSwaps);
                System.out.printf("First Element: %d\n", array[0]);
                System.out.printf("Last Element: %d\n", array[n - 1]);

                break;
            }
        }

        return array;
    }

    public static void main(String[] args) {

        int[] toSort = { 5, 2, 8, 0, 3, 5, 6, 1, 4, 9 };

        System.out.println(Arrays.toString(bubbleSort(toSort)));

    }
}
