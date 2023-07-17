package nirmal.binaryTree;

import static nirmal.binaryTree.BinaryTree.createTree;

public class BinaryTreeBalanced {

    public static boolean isBalanced(TreeNode root){
        return getHeight(root) != -1;
    }

    private static int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = getHeight(node.left);
        if(leftHeight == -1){
            return -1;
        }

        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) >1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight);
    }
    public static void main(String[] args) {
       TreeNode root = createTree();
        System.out.println(isBalanced(root));
    }
}
