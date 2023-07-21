package nirmal.binarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

import static nirmal.binarySearchTree.BinarySearchTree.print;

public class ConvertBTtoBST {
    public  static TreeNode convertToBST(TreeNode root){
        if(root == null){
            return root;
        }
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversal(root,inorder);
        Collections.sort(inorder);
        return construct(inorder,0,inorder.size()-1);
    }

    private static void inorderTraversal(TreeNode root,  ArrayList inorder){
       if(root == null){
           return;
       }
       inorderTraversal(root.left,inorder);
       inorder.add(root.val);
       inorderTraversal(root.right, inorder);
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
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        root = convertToBST(root);
        System.out.println("Binary Search Tree (BST) converted from Binary Tree:");
        print(root);
    }
}
