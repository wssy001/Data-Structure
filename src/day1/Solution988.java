package day1;

import util.TreeNode;

/**
 * Solution988
 *
 * @author alexpetertyler
 * @since 2022/5/14
 */
public class Solution988 {
    String result = "~";

    //    思路：
    //        使用DFS算法，获取所有路径
    //        自定义排序，将路径逆序，按字典序排列
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuffer());
        return result;
    }

    private void dfs(TreeNode node, StringBuffer stringBuffer) {
        if (node == null) return;
        stringBuffer.append((char) ('a' + node.val));
        if (node.left == null && node.right == null) {
            stringBuffer.reverse();
            String temp = stringBuffer.toString();
            stringBuffer.reverse();
            if (result.compareTo(temp) > 0) result = temp;
        }

        dfs(node.left, stringBuffer);
        dfs(node.right, stringBuffer);
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.listToTree("[0,1,2,3,4,3,4]");
        Solution988 solution988 = new Solution988();
        System.out.println(solution988.smallestFromLeaf(root));
    }
}
