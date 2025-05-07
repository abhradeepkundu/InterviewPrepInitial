package essentials;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class BreadthFirstSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode bt = new TreeNode(5);
		
		bt.left = new TreeNode(16);
		bt.right = new TreeNode(16);
		bt.left.right = new TreeNode(19);
		bt.right.right = new TreeNode(4);
		bt.left.right.left = new TreeNode(2);
		bt.left.right.left.left = new TreeNode(15);
		bt.left.right.left.right = new TreeNode(91);
		bt.left.right.left.right.right = new TreeNode(8);

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
		bfs(bt);
	}
	
	static void bfs(TreeNode root) {
		if(root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.offer(root);
		int level = 0;
		while(!queue.isEmpty()) {
			System.out.println("Current Level ==>" + level);
			int n = queue.size();
			for(int i = 0; i < n; i++) {
				TreeNode curr = queue.poll();
				System.out.print(curr.val + " ");

				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			level++;
			System.out.println();
		}
		
	}

}
