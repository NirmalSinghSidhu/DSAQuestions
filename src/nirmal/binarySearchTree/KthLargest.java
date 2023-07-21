package nirmal.binarySearchTree;

import java.util.ArrayList;

public class KthLargest {
    private static int count;
    private static int kthLargest;
    public static int findKthLargest(TreeNode root, int k) {
        count = 0;
        kthLargest = 0;
        reverseInorderTraversal(root, k);
        return kthLargest;
    }

    private static void reverseInorderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        reverseInorderTraversal(root.right, k);

        count++;
        if (count == k) {
            kthLargest = root.val;
            return;
        }
        reverseInorderTraversal(root.left, k);
    }

    //Another Approach

    private static int getKthLargest2(TreeNode root ,int k){
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list.get(list.size()-k);
    }
    private static void inorderTraversal(TreeNode root, ArrayList<Integer> values) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, values);
        values.add(root.val);
        inorderTraversal(root.right, values);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int kthLargest = getKthLargest2(root, 3);
        System.out.println("Kth Largest Element: " + kthLargest);
    }

}
