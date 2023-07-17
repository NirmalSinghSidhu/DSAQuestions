package nirmal.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import static nirmal.binaryTree.BinaryTree.createTree;

public class LevelOrderTraversal {
    public static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node  = queue.poll();

            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println("  ");
    }

    public static void levelOrder2(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();

        currentLevel.offer(root);

        while (!currentLevel.isEmpty()){
            TreeNode node = currentLevel.poll();

            System.out.print(node.data+ " ");
            if (node.left != null) {
                nextLevel.offer(node.left);
            }

            if (node.right != null) {
                nextLevel.offer(node.right);
            }
            if (currentLevel.isEmpty()) {
                System.out.println();
                Queue<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }

        }

    }
    public static void main(String[] args) {
     TreeNode root = createTree();
     levelOrder(root);
     levelOrder2(root);
    }
}
