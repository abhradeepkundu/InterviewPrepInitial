package util;


public class PrintLinkedListinReverse {
	class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	public void printReverse(Node root) {
		if(null == root) return;
		printReverse(root.next);
		System.out.println(root.data);
	}
	
	Node createNode(int data) {
		return new Node(data);
	}
	
	public static void main(String[] args) {
		PrintLinkedListinReverse pr = new PrintLinkedListinReverse();
		Node head = pr.createNode(5);
		head.next = pr.createNode(2);
		head.next.next = pr.createNode(4);
		head.next.next.next = pr.createNode(8);
		pr.printReverse(head);
		
	}

}
