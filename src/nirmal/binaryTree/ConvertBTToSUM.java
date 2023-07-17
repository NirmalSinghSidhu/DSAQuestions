package nirmal.binaryTree;

import nirmal.binaryTree.TreeNode;

import static nirmal.binaryTree.BinaryTree.createTree;
import static nirmal.binaryTree.BinaryTree.display;
import static nirmal.binaryTree.LevelOrderTraversal.levelOrder2;

public class ConvertBTToSUM {
    //recursive

    public static void covertToSumTree(TreeNode root){
        if(root == null){
            return;
        }
        convertToSum(root);
    }

    private static int convertToSum(TreeNode node){
        if(node == null){
            return 0;
        }

        int originalValue = node.data;

        int leftSum = convertToSum(node.left);
        int rightSum = convertToSum(node.right);

        node.data = leftSum + rightSum;
        return originalValue + node.data;
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        display(root,0);
        covertToSumTree(root);
        System.out.println();
        display(root,0);
    }
}
