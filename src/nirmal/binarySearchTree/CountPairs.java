package nirmal.binarySearchTree;

import java.util.Stack;

public class CountPairs {
    public static  int countPairs(TreeNode root1,TreeNode root2,int target){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        pushLeft(root1,stack1);
        pushRight(root2,stack2);

        int count  = 0;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            TreeNode node1 = stack1.peek();
            TreeNode node2 = stack2.peek();

            int sum = node1.val + node2.val;

            if(sum == target){
                count++;
                stack1.pop();
                stack2.pop();

                pushLeft(node1.right,stack1);
                pushRight(node2.left,stack2);
            } else if (sum < target) {
                stack1.pop();
                pushLeft(node1.right, stack1);
            } else {
                stack2.pop();
                pushRight(node2.left, stack2);
            }
        }
      return count;
    }

    public static void pushLeft(TreeNode node , Stack<TreeNode> stack){
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
    }

    public static void pushRight(TreeNode node , Stack<TreeNode> stack){
        while(node!=null){
            stack.push(node);
            node = node.right;
        }
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(6);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(8);

        int count = countPairs(root1, root2, 10);
        System.out.println("Count of Pairs: " + count);
    }
}
