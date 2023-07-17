package nirmal.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import static nirmal.binaryTree.BinaryTree.createTree;

public class LeftViewOfBT {
    //recursive solution
    private static int maxLevel = 0 ;
    public static void leftView(TreeNode root){
        leftViewHelper(root,1);
    }

    private static void leftViewHelper(TreeNode node ,int level){
        if(node == null){
            return;
        }
        if(level > maxLevel){
            System.out.print(node.data + " ");
            maxLevel = level;
        }

        leftViewHelper(node.left,level+1);
        leftViewHelper(node.right,level+1);
    }

    //level order

    public static void leftView2(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();

            for(int i = 1; i <= n; i++){
                TreeNode node = queue.poll();
                if(i == 1){
                    System.out.print(node.data + " ");
                }

                if(node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        leftView(root);
        System.out.println("");
        leftView2(root);
    }
}
