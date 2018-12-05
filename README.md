# CS49J:	Section 2, Fall 2015
# Program #3:	Binary Search Tree (100 Points)
Due Date:	Nov 24, 2015

### Description:

You are responsible to implement the binary tree algorithms in Java.  This BST class should have bst_insert(), bst_delete() and bst_search() method in addition to the default BST constructor.  You need to implement the bst_inorder() and bst_preorder() methods to traverse the tree.  After the whole tree is constructed, you will call both the inorder and preorder methods to display it’s content.  You are given 2 sample test data file that you can redirect from the command line when you run your program.  For delete and search, you need to return the ID (position) of the string if found, return 0 if not found.  Print out the result from your p3 main() method.

```java
Program Specification:

class Node{
	int ID;                       /* the original position of the data starting from 1 */
	String data;
	Node left;
	Node right;
	public Node(string data, int ID){
		this.data = new String(data);
		this.ID = ID;
		left = null;
		right = null;
	}
}

public class BST {
	public static Node root;
	public BST(){
		this.root = null;
	}
…
}
```

### Additional Information:

You data file starts with a list of names which ends when the string “NULL” is detected.  Afterward, you will read the next character as the Action (D = Delete; S = Search) followed by the token string.
You need to handle 3 different scenarios for bst_delete()
1.  The node you found has no children.
     Detach itself from the tree and you are done.
2.  The node you found has 1 child.
     Connect the child pointer to your parent pointer.
3.  The node you found has 2 children.
     Detach and replace the current node with the smallest value node from the right child node.
     There are 3 scenarios here as well after finding the leftmost node from right child:
     a) no grandchildren
     b) 1 grandchild
     c) more than 1 grandchildren
     Depending on the path, you will have to attach and detach more pointer links in the tree.
4.  Able to handle deletion of the root node.

Program Checklist:

You will submit a zip file contain all your source files (e.g. p3.java, BST.java, Node.java, …).
