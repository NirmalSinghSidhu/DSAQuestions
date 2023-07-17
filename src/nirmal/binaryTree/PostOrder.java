package nirmal.binaryTree;

import java.util.Stack;

import static nirmal.binaryTree.BinaryTree.createTree;

public class PostOrder {
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void postOrder(TreeNode root){
        if(root == null){
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
     TreeNode root = createTree();
     postOrder(root);
        System.out.println();
     postorderTraversal(root);
    }
}
