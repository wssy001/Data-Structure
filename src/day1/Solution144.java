package day1;

import util.TreeNode;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Solution104
 *
 * @author alexpetertyler
 * @since 2022/5/14
 */
public class Solution144 {
    List<Integer> list = new CopyOnWriteArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }

    void traverse(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.left.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        Solution144 solution144 = new Solution144();
        System.out.println(solution144.preorderTraversal(treeNode).toString());
    }
}
