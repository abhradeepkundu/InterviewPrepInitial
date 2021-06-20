package util;

public class IncorrectBST {
	private class Node {
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

	public void inorder(Node rt) {
		if (null != rt) {
			inorder(rt.left);
			System.out.print(rt.data + ",");

			inorder(rt.right);
		}
	}

	Node firstWrong = null;
	Node secondWrong = null;
	Node prevNode = null;
	Node middleNode = null;

	public void findIncorrectNode(Node rt) {
		if (null != rt) {
			findIncorrectNode(rt.left);
			if (prevNode != null && prevNode.data > rt.data) {
				if (firstWrong == null) {
					firstWrong = prevNode;
					middleNode = rt;
				}
				secondWrong = rt;
			}

			prevNode = rt;
			findIncorrectNode(rt.right);
		}
	}

	private void correctNode() {
		if (null != firstWrong && null != secondWrong) {
			int temp = firstWrong.data;
			firstWrong.data = secondWrong.data;
			secondWrong.data = temp;
		}
		// else {
		// int temp = firstWrong.data;
		// firstWrong.data = middleNode.data;
		// middleNode.data = temp;
		// }

	}

	Node prev = null;

	public int isValidBST(Node A) {
		if (A != null) {
			int left = isValidBST(A.left);
			if (prev != null && prev.data > A.data) {
				return 0;
			}
			prev = A;
			if (left == 1) {
				return isValidBST(A.right);
			} else {
				return 0;
			}
		}
		return 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 IncorrectBST tree = new IncorrectBST();
		 Node root = tree.createNode(50);
		 tree.root = root;
		 tree.root.left = tree.createNode(30);
		 tree.root.right = tree.createNode(60);
		 tree.root.right.right = tree.createNode(65);
		 tree.root.right.left = tree.createNode(70);
		 tree.root.left.left = tree.createNode(20);
		 tree.root.left.right = tree.createNode(40);
		
		 tree.inorder(root);
		 System.out.println();
		 tree.findIncorrectNode(root);
		 System.out.println();
		 System.out.println(tree.firstWrong.data);
		 System.out.println(tree.secondWrong.data);
		 tree.correctNode();
		 tree.inorder(root);
//		IncorrectBST tree = new IncorrectBST();
//		Node root = tree.createNode(1);
//		tree.root = root; 
//		root.left = tree.createNode(1);
//		root.right = tree.createNode(3);
//		root.left.left = tree.createNode(2);
//		root.left.right = tree.createNode(4);
//		root.right.left = tree.createNode(1);
//		root.right.right = tree.createNode(3);
//		tree.inorder(tree.root);
//		int val = tree.isValidBST(root);
//		System.out.println();
//		System.out.println(val);
	}

}
