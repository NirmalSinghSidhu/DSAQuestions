package nirmal.binarySearchTree;

import java.util.*;

public class VerticalTraversal {
    public static class Pair{
        int hd ;
        TreeNode root;
        public Pair(int hd,TreeNode root){
            this.hd= hd;
            this.root= root;
        }
    }
    public static ArrayList<Integer> verticalTraversal(TreeNode root){

        Queue<Pair> queue = new ArrayDeque<>();
        Pair pair = new Pair(0,root);
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(0,root));
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            if(map.containsKey(curr.hd)){
                map.get(curr.hd).add(curr.root.val);
            }else{
               ArrayList<Integer> ans = new ArrayList<>();
               ans.add(curr.root.val);
               map.put(curr.hd,ans);
            }

            if(curr.root.left != null){
                queue.add(new Pair(curr.hd-1,curr.root.left));
            }

            if(curr.root.right != null){
                queue.add(new Pair(curr.hd+1,curr.root.right));
            }
        }
         ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
            ans.addAll(entry.getValue());
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(20);//root node
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(30);
        TreeNode node4 = new TreeNode(50);
        TreeNode node5 = new TreeNode(60);
        TreeNode node6 = new TreeNode(40);

        node1.left = node2;
        node1.right = node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node6;

        ArrayList<Integer> ans = verticalTraversal(node1);
        System.out.println(ans);

    }
}
