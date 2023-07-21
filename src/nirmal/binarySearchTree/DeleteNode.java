package nirmal.binarySearchTree;

import static nirmal.binarySearchTree.BinarySearchTree.print;
import static nirmal.binarySearchTree.Floor.inorder;

public class DeleteNode {
    public static TreeNode delete(TreeNode root , int val){
        if(root == null){
            return root;
        }
        if(root.val > val){
           root.left = delete(root.left, val);
        } else if (root.val < val) {
           root.right = delete(root.right,val);
        }else{
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }else{
                TreeNode successor = findSuccessor(root.right);
                root.val = successor.val;
                root.right = delete(root.right, root.val);
            }
        }
        return root;
    }
    public static TreeNode findSuccessor(TreeNode node){
       TreeNode current = node;
       while(current.left != null){
           current = current.left;
       }
       return current;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        root = delete(root, 4);
        System.out.println("BST after deletion:");
        print(root);
    }
}
