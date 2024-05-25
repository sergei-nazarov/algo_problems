package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBinarySearchTreesII_93 {
    Map<String, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int bottom, int upper) {
        String key = STR."\{bottom}-\{upper}";
        if (memo.containsKey(key)) return memo.get(key);
        if (bottom > upper) return new ArrayList<>() {{
            add(null);
        }};
        ArrayList<TreeNode> result = new ArrayList<>();
        for (int i = bottom; i <= upper; i++) {
            List<TreeNode> left = helper(bottom, i - 1);
            List<TreeNode> right = helper(i + 1, upper);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i, l, r);
                    result.add(root);
                }
            }
        }
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        new UniqueBinarySearchTreesII_93().generateTrees(6).forEach(TreeNode::printTree);
    }
}