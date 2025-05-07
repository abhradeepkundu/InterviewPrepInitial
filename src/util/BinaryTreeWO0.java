package util;



public class BinaryTreeWO0 {
	
	public class Node {
		Node left;
		Node right;
		int data;
		
		public Node(int d) {
			this.data = d;
		}
	}
	
	public Node createNode(int data) {
		return new Node(data);
	}
	
	public int printWOZero(Node root) {
		if(root == null) return -1;
		
		int left = printWOZero(root.left);
		int right = printWOZero(root.right);
		
		if(left == -1 && right == -1 && root.data != 1) {
			return -1;
		} 
		System.out.print(root.data);
		return 1;
	}
	
	public void normalPrint(Node root) {
		if(root == null) return;
		normalPrint(root.left);
		normalPrint(root.right);
		System.out.print(root.data);
	}

	public static void main(String[] args) {
		BinaryTreeWO0 bt = new BinaryTreeWO0();
		Node root = bt.createNode(1);
		root.left = bt.createNode(0);
		root.right = bt.createNode(0);
		root.left.left = bt.createNode(0);
		root.left.right = bt.createNode(0);
		root.right.left = bt.createNode(1);
		root.right.right = bt.createNode(0);
		root.right.right.left = bt.createNode(0);
		root.right.right.right = bt.createNode(0);
		
		bt.normalPrint(root);
		System.out.println();
		bt.printWOZero(root);

	}

}
