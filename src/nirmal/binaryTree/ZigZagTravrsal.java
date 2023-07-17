package nirmal.binaryTree;

import java.lang.reflect.Array;
import java.util.*;

import static nirmal.binaryTree.BinaryTree.createTree;

public class ZigZagTravrsal {

    public static ArrayList<Integer> zigzag(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean leftToRight = true;
        deque.offer(root);

        while(!deque.isEmpty()){
            int levelSize = deque.size();
            ArrayList<Integer> levelValues = new ArrayList<>();

            for(int i = 0; i < levelSize; i++){
                if(leftToRight){
                    TreeNode node = deque.pollFirst();
                    levelValues.add(node.data);

                    if(node.left != null){
                        deque.offerLast(node.left);
                    }
                    if(node.right != null){
                        deque.offerLast(node.right);
                    }
                } else{
                    TreeNode node = deque.pollLast();
                    levelValues.add(node.data);

                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }

                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                }
            }
            ans.addAll(levelValues);
            leftToRight = !leftToRight;
        }
        return ans;
    }

    //using stack
    public static List<Integer> zigzag2(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        boolean leftToRight = true;

        currentLevel.push(root);

        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.pop();

            result.add(node.data);

            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }

                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }

                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                leftToRight = !leftToRight;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
       ArrayList<Integer> ans = zigzag(root);
        System.out.println(ans);
        System.out.println(zigzag2(root));
    }
}
