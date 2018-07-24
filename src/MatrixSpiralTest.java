import java.util.ArrayList;
import java.util.List;

public class MatrixSpiralTest {
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> spiralOrderedList = new ArrayList<Integer>();

        System.out.println("matrix size check: " + matrix.length);

        // if those jerks gave us an array instead of a matrix
        if (matrix.length == 0) {
            return spiralOrderedList;
        }

        // sides of the box we are spiralling at rightmostColumn now
        int currentRow, currentColumn, lastRow, rightmostColumn;
        currentRow = currentColumn = 0;
        lastRow = matrix.length - 1;
        rightmostColumn = matrix[0].length - 1;

        System.out.println("start - currentRow: " + currentRow);
        System.out.println("start - currentColumn: " + currentColumn);
        System.out.println("start - lastRow: " + lastRow);
        System.out.println("start - rightmostColumn: " + rightmostColumn);
        System.out.println("\n");

        while (currentColumn <= rightmostColumn && currentRow <= lastRow) {
            // process currentColumn to rightmost column.
            for (int i = currentColumn; i <= rightmostColumn; i++) {
                // add to ordered spiral list
                spiralOrderedList.add(matrix[currentRow][i]);

                System.out.println("spiral ordered list: " + spiralOrderedList.toString());
            }

            // go to next row
            currentRow++;

            System.out.println("next current row: " + currentRow);

            // process rightmost column down to last row.
            for (int i = currentRow; i <= lastRow; i++) {
                // add to ordered spiral list.
                spiralOrderedList.add(matrix[i][rightmostColumn]);

                System.out.println("spiral ordered list: " + spiralOrderedList.toString());
            }

            // decrement rightmost layer.
            rightmostColumn--;

            System.out.println("decrement rightmost layer: " + rightmostColumn);

            // ensure current row (growing to last row) never moves past last row (which is decrementing towards current row).
            if (currentRow <= lastRow) {
                // move rightmost to currentColumn (0)
                // add all of bottom layer in order
                for (int i = rightmostColumn; i >= currentColumn; i--) {
                    spiralOrderedList.add(matrix[lastRow][i]);

                    System.out.println("spiral ordered list: " + spiralOrderedList.toString());
                }

                // decrement lowest layer.
                lastRow--;

                System.out.println("lowest layer decremented: " + lastRow);
            }

            // ensure currentColumn never grows past rightMost column (like we did with top and bottom layers).
            if (currentColumn <= rightmostColumn) {
                // currentColumn side - lastRow to currentRow
                // add all of left column in order - bottom to top.
                for (int i = lastRow; i >= currentRow; i--) {
                    spiralOrderedList.add(matrix[i][currentColumn]);

                    System.out.println("spiral ordered list: " + spiralOrderedList.toString());
                }

                // decrement right layer.
                currentColumn++;

                System.out.println("current column incremented: " + currentColumn);
            }
        }

        return spiralOrderedList;
    }

    public static void main(String args[]) {

        int[][] testSpiral = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        int[][] testSpiral2 = {
                {1, 2, 3, 4, 5, 6, 7},
                {8, 9,10,11,12,13,14},
                {15,16,17,18,19,20,21},
                {22,23,24,25,26,27,28}
        };

        System.out.println(spiralOrder(testSpiral2));
    }
}
