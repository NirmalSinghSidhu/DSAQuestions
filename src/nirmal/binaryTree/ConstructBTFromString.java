package nirmal.binaryTree;

import static nirmal.binaryTree.LevelOrderTraversal.levelOrder2;

public class ConstructBTFromString {
    public static TreeNode constructTreeFromString(String s) {
        int[] index = new int[]{0};
        return constructTree(s.toCharArray(), index);
    }

    private static TreeNode constructTree(char[] chars, int[] index) {
        if (index[0] >= chars.length || chars[index[0]] == ')') {
            return null;
        }

        TreeNode node = new TreeNode(chars[index[0]]);
        index[0]++;

        if (index[0] < chars.length && chars[index[0]] == '(') {
            index[0]++;
            node.left = constructTree(chars, index);
        }

        if (index[0] < chars.length && chars[index[0]] == '(') {
            index[0]++;
            node.right = constructTree(chars, index);
        }

        index[0]++;

        return node;
    }
    public static void main(String[] args) {
        TreeNode root = constructTreeFromString("1(2(4)(5))(3(6)(7))");
        levelOrder2(root);
    }
}
