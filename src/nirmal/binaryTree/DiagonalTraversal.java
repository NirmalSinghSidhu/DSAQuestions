package nirmal.binaryTree;

import java.util.*;

import static nirmal.binaryTree.BinaryTree.createTree;

public class DiagonalTraversal {

    //recursive solution

    public static List<Integer> diagonalTraversal(TreeNode root){
        List<Integer> ans  = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Map<Integer,List<Integer>> map = new HashMap<>();

        diagonalHelper(root,0,map);

        for(int i = 0; i< map.size(); i++){
            ans.addAll(map.get(i));
        }
        return ans;
    }

    private static void diagonalHelper(TreeNode node ,int level,Map<Integer,List<Integer>> map){
        if(node == null){
            return;
        }
        List<Integer> valuesAtLevel = map.getOrDefault(level,new ArrayList<>());
        valuesAtLevel.add(node.data);

        map.put(level,valuesAtLevel);
        diagonalHelper(node.left,level+1,map);
        diagonalHelper(node.right,level,map);
    }

    //Iterative

    public static List<Integer> diagonal2(TreeNode root){
        List<Integer> ans  = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            while (node!=null){
                ans.add(node.data);
                if(node.left !=null){
                    queue.offer(node.left);
                }
                node = node.right;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println(diagonal2(root));
        System.out.println(diagonalTraversal(root));
    }
}
