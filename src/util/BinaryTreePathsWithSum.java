package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreePathsWithSum {
    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode(5);
        BinaryTreeNode b = new BinaryTreeNode(16);
        BinaryTreeNode c = new BinaryTreeNode(16);
        BinaryTreeNode d = new BinaryTreeNode(4);
        BinaryTreeNode e = new BinaryTreeNode(19);
        BinaryTreeNode f = new BinaryTreeNode(2);
        BinaryTreeNode g = new BinaryTreeNode(15);
        BinaryTreeNode h = new BinaryTreeNode(91);
        BinaryTreeNode i = new BinaryTreeNode(8);

        BinaryTreeNode root = a;
        a.left = b;
        a.right = c;
        b.right = e;
        c.right = d;
        e.left = f;
        f.left = g;
        f.right = h;
        h.right = i;

        /*
                5
              /   \
            16     16
              \     \
              19     4
              /
             2
            / \
           15  91
                \
                 8
        */

        List<BinaryTreePath> pathsWithSum = getBinaryTreePathsWithSum(root, 21); // 19 => 2 => 91

        System.out.println(Arrays.toString(pathsWithSum.toArray()));
    }

    public static List<BinaryTreePath> getBinaryTreePathsWithSum(BinaryTreeNode root, int sum) {
        if (root == null) {
            throw new IllegalArgumentException("Must pass non-null binary tree!");
        }

        List<BinaryTreePath> paths = new ArrayList<BinaryTreePath>();
        Map<Integer, List<BinaryTreeNode>> cumulativeSumMap = new HashMap<Integer, List<BinaryTreeNode>>();

        populateBinaryTreePathsWithSum(root, 0, cumulativeSumMap, sum, paths);

        return paths;
    }

    private static void populateBinaryTreePathsWithSum(BinaryTreeNode node, int cumulativeSumBeforeNode, Map<Integer, List<BinaryTreeNode>> cumulativeSumMap, int targetSum, List<BinaryTreePath> paths) {
        if (node == null) {
            return;
        }

        addToMap(cumulativeSumMap, cumulativeSumBeforeNode, node);

        int cumulativeSumIncludingNode = cumulativeSumBeforeNode + node.value;
        int sumToFind = cumulativeSumIncludingNode - targetSum;

        if (cumulativeSumMap.containsKey(sumToFind)) {
            List<BinaryTreeNode> candidatePathStartNodes = cumulativeSumMap.get(sumToFind);

            for (BinaryTreeNode pathStartNode : candidatePathStartNodes) {
                paths.add(new BinaryTreePath(pathStartNode, node));
            }
        }

        populateBinaryTreePathsWithSum(node.left, cumulativeSumIncludingNode, cumulativeSumMap, targetSum, paths);
        populateBinaryTreePathsWithSum(node.right, cumulativeSumIncludingNode, cumulativeSumMap, targetSum, paths);

        removeFromMap(cumulativeSumMap, cumulativeSumBeforeNode);
    }

    private static void addToMap(Map<Integer, List<BinaryTreeNode>> cumulativeSumMap, int cumulativeSumBeforeNode, BinaryTreeNode node) {
        if (cumulativeSumMap.containsKey(cumulativeSumBeforeNode)) {
            List<BinaryTreeNode> nodes = cumulativeSumMap.get(cumulativeSumBeforeNode);
            nodes.add(node);
        } else {
            List<BinaryTreeNode> nodes = new ArrayList<BinaryTreeNode>();
            nodes.add(node);
            cumulativeSumMap.put(cumulativeSumBeforeNode, nodes);
        }
    }

    private static void removeFromMap(Map<Integer, List<BinaryTreeNode>> cumulativeSumMap, int cumulativeSumBeforeNode) {
        List<BinaryTreeNode> nodes = cumulativeSumMap.get(cumulativeSumBeforeNode);
        nodes.remove(nodes.size() - 1);
    }

    private static class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public String toString() {
            return this.value + "";
        }

        public int hashCode() {
            return Integer.valueOf(this.value).hashCode();
        }

        public boolean equals(Object other) {
            return this == other;
        }
    }

    private static class BinaryTreePath {
        public BinaryTreeNode start;
        public BinaryTreeNode end;

        public BinaryTreePath(BinaryTreeNode start, BinaryTreeNode end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return this.start + " to " + this.end;
        }
    }
}