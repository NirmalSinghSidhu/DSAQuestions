package nirmal.binarySearchTree;

public class BinarySearchTree {

    public static TreeNode createSampleBST(){
       int arr[] = {60,70,80,40,50,90};
      TreeNode root = new TreeNode(10);
      for(int elm:arr){
          insert(root,elm);
      }
      return root;
    }
    public static TreeNode insert( TreeNode root,int data){
        TreeNode newNode = new TreeNode(data);
        if(root == null){
            return newNode;
        }

        TreeNode curr = root;
        TreeNode parent = null;
        while(curr!= null){
            parent = curr;
            if(curr.element < data){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        if(parent.element < data){
            parent.right = newNode;
        }else{
            parent.left = newNode;
        }
        return root;
    }

    public static TreeNode insert2(TreeNode root,int data){
        if(root ==  null){
            return new TreeNode(data);
        }

        if(root.element < data){
          root.right = insert2(root.right,data);
        }else{
           root.left = insert2(root.left, data);
        }
        return root;
    }

    public static TreeNode delete(TreeNode root, int key){
        if(root == null){
            return root;
        }

        if(root.element > key){
            root.left = delete(root.left,key);
        } else if (root.element < key) {
            root.right = delete(root.right,key);
        }
        else {
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }else{
                root.element = minValue(root.right);
                root.right = delete(root.right, root.element);
            }
        }
        return root;
    }

    public static int minValue(TreeNode root){
        int minValue = root.element;
        while(root != null){
           minValue  = root.element;
           root = root.left;
        }
        return minValue;
    }



    //printing in the order

    public static void print(TreeNode root){
        if(root == null){
            return;
        }
        print(root.left);
        System.out.print(root.element +" ");
        print(root.right);
    }

    public static void main(String[] args) {
//        TreeNode root = insert(null,34);
//        insert(root,12);
//        insert(root,21);
//        insert(root,10);
//        insert(root,45);
//        insert(root,39);
//        insert(root,90);
//        insert(root,17);

//        print(root);

        TreeNode treeNode = createSampleBST();
        treeNode =insert(treeNode,45);
        treeNode =insert(treeNode,100);
        treeNode =insert(treeNode,8);
        print(treeNode);
        System.out.println();
//        System.out.println(minValue(treeNode));
        treeNode = delete(treeNode,40);
        treeNode = delete(treeNode,60);
        print(treeNode);
    }
}
