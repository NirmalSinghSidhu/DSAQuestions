package nirmal.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static nirmal.binaryTree.BinaryTree.createTree;

public class ReverseLevelOrder {

    public static void reverseLevelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            stack.push(node);

            if(node.right != null){
                queue.offer(node.right);
            }

            if (node.left != null) {
                queue.offer(node.left);
            }
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.data + " ");
        }
    }

    public static void reverseLevelOrder2(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> ans = new ArrayList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans.add(node);

            if(node.right != null){
                queue.offer(node.right);
            }

            if (node.left != null) {
                queue.offer(node.left);
            }
        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i).data + " ");
        }
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        reverseLevelOrder(root);
        reverseLevelOrder2(root);
    }
}
