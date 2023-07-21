package nirmal.binarySearchTree;

public class Maximum {
    public static int findMax(TreeNode root){
        if(root ==  null){
            return -1;
        }
        while(root.right != null){
            root = root.right;
        }

        return root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println(findMax(root));
    }
}
