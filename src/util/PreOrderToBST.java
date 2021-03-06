package util;


class Node1 {
	 
    int data;
    Node1 left, right;
 
    Node1(int d)
    {
        data = d;
        left = right = null;
    }
}
 
class Index {
 
    int index = 0;
}
 
public class PreOrderToBST {
 
    Index index = new Index();
 
    // A recursive function to construct BST from pre[].
    // preIndex is used to keep track of index in pre[].
    Node1 constructTreeUtil(int pre[], Index preIndex,
                           int key, int min, int max,
                           int size)
    {
 
        // Base case
        if (preIndex.index >= size) {
            return null;
        }
 
        Node1 root = null;
 
        // If current element of pre[] is in range, then
        // only it is part of current subtree
        if (key > min && key < max) {
 
            // Allocate memory for root of this
            // subtree and increment *preIndex
            root = new Node1(key);
            preIndex.index = preIndex.index + 1;
 
            if (preIndex.index < size) {
 
                // Construct the subtree under root
                // All nodes which are in range {min .. key}
                // will go in left subtree, and first such
                // node will be root of left subtree.
                root.left = constructTreeUtil(
                    pre, preIndex, pre[preIndex.index], min,
                    key, size);
            }
            if (preIndex.index < size) {
                // All nodes which are in range {key..max}
                // will go in right subtree, and first such
                // node will be root of right subtree.
                root.right = constructTreeUtil(
                    pre, preIndex, pre[preIndex.index], key,
                    max, size);
            }
        }
 
        return root;
    }
 
    // The main function to construct BST from given
    // preorder traversal. This function mainly uses
    // constructTreeUtil()
    Node1 constructTree(int pre[], int size)
    {
        int preIndex = 0;
        return constructTreeUtil(pre, index, pre[0],
                                 Integer.MIN_VALUE,
                                 Integer.MAX_VALUE, size);
    }
 
    // A utility function to print inorder traversal of a
    // Binary Tree
    void printInorder(Node1 node)
    {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
 
    // Driver code
    public static void main(String[] args)
    {
    	PreOrderToBST tree = new PreOrderToBST();
        int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
        int size = pre.length;
 
        // Function call
        Node1 root = tree.constructTree(pre, size);
        System.out.println(
            "Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }
}
