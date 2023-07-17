package nirmal.binaryTree;

import static nirmal.binaryTree.BinaryTree.createTree;

public class Diameter {
    public static int diameter(TreeNode root){
        if(root == null){
            return  0 ;
        }

        int leftHeight = height(root.left);
        int rightHeight =height(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(leftHeight + rightHeight,Math.max(leftDiameter,rightDiameter));
    }
    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println(diameter(root));
    }
}
