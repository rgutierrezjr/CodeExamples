public class IsBinarySearchTreeTest {

    public static class TreeNode {

        TreeNode(int data) {
            this.data = data;
        }

        int data;
        TreeNode left;
        TreeNode right;
    }

    public static boolean checkBST(TreeNode root) {
        // if root is null, return false
        if(root == null) {
            return false;
        }

        // recursively validate the structure using given constraints. 0 min 10^4 max.
        return helper(root, 0, 10000);
    }

    public static boolean helper(TreeNode root, int low, int high){

        // if node data is lower than or equal to root data OR node data is greater than
        // or equal to root data, then this is not a true Binary Tree. Bubble up false.
        if(root.data <= low || root.data >= high)
            return false;

        // if passes BST test this pass, recurse to left node.
        if(root.left != null && !helper(root.left, low, root.data)){
            return false;
        }

        // if passes bsT test this pass, recurse to right node.
        if(root.right != null && !helper(root.right, root.data, high)){
            return false;
        }

        // if both left and right nodes are validated, return true.
        return true;
    }

    public static void main(String[] args) {
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

        System.out.println(checkBST(root));
    }

}
