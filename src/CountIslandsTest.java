import java.util.Arrays;

public class CountIslandsTest {
    static int maxGridRows;
    static int maxGridColumns;

    public static int numIslands(char[][] grid) {
        int count = 0;
        maxGridRows = grid.length;
        
        // if the grid has 0 rows, return 0 islands.
        if (maxGridRows == 0) {
            return 0;
        }
        
        maxGridColumns = grid[0].length;

        // traverse left to right
        // this algotritm treats this grid as a map, where each '1' node that triggers DFS is considered
        // an island. visited child nodes are marked as '0'.
        for (int x = 0; x < maxGridRows; x++) {
            System.out.println("outer iteration: " + x);
            // traverse top to bottom
            for (int y = 0; y < maxGridColumns; y++) {
                System.out.println("inner iteration: " + x);

                // the number of root nodes that trigger DFS are considered islands.
                // every visited child will be marked as '0'.
                if (grid[x][y] == '1') {
                    DFSMarking(grid, x, y);

                    // once x - y has been processed only islands should remain. count islands.

                    System.out.println("count increment: " + (count + 1));
                    printMatrix(grid);

                    count++;
                }
            }
        }
        
        return count;
    }

    static void DFSMarking(char[][] grid, int x, int y) {
        System.out.println("recursion: [" + x + "][" + y +"]");

        // base checks, return if:
        // out of bound checks (max grid rows , max maxGridColumns)
        // if index fall under 0
        // if matrix value is not land.
        if (x < 0 || y < 0 || x >= maxGridRows || y >= maxGridColumns || grid[x][y] != '1') {
            System.out.println("base case met.");
            return;
        }

        grid[x][y] = '0';

        // recurse straight column column
        DFSMarking(grid, x + 1, y);
//        printMatrix(grid);

//        System.out.println("x-1 recursion: " + x);
        // recurse down and back up, stop when base case.
        DFSMarking(grid, x - 1, y);
//        printMatrix(grid);

//        System.out.println("y+1 recursion: " + x + ", " + y);
        // recurse to next column, to right. stop when base case.
        DFSMarking(grid, x, y + 1);
//        printMatrix(grid);

        // recurse to from right to left. stop when base case.
        DFSMarking(grid, x, y - 1);
//        printMatrix(grid);
    }

    public static void main(String args[]) {

        char[][] map = {
                {'1','1','1','0'},
                {'1','1','0','0'},
                {'1','1','0','0'},
                {'1','0','0','0'},
                {'1','1','0','1'},
                {'1','0','1','0'}
        };

        printMatrix(map);
        System.out.println(numIslands(map));
    }

    public static void printMatrix(char[][] grid) {
        // Loop through all rows
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\n");
    }
}
