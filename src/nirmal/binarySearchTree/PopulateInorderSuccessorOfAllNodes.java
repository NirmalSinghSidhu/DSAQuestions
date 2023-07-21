package nirmal.binarySearchTree;

public class PopulateInorderSuccessorOfAllNodes {
    private static TreeNode successor;

    public static void populateInorderSuccessor(TreeNode root) {
        successor = null;
        populateSuccessorUtil(root);
    }

    private  static void populateSuccessorUtil(TreeNode root) {
        if (root == null) {
            return;
        }

        populateSuccessorUtil(root.right);

        root.next = successor;
        successor = root;

        populateSuccessorUtil(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);


        populateInorderSuccessor(root);

        System.out.println("Inorder Successors:");
        printInorderSuccessors(root);
    }

    private static void printInorderSuccessors(TreeNode root) {
        while (root != null) {
            System.out.println(root.val + ": " + (root.next != null ? root.next.val : "None"));
            root = root.next;
        }
    }
}
