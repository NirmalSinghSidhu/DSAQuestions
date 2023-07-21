package nirmal.binarySearchTree;

import java.util.ArrayList;

public class KthSmallest {
    private int count;
    private int kthSmallest;

    public int findKthSmallest2(TreeNode root, int k) {
        count = 0;
        kthSmallest = 0;
        inorderTraversal(root, k);
        return kthSmallest;
    }

    private void inorderTraversal(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, k);

        count++;
        if (count == k) {
            kthSmallest = root.val;
            return;
        }

        inorderTraversal(root.right, k);
    }
    private static int findKthSmallest(TreeNode root ,int k){
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list.get(k-1);
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
        int kthSmallest = findKthSmallest(root, 3);
        System.out.println("Kth Smallest Element: " + kthSmallest);
    }
}
