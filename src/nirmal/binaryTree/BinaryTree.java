package nirmal.binaryTree;

public class BinaryTree {
    public static TreeNode createTree(){
        TreeNode node1 =  new TreeNode(1);
        TreeNode node2 =  new TreeNode(2);
        TreeNode node3 =  new TreeNode(3);
        TreeNode node4 =  new TreeNode(4);
        TreeNode node5 =  new TreeNode(5);
        TreeNode node6 =  new TreeNode(6);
        TreeNode node7 =  new TreeNode(7);
        TreeNode node8 =  new TreeNode(8);
        TreeNode node9 =  new TreeNode(9);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        return node1;
    }

    public static void display(TreeNode node , int level){
        if(node == null){
            return;
        }

        display(node.right, level+1);
        if(level != 0){
            for(int i = 0; i<level -1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------>"+node.data);
        }else{
            System.out.println(node.data);
        }
        display(node.left,level+1);
    }
}
