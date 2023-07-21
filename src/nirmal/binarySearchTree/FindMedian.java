package nirmal.binarySearchTree;

public class FindMedian {
    private static int totalNodes;
    public static double findMedian(TreeNode root) {
        totalNodes = countNodes(root);

        if (totalNodes % 2 == 1) {
            // Odd number of nodes, return the middle element
            return findKthSmallest(root, totalNodes / 2 + 1);
        } else {
            // Even number of nodes, return the average of the two middle elements
            double first = findKthSmallest(root, totalNodes / 2);
            double second = findKthSmallest(root, totalNodes / 2 + 1);
            return (first + second) / 2.0;
        }
    }
    private static int findKthSmallest(TreeNode root , int k){
        int leftNodes = countNodes(root.left);
        if(leftNodes +1 == k){
            return root.val;
        } else if (leftNodes + 1 < k) {
            return findKthSmallest(root.right,k-leftNodes-1);
        }else{
            return findKthSmallest(root.right, k);
        }
    }

    private static int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + countNodes(root.left)+countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);

        System.out.println("Median of BST: " + findMedian(root));
    }
}
