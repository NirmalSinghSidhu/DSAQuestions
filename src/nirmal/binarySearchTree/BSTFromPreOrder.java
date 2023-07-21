package nirmal.binarySearchTree;

public class BSTFromPreOrder {
        private int index;

        public TreeNode constructBST(int[] preorder) {
            index = 0;
            return constructBSTUtil(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode constructBSTUtil(int[] preorder, int minValue, int maxValue) {
            if (index == preorder.length || preorder[index] < minValue || preorder[index] > maxValue) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[index]);
            index++;

            root.left = constructBSTUtil(preorder, minValue, root.val);
            root.right = constructBSTUtil(preorder, root.val, maxValue);

            return root;
        }
        public static void main(String[] args) {
            int[] preorder = {8, 5, 3, 2, 4, 7, 6, 10, 9, 12};

            BSTFromPreOrder bst = new BSTFromPreOrder();
            TreeNode root = bst.constructBST(preorder);
            System.out.println("BST constructed from preorder traversal:");
            printInorder(root);
        }

        private static void printInorder(TreeNode root) {
            if (root != null) {
                printInorder(root.left);
                System.out.print(root.val + " ");
                printInorder(root.right);
            }
        }
    }


//    public static TreeNode constructBST(int[] preOrder){
//        return construct(preOrder,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
//    }
//
//    private static TreeNode construct(int[] preOrder,int index,int min, int max ){
//        if(index == preOrder.length || preOrder[index] < min || preOrder[index] > max){
//            return null;
//        }
//
//        TreeNode root = new TreeNode(preOrder[index]);
//        index++;
//        root.left = construct(preOrder, index, min, root.val);
//        root.right = construct(preOrder, index , root.val, max);
//        return root;
//    }
//
//    public static void main(String[] args) {
//        int[] preorder = {8, 5, 3, 2, 4, 7, 6, 10, 9, 12};
//
//        TreeNode root = constructBST(preorder);
//        System.out.println("BST constructed from preorder traversal:");
//        printInorder(root);
//    }
//
//    private static void printInorder(TreeNode root) {
//        if (root != null) {
//            printInorder(root.left);
//            System.out.print(root.val + " ");
//            printInorder(root.right);
//        }
//    }
//}
