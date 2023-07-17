package nirmal.binaryTree;

import java.util.Stack;

import static nirmal.binaryTree.BinaryTree.createTree;

public class PreOrder {
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            System.out.print(node.data+" ");

            if(node.right != null){
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        preOrder(root);
        System.out.println();
        preorderTraversal(root);
    }
}
