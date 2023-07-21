package nirmal.binarySearchTree;

public class isBST {
    private static TreeNode prev = null;
    public static boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }

        if(prev != null && root.val <= prev.val){
            return false;
        }
        prev = root;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);


        System.out.println(isValidBST(root));
    }
}
