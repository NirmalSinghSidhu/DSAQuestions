package nirmal.binarySearchTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static nirmal.binarySearchTree.BinarySearchTree.print;

public class MergeTwoBSTs {
    public static TreeNode mergeBSTs(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> values = new ArrayList<>();
        inorderTraversal(root1, values);
        inorderTraversal(root2, values);
        Collections.sort(values);
        return construct(values,0,values.size()-1);
    }

    private static TreeNode construct(ArrayList<Integer> inorder, int start,int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = construct(inorder,start,mid-1);
        root.right  = construct(inorder,mid+1,end);
        return root;
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
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(6);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(8);

        TreeNode root = mergeBSTs(root1,root2);
        System.out.println("Merged Binary Search Tree (BST):");
        print(root);
    }
}
