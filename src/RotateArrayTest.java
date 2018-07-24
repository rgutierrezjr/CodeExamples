import java.util.Arrays;

public class RotateArrayTest {
    public static int[] rotateArray(int[] array, int d) {
        int n = array.length;

        System.out.println(Arrays.toString(array));

        // create a temp array for rotated elements instantiated to the same length.
        int[] rotated = new int[n];

        System.out.println("shift (d) " + d);
        System.out.println("array length (n) " + n);

        System.out.println("start a array[3] and copy to n-d (7-3=4)");

        System.arraycopy(array, d, rotated, 0, n - d);

        System.out.println("rotated: " + Arrays.toString(rotated));

        System.arraycopy(array, 0, rotated, n - d, d);

        System.out.println("rotated: " + Arrays.toString(rotated));

        return rotated;
    }

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,7};

        System.out.println(Arrays.toString(rotateArray(array, 3)));

    }
}
