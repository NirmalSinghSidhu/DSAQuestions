package nirmal.binaryTree;

import java.util.Stack;

import static nirmal.binaryTree.BinaryTree.createTree;

public class InOrder {
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current=current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");

            current = current.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        inOrder(root);
        inorderTraversal(root);
    }
}
