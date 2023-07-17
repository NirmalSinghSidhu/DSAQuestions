package nirmal.binaryTree;

import java.util.Stack;

import static nirmal.binaryTree.BinaryTree.createTree;
import static nirmal.binaryTree.LevelOrderTraversal.levelOrder2;

public class MirrorOFBT {

    public static TreeNode mirror(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirror(root.right);
        root.right = mirror(temp);

        return root;
    }

    //using stack

    public static TreeNode mirror2(TreeNode root){
        if( root == null){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            TreeNode temp =  node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode treeNode = createTree();
        levelOrder2(treeNode);

        treeNode = mirror(treeNode);
        levelOrder2(treeNode);
    }
}
