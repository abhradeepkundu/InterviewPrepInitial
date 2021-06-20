package util;

public class BinarySearchTree {
	private class Node {
		public Node left;
		public Node right;
		public int data;

		public Node(int d) {
			this.data = d;
		}
		@Override
		public String toString() {
			return ""+data;
		}
	}
	
	private Node root;
	
//	public Node insert(Node nd, int data) {
//		if(null == nd) {
//			return new Node(data);
//		}
//		if(data >= nd.data) {
//			nd.right = insert(nd.right, data);
//		}
//		else  {
//			nd.left = insert(nd.left, data);
//		}
//		return nd;
//	}
	
	public Node insert(Node nd, int data) {
		Node nwNd = null;
		if(null == nd) {
			return new Node(data);
		}
		if(data >= nd.data) {
			if(nd.right == null) {
				nwNd = new Node(data);
				nd.right = nwNd;
				return nwNd;
			}
			return insert(nd.right, data);
		} else {
			if(nd.left == null) {
				nwNd = new Node(data);
				nd.left = nwNd;
				return nwNd;
			}
			return insert(nd.left, data);
		}
	}

	int i = 0;

	public void kThMax(int k) {
		int data = kThMax(k, root);
		System.out.println("K th MAX:"+data);
	}

	public int kThMax(int k,  Node nd) {

		if(null == nd || i>=k) {
			return 0;
		}
		int data = kThMax(k, nd.right);
		i++;
		if (k == i) {
			//System.out.println(nd.data);
			return nd.data;
		}
		if(data == 0) {
			return kThMax(k, nd.left);
		} 
		return data;
	}
	
	//Node succ = null;
	boolean foundNode = false;
	public Node getSuccessor( Node a, int b) {
		
		if (null == a)
			return null;
		Node left = getSuccessor(a.left, b);
		if (foundNode) {
			foundNode = false;
			return a;
		}
		if (a.data == b)
			foundNode = true;
		if (null == left) {
			return getSuccessor(a.right, b);
		} else {
			return left;
		}
	}
	
	public void inorder(Node root) {
		if(null == root) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + "|" );
		inorder(root.right);
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Node root = tree.insert(null, 50);
		tree.root = root;
		System.out.println(tree.insert(root, 30));
		tree.insert(root, 20);
		tree.insert(root, 40);
		System.out.println(tree.insert(root, 70));
		tree.insert(root, 60);
		System.out.println(tree.insert(root, 80));
		System.out.println();
		//System.out.println(tree.root.data);
		//System.out.println(tree.root.left.data);
		tree.inorder(root);
		
		tree.kThMax(7);
		Node succ = tree.getSuccessor(tree.root, 30);
		System.out.println();
		System.out.println(succ.data);
		//System.out.println(tree.kThMAx);
	}
	
	int countWithinRange(Node root, int small, int big) {
		if(root == null) return 0;
		
		if(root.data >= small && root.data <= big) {
			return 1+ countWithinRange(root.left, small, big) +
			countWithinRange(root.right, small, big);
		} else if(root.data < small) {
			return countWithinRange(root.right, small, big);
		} else {
			return countWithinRange(root.left, small, big);
		}
	}

}
