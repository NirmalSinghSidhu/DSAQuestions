package nirmal.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import static nirmal.binaryTree.BinaryTree.createTree;

public class RightViewOfBT {

    //recursive
    private static int maxLevel = 0;
    public static void rightView(TreeNode root){
        rightViewHelper(root,1);
    }

    private static void rightViewHelper(TreeNode node ,int level){
        if(node == null ){
            return;
        }

        if(level > maxLevel){
            System.out.print(node.data + " ");
            maxLevel = level;
        }

        rightViewHelper(node.right, level + 1);
        rightViewHelper(node.left, level + 1);
    }

    //levelOrder

    public static void rightView2(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();

            for(int i = 0; i < n;i++){
                TreeNode node = queue.poll();
                if( i == n-1){
                    System.out.print(node.data +" ");
                }

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        rightView(root);
        System.out.println();
        rightView2(root);
    }
}
