package util;

public class BTPathsWithSumFromRoot {
	public class Node {
		public Node left;
		public Node right;
		public int data;

		public Node(int d) {
			this.data = d;
		}
	}

	private Node root;

	public Node createNode(int data) {
		return new Node(data);
	}

	public void treePath(Node root, int[] path, int pathSum, int sum, int level) {
		if (null == root)
			return;

		path[level] = root.data;

		pathSum += root.data;
		if (sum == pathSum) {
			print(path, 0, level);
		}

		treePath(root.left, path, pathSum, sum, level + 1);
		treePath(root.right, path, pathSum, sum, level + 1);

		// path[level] = Integer.MIN_VALUE;

	}

	public void print(int[] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(path[i] + ",");
		}
		System.out.println();
	}

	public void findPath(Node root, int sum) {
		int[] path = new int[depth(root)];
		treePath(root, path, 0, sum, 0);

	}

	public int depth(Node root) {
		if (null == root)
			return 0;

		return 1 + Math.max(depth(root.left), depth(root.right));

	}

	public static void main(String[] args) {
		BTPathsWithSumFromRoot bt = new BTPathsWithSumFromRoot();
		bt.root = bt.createNode(5);
		bt.root.left = bt.createNode(1000);
		bt.root.right = bt.createNode(200);
		bt.root.left.left = bt.createNode(-1);
		// bt.root.right.right = bt.createNode(4);
		// bt.root.left.right.left = bt.createNode(2);
		// bt.root.left.right.left.left = bt.createNode(15);
		// bt.root.left.right.left.right = bt.createNode(91);
		// bt.root.left.right.left.right.right = bt.createNode(8);

		/*
		 * 5 / \ 16 16 \ \ 19 4 / 2 / \ 15 91 \ 8
		 */

		// List<BinaryTreePath> pathsWithSum = getBinaryTreePathsWithSum(root,
		// 21); // 19 => 2 => 91
		bt.findPath(bt.root, 1000);
		System.out.println(bt.hasPathSum(bt.root, 1000));
		// System.out.println(bt.depth(bt.root));
	}

	public int hasPathSum(Node A, int B) {
		System.out.println("Inside new");
		return hasPathSum(A, B, 0);
	}

	public int hasPathSum(Node A, int sum, int sumPath) {

		if (null == A)
			return 0;

		sumPath += A.data;

		if (sum == sumPath)
			return 1;

		int l = hasPathSum(A.left, sum, sumPath);
		if (l == 0) {
			return hasPathSum(A.right, sum, sumPath);
		} else {
			return 1;
		}

	}
}
