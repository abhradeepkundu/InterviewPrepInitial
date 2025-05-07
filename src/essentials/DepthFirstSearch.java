package essentials;


//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int val) {
//		this.val = val;
//	}
//}
public class DepthFirstSearch {
	


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
		dfs(bt);
	}
	static int level = 0;
	private static void dfs(TreeNode root) {
		if(root == null) {
			System.out.println();
			System.out.println("Finished printing level ==>" + level++);
			return;
		}
		System.out.print(root.val +  " ");
		dfs(root.left);
		dfs(root.right);
		
	}

}
