package day1;

import util.TreeNode;

/**
 * Solution104
 *
 * @author alexpetertyler
 * @since 2022/5/14
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth, rightDepth;
        leftDepth = maxDepth(root.left);
        rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        Solution104 solution104 = new Solution104();
        System.out.println(solution104.maxDepth(treeNode));
    }
}
