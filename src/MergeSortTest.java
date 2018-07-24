import java.util.Arrays;

public class MergeSortTest {
    public static long countInversions(int[] a){
        int n = a.length;

        // Base Case, cannot split array of size 1.
        if(n <= 1) {
            return 0;
        }

        System.out.println("size: " + n);
        System.out.println("middle: " + (n >> 1));

        // >> to get the middle point. if odd length, it will take
        // the floor value. i.e. 9 >> 1 = (n-1) / 2
        int mid = n >> 1;

        // split array, copy left side
        int[] left = Arrays.copyOfRange(a, 0, mid);

        // split array, copy right right
        int[] right = Arrays.copyOfRange(a, mid, a.length);

        // return number of merges. recurse until base case, stack pop
        // will continue after this line, once all arrays split.

        long inversions = countInversions(left) + countInversions(right);

        int range = n - mid;
        int iLeft = 0;
        int iRight = 0;

        for(int i = 0; i < n; i++) {
            if(iLeft < mid && (iRight >= range || left[iLeft] <= right[iRight])) {
                a[i] = left[iLeft++];
                inversions += iRight;
            } else if(iRight < range) {
                a[i] = right[iRight++];
            }
        }

        return inversions;
    }

    public static void main(String[] args) {
        int[] toSort = { 5, 2, 8, 0, 3, 5, 6, 1, 4, 9 };

        System.out.println(countInversions(toSort));
    }
}
