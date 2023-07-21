package nirmal.binarySearchTree;

public class CountNodesInRange {

    public static int countNodesInGivenRange(TreeNode root, int low , int high){
        if(root == null){
            return 0;
        }

        if(root.val < low){
            return  countNodesInGivenRange(root.right,low,high);
        }

        if(root.val > high){
            return countNodesInGivenRange(root.left,low,high);
        }

        return 1 + countNodesInGivenRange(root.left,low,high) + countNodesInGivenRange(root.right,low,high);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int count = countNodesInGivenRange(root, 3, 7);
        System.out.println("Count of Nodes in the Given Range: " + count);
    }
}
