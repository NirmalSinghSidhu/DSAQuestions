package nirmal.binarySearchTree;

public class InorderPredecessorSuccessor {
    public static void findInorderPredecessorSuccessor(TreeNode root , int key){
        TreeNode predecessor = null;
        TreeNode successor = null;

        while(root !=  null){
            if (key < root.val) {
                successor = root;
                root = root.left;
            } else if (key > root.val) {
                predecessor = root;
                root = root.right;
            }else{
                if(root.left != null){
                    predecessor = findMax(root.left);
                }
                if(root.right != null){
                    predecessor = findMin(root.right);
                }
                break;
            }
        }


        System.out.println("Predecessor of the given BST is :"+ (predecessor!=null?predecessor.val:"None"));
        System.out.println(" Successor of the given BST is : " + (successor != null ? successor.val : "None"));
    }
    public static TreeNode findMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }
    public static TreeNode findMax(TreeNode root){

        while(root.left != null){
            root = root.left;
        }

        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        findInorderPredecessorSuccessor(root, 4);
    }
}

