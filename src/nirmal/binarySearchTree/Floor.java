package nirmal.binarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

import static nirmal.binarySearchTree.BinarySearchTree.createSampleBST;

public class Floor {
    //iterative and optimized

    public static int floor(TreeNode root,int key){
        int floor = Integer.MAX_VALUE;
        TreeNode curr = root;
        while(curr != null){
            if(curr.val == key){
                return curr.val;
            }
            if(curr.val > key){
                curr = curr.left;
            }else{
                floor = curr.val;
                curr = curr.right;
            }
        }
        return floor;
    }

    // using the extra space

    public static int floor2(TreeNode root,int key){
        ArrayList<Integer> inorder = inorder(root);

        //Apply binary search
        int start = 0;
        int end  = inorder.size()-1;
        while(start <= end){
            int mid = start +(end-start)/2;
            if(inorder.get(mid)==key){
                return key;
            } else if (inorder.get(mid) > key) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return inorder.get(end);
    }
    public static ArrayList<Integer> inorder(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);

            curr = curr.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = createSampleBST();
        System.out.println(floor(root,34));
        System.out.println(floor2(root,34));
    }

}
