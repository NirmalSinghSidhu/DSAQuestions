package nirmal.binaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

import static nirmal.binaryTree.BinaryTree.createTree;

public class HeightOFBT {
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    public static int height2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    //level order traversal

    public static int height3(TreeNode root){
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println(height(root));
        System.out.println(height3(root));
        System.out.println(height2(root));
    }
}
