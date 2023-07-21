package nirmal.binarySearchTree;


import java.util.ArrayList;

import static nirmal.binarySearchTree.BinarySearchTree.createSampleBST;
import static nirmal.binarySearchTree.Floor.inorder;

public class Ceil {
    public static int ceil(TreeNode root, int key){
        int ceil  = Integer.MIN_VALUE;
        TreeNode curr = root;
        while(curr != null){
            if(curr.val == key){
                return curr.val;
            }
            if(curr.val < key){
                curr = curr.right;
            }else{
                ceil = curr.val;
                curr = curr.left;
            }
        }
        return ceil;
    }

    public static int ceil2(TreeNode root, int key){
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

        return inorder.get(start);
    }

    public static void main(String[] args) {
        TreeNode root = createSampleBST();
        System.out.println(ceil(root,45));
        System.out.println(ceil2(root,45));
    }
}
