package util;

public class BTPathsWithSum {
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

	public void treePath(Node root, int[] path, int level, int sum) {
		if (null == root)
			return;

		path[level] = root.data;

		int pathSum = 0;
		for (int i = level; i >= 0; i--) {
			pathSum += path[i];
			if (sum == pathSum) {
				print(path, i, level);
			}
		}

		treePath(root.left, path, level + 1, sum);
		treePath(root.right, path, level + 1, sum);

		//path[level] = Integer.MIN_VALUE;

	}

	public void print(int[] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(path[i] + ",");
		}
		System.out.println();
	}

	public void findPath(Node root, int sum) {
		int[] path = new int[depth(root)];
		treePath(root, path, 0, sum);

	}

	public int depth(Node root) {
		if (null == root)
			return 0;

		return 1 + Math.max(depth(root.left), depth(root.right));

	}

	public static void main(String[] args) {
		BTPathsWithSum bt = new BTPathsWithSum();
		bt.root = bt.createNode(5);
		bt.root.left = bt.createNode(16);
		bt.root.right = bt.createNode(16);
		bt.root.left.right = bt.createNode(19);
		bt.root.right.right = bt.createNode(4);
		bt.root.left.right.left = bt.createNode(2);
		bt.root.left.right.left.left = bt.createNode(15);
		bt.root.left.right.left.right = bt.createNode(91);
		bt.root.left.right.left.right.right = bt.createNode(8);

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

		// List<BinaryTreePath> pathsWithSum = getBinaryTreePathsWithSum(root,
		// 21); // 19 => 2 => 91
		bt.findPath(bt.root, 21);
	}

}
