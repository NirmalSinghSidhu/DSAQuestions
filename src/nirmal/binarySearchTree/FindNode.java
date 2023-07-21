package nirmal.binarySearchTree;

public class FindNode {

    //Recursive
    public  static boolean find(TreeNode root ,int val){
        if(root == null){
            return false;
        }
        if(root.val > val){
           return find(root.left, val);
        }else if(root.val < val){
           return find(root.right, val);
        }else {
            return true;
        }

    }

    //iterative approach
    public static boolean find2(TreeNode root , int val){
        TreeNode curr = root;
        while(curr!= null){
            if(curr.val == val){
                return true;
            }else if(curr.val > val){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println(find2(root,6));

        System.out.println(find2(root,634));

        System.out.println(find(root,6));

        System.out.println(find(root,688));
    }
}
