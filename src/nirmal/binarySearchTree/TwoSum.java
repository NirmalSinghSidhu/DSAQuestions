package nirmal.binarySearchTree;

import java.util.*;

import static nirmal.binarySearchTree.BinarySearchTree.createSampleBST;
import static nirmal.binarySearchTree.Floor.inorder;

public class TwoSum {
    public static ArrayList<ArrayList<Integer>> twoSum(TreeNode root , int sum){
        if(root == null){
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(set.contains((sum- curr.val))){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(curr.val);
                ans.add(sum- curr.val);
                result.add(ans);
            }
            set.add(curr.val);

            if(curr.left != null){
                q.add(curr.left);
            }

            if(curr.right != null){
                q.add(curr.right);
            }
        }
        return result;
    }

    //Recursive
    public static boolean isPairPresent(TreeNode root, int target){
        Set<Integer> set = new HashSet<>();
        return utilL(root,target,set);
    }

    private static boolean utilL(TreeNode root, int target, Set<Integer> set) {
       if(root == null) return false;

       if(utilL(root.left, target, set)){
           return true;
       }

       if(set.contains(target-root.val)){
           return true;
       }
       set.add(root.val);
       return utilL(root.right, target, set);
    }


    //inorder Traversal method

    public static ArrayList<ArrayList<Integer>> twoSum2(TreeNode root, int target){
        ArrayList<Integer> inorder = inorder(root);

        //apply two pointer approach
        int left = 0;
        int right = inorder.size()-1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while(left < right){
            int sum = inorder.get(left)+inorder.get(right);
            if(sum == target){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(inorder.get(left));
                ans.add(inorder.get(right));
                result.add(ans);
                left++;
                right--;
            }
            else if(sum > target){
                right--;
            }else{
                left++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = createSampleBST();
        System.out.println(twoSum(root,50));
        System.out.println(twoSum(root,50));
        System.out.println(isPairPresent(root,46655));
    }
}
