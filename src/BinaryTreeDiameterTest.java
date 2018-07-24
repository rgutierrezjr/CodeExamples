import sun.reflect.generics.tree.Tree;

public class BinaryTreeDiameterTest {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);

        System.out.println("final max: " + max);
        return max;
    }

    private static int maxDepth(TreeNode root) {
        // base case, if root is null return 0
        if (root == null) {
            System.out.println("base case encountered.");
            return 0;
        }

        // get max depth left - recursively
        System.out.println("recurse left, root: " + root.val);
        int left = maxDepth(root.left);
        System.out.println("left depth: " + left);

        // get max depth right - recursively
        System.out.println("recurse right, root: " + root.val);
        int right = maxDepth(root.right);
        System.out.println("right depth: " + right);

        // set the max between left and right depth.
        max = Math.max(max, left + right);
        System.out.println("set max: " + max);

        return Math.max(left, right) + 1;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);

        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(6);

        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(4);

        left1.left = left2;
        left1.right = right2;

        TreeNode right3 = new TreeNode(9);
        TreeNode right4 = new TreeNode(10);
        TreeNode left3 = new TreeNode(8);

        right1.right = right3;
        right3.right = right4;
        right3.left = left3;

        TreeNode right5 = new TreeNode(11);

        right4.right = right5;

        System.out.println(diameterOfBinaryTree(root));
    }
}
