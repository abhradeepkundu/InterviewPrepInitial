package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTree {
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

	public int height(Node nd) {
		if (null == nd) {
			return -1;
		}
		return 1 + Math.max(height(nd.right), height(nd.left));
	}

	public static void main(String[] args) {
//		BinaryTree bt = new BinaryTree();
//		bt.root = bt.createNode(5);
//		bt.root.left = bt.createNode(8);
//		bt.root.left.right = bt.createNode(7);
//		bt.root.left.right.left = bt.createNode(7);
//		bt.root.left.left = bt.createNode(6);
//		bt.root.right = bt.createNode(1);
//		bt.root.right.left = bt.createNode(2);
//		int height = bt.height(bt.root);
//		System.out.println("MINDEPTH:");
//		bt.minDepthIterative(bt.root);
//		bt.levelOrderTraversalNonRecursive(bt.root);
//		int[] path = new int[height + 1];
//		bt.findPath(bt.root, path, 0, 7);
//		System.out.println();
//		String[] pathD = new String[height + 1];
//		bt.findDirection(bt.root, pathD, 0, 7, " ");
//		System.out.println();
//		System.out.println("LCA :" + bt.findLCA(bt.root, 6, 7));
//		bt.topView(bt.root);
//		System.out.println(bt.height(bt.root));
//		System.out.print("LEFTVIEW: ");
//		bt.leftView(bt.root, 0);
//		System.out.println();
//		bt.inorder(bt.root);
//		bt.mirror1(bt.root);
//		System.out.println();
//		bt.inorder(bt.root);
//		System.out.println();
//		bt.levellingNode(bt.root);
//		System.out.println(bt.mirrNode(8, bt.root.right, bt.root.left));
//		System.out.println("HEIGHT" + bt.height(bt.root));
//		Node node = bt.getMirrorNode(bt.root, 8);
//		int data = node != null ? node.data : 0;
//		System.out.println("MIRROR NODE OF 8: " + data);
		BinaryTree bt = new BinaryTree();
		bt.root = bt.createNode(1);
		bt.root.left = bt.createNode(2);
		bt.root.right = bt.createNode(3);
		bt.root.right.left = bt.createNode(4);
		bt.root.right.right = bt.createNode(5);
		List<Integer> nums = new ArrayList<Integer>();
		bt.SerializeRecursively(bt.root, nums );
		System.out.println(nums);
		Node newRt = bt.DeserializeRecursively(nums);
		List<Integer> newnums = new ArrayList<Integer>();
		bt.SerializeRecursively(newRt, newnums );
		System.out.println(newnums);
	}

	private void topView(Node root) {
		Map<Integer, Integer> hdMap = new HashMap<Integer, Integer>();
		hdMap.put(0, root.data);
		parseTree(root, hdMap, 0);
		Integer[] keySet = new Integer[hdMap.keySet().size()];
		hdMap.keySet().toArray(keySet);
		Arrays.sort(keySet);
		for (int i = 0; i < keySet.length; i++) {
			System.out.print(hdMap.get(keySet[i]) + " ");
		}
		System.out.println();
	}

	private static void parseTree(Node root, Map<Integer, Integer> hdMap, int hd) {
		if (null == root)
			return;
		if (hdMap.get(hd) == null)
			hdMap.put(hd, root.data);
		parseTree(root.left, hdMap, hd - 1);
		parseTree(root.right, hdMap, hd + 1);
	}

	private int mirrNode(int i, Node right, Node left) {
		if (null == right || null == left)
			return 0;
		if (i == right.data)
			return left.data;
		if (i == left.data)
			return right.data;
		int data = mirrNode(i, right.right, left.left);
		if (data != 0)
			return data;
		return mirrNode(i, right.left, left.right);
	}
	
	public boolean isMirrorSelf(Node node1, Node node2) {
		if(node1 == null && node2 == null) {
			return true;
		}
		if(node1 != null && node2 != null && node1.data == node2.data) {
			return isMirrorSelf(node1.left, node2.right) && isMirrorSelf(node1.right, node2.left);
		}
		return false;
	}

	public void inorder(Node root) {
		if (null == root) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + ",");
		inorder(root.right);
	}

	public void mirror(Node root) {
		if (null == root) {
			return;
		}
		Node t = root.left;
		root.left = root.right;
		root.right = t;
		mirror(root.left);
		mirror(root.right);
	}

	public Node mirror1(Node root) {
		if (null == root) {
			return root;
		}
		Node t = root.left;
		root.left = mirror1(root.right);
		root.right = mirror1(t);

		return root;
	}

	public void levellingNode(Node root) {
		Map<Integer, ArrayList<Integer>> levelNodes = new HashMap<Integer, ArrayList<Integer>>();
		getLevelNodes(root, levelNodes, 0);
		System.out.println();
		System.out.println(levelNodes);
	}

	private void getLevelNodes(Node root, Map<Integer, ArrayList<Integer>> levelNodes, int level) {

		if (null == root)
			return;
		System.out.print("level: " + level + " Data: " + root.data + "|");
		if (levelNodes.containsKey(level)) {
			ArrayList<Integer> list = levelNodes.get(level);
			list.add(root.data);
		} else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(root.data);
			levelNodes.put(level, list);
		}
		getLevelNodes(root.left, levelNodes, (level + 1));
		getLevelNodes(root.right, levelNodes, (level + 1));
	}

	int LEVEL = 0;

	private void leftView(Node root, int level) {
		if (null == root)
			return;
		if (LEVEL < level || level == 0) {
			System.out.print(root.data);
			LEVEL = level;
		}
		leftView(root.left, level + 1);
		leftView(root.right, level + 1);
	}

	private Node getMirrorNode(Node root, int data) {
		if (data == root.data)
			return root;
		return (getMirrorNode(root.left, root.right, data));

	}

	private Node getMirrorNode(Node left, Node right, int data) {
		if (null == left || null == right)
			return null;
		if (data == left.data)
			return right;
		if (data == right.data)
			return left;

		Node node = getMirrorNode(left.left, right.right, data);
		if (null != node)
			return node;
		return getMirrorNode(left.right, right.left, data);
	}

	Node findLCA(Node node, int n1, int n2) {
		// Base case
		if (node == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (node.data == n1 || node.data == n2)
			return node;

		// Look for keys in left and right subtrees
		Node left_lca = findLCA(node.left, n1, n2);
		Node right_lca = findLCA(node.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca != null && right_lca != null)
			return node;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	void findPath(Node root, int[] path, int level, int srNode) {
		if (null == root)
			return;
		path[level] = root.data;
		int count = 0;
		if (root.data == srNode) {
			for (int i : path) {
				if (count > level)
					break;
				count++;
				System.out.print(i + ",");
			}
		}
		findPath(root.left, path, level + 1, srNode);
		findPath(root.right, path, level + 1, srNode);
	}

	void findDirection(Node root, String[] path, int level, int srNode, String dir) {
		if (null == root)
			return;
		path[level] = dir;
		int count = 0;
		if (root.data == srNode) {
			for (String i : path) {
				if (count > level)
					break;
				count++;
				System.out.print(i + ",");
			}
		}
		findDirection(root.left, path, level + 1, srNode, "left");
		findDirection(root.right, path, level + 1, srNode, "right");
	}

	private void SerializeRecursively(Node node, List<Integer> nums) {
		if (node == null) {
			nums.add(-1);
			return;
		}

		nums.add(node.data);
		SerializeRecursively(node.left, nums);
		SerializeRecursively(node.right, nums);
	}

	int index = 0;

	private Node DeserializeRecursively(List<Integer> serializedNums) {
		if (index >= serializedNums.size() || serializedNums.get(index) == -1) {
			index += 1;
			return null;
		}
		int num = serializedNums.get(index);
		Node node = new Node(num);
		index += 1;

		node.left = DeserializeRecursively(serializedNums);
		node.right = DeserializeRecursively(serializedNums);

		return node;
	}

	private static final class Pair {
		Node node;
		int startIndex;

		private Pair(Node node, int index) {
			this.node = node;
			this.startIndex = index;
		}
	}

	public void minDepthIterative(Node root) {
		if (null == root)
			return;
		Queue<Node> q = new LinkedList<Node>();
		int level = 1;
		boolean done = false;
		q.add(root);
		while (true) {
			int size = q.size();
			while (size > 0) {
				Node node = q.poll();
				if (node.left == null && node.right == null) {
					done = true;
					break;
				}
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
				size--;
			}
			if (done)
				break;
			level++;
		}
		System.out.println(level);
	}

	public int minDepthRecur(Node root) {
		if (null == root)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		if (root.left == null)
			return minDepthRecur(root.right) + 1;

		if (root.right == null)
			return minDepthRecur(root.left) + 1;

		return Math.min(minDepthRecur(root.left), minDepthRecur(root.right)) + 1;
	}

	int diameter(Node root) {
		/* base case if tree is empty */
		if (root == null)
			return 0;

		/* get the height of left and right sub trees */
		int lheight = height(root.left);
		int rheight = height(root.right);

		/* get the diameter of left and right subtrees */
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter of
		 * right subtree 3) Height of left subtree + height of right subtree + 1
		 */
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));

	}

	void levelOrderTraversalNonRecursive(Node root) {
		System.out.println("LEVEL ORDER NON-RECURSIVE");
		if (null == root)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int level = 0;
		while (!q.isEmpty()) {
			System.out.println("level>" + level);
			int size = q.size();
			while (size > 0) {
				Node nd = q.poll();
				System.out.print(nd.data + ",");
				if (null != nd.left)
					q.add(nd.left);
				if (null != nd.right)
					q.add(nd.right);
				size--;
			}
			level++;
			System.out.println();
		}
	}
	
	void rootToLeafSum(Node root) {
		System.out.println(rootToLEafRec(root, 0));
	}
	
	int rootToLEafRec(Node root, int val) {
		if(root == null) return 0;
		
		val = (val * 10) + root.data;
		
		if(root.left == null && root.right == null) {
			return val;
		}
		
		return rootToLEafRec(root.left, val) + rootToLEafRec(root.right, val);
	}
	
	
 
}
