
public class BST
{
    public static Node root;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        // Program
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    // Specification
    private int        id;

    public BST ()
    {
        root = null;           // Program Specification
        id = 1;
    }

    public void bst_insert (String data)
    {
        if (root == null)                       // No root
        {
            root = new Node (data, id);         // so make one

            System.out.println ("Root: " + root.data + " id: " + id);
        }

        else
        {
            bst_insert (data, root);
        }

        id++;
    }

    // Recursive insertion of an object
    public void bst_insert (String data, Node node)
    {
        int comparison = node.data.compareTo (data);
        if (comparison == 0)
        {
            // If it is equal to the current node just increment the count
            ++node.id;
            return;
        }
        if (comparison > 0)
        {
            // If it's less than the current node
            if (node.small == null)
            {
                // and the left child node is null
                node.small = new Node (data, id);
                // Store it as the left child node

                // System.out.println (data + " is located " + node.data + "'s"
                // + " small Pointer");

            }
            else
            {

                // Otherwise...call add() again at the left node
                bst_insert (data, node.small);
                // System.out.println (data + " is located " + node.data + "'s "
                // + " small Pointer");
            }

        }
        else
        {
            // It must be greater than the current node
            if (node.large == null)
            {
                // so it must go to the right...
                node.large = new Node (data, id);
                // store it as the right node

                // System.out.println (data + " is located " + node.data + "'s "
                // + " large Pointer");

            }
            else
            {

                // ...or when right node is not null
                bst_insert (data, node.large);
                // ...call add() again at the right node

                // System.out.println (data + " is located " + node.data + "'s"
                // + " large Pointer");
            }
        }
    }

    public void insert (Node parent, Node child)
    {
        int comparison = parent.data.compareTo (child.data);
        if (comparison == 0)
        {
            // If it is equal to the current node just increment the count
            System.out.println ("Unexpected Result from bst_insert. ");
            return;
        }

        if (comparison > 0)
        {
            // If it's less than the current node
            if (parent.small == null)
            {
                // and the left child node is null
                parent.small = child;
                // Store it as the left child node

                // System.out.println (data + " is located " + node.data + "'s"
                // + " small Pointer");
            }
            else
            {
                // Otherwise...call add() again at the left node
                insert (parent.small, child);
                // System.out.println (data + " is located " + node.data + "'s "
                // + " small Pointer");
            }
        }
        else
        {
            // It must be greater than the current node
            if (parent.large == null)
            {
                // so it must go to the right...
                parent.large = child;
                // store it as the right node

                // System.out.println (data + " is located " + node.data + "'s "
                // + " large Pointer");

            }
            else
            {

                // ...or when right node is not null
                insert (parent.large, child);
                // ...call add() again at the right node

                // System.out.println (data + " is located " + node.data + "'s"
                // + " large Pointer");
            }
        }
    }

    public void nodeConnector (Node parentNode, Node deleteNode, boolean isSmall)
    {
        Node small = deleteNode.small;
        Node large = deleteNode.large;

        if (deleteNode == root)
        {
            root = small != null ? small : large;

            if (small != null && large != null)
            {
                insert (small, large);
            }
            else if (large != null && small != null)
            {
                insert (large, small);
            }

            return;
        }

        if (isSmall)
        {
            parentNode.small = null;
        }
        else
        {
            parentNode.large = null;
        }

        if (small != null)
        {
            // nodeConnector (parentNode, small, isSmall);
            // bst_insert (small.data, parentNode);
            insert (parentNode, small);
        }

        if (large != null)
        {
            // nodeConnector (parentNode, large, isSmall);
            // bst_insert (large.data, parentNode);
            insert (parentNode, large);
        }

    }

    public void delete (String data)
    {
        // System.out.println ("Name to delete: ");
        // String data = consoleReader.readLine ();
        bst_delete (data, root);
        inorder ();

    }

    public void bst_delete (String data, Node node)
    /*
     * You need to handle 3 different scenarios for bst_delete()
     * 1. The node you found has no children.
     * Detach itself from the tree and you are done.
     * 2. The node you found has 1 child.
     * Connect the child pointer to your parent pointer.
     * 3. The node you found has 2 children.
     * Detach and replace the current node with the smallest value node from the
     * right child node.
     * There are 3 scenarios here as well after finding the leftmost node from
     * right child:
     * a) no grandchildren
     * b) 1 grandchild
     * c) more than 1 grandchildren
     * Depending on the path, you will have to attach and detach more pointer
     * links in the tree.
     * 4. Able to handle deletion of the root node.
     */
    {
        if (node == null)
            return;

        int smallComparedToData = Integer.MIN_VALUE;
        int largeComparedToData = Integer.MIN_VALUE;

        int parentComparison = Integer.MIN_VALUE;

        boolean small; // small is true and large is false

        if (node.data != null)
            parentComparison = node.data.compareTo (data);

        boolean dataIsLarger = parentComparison < 0;
        boolean dataIsSmaller = parentComparison > 0;
        boolean dataIsEqual = parentComparison == 0;

        if (dataIsEqual)
        {
            // System.out.println ("Root Node cannot be deleted.");
            nodeConnector (null, node, small = false);
        }

        else if (dataIsLarger)
        {
            if (node.large != null)
                largeComparedToData = node.large.data.compareTo (data);

            if (largeComparedToData == Integer.MIN_VALUE)
                return;

            dataIsEqual = largeComparedToData == 0;

            if (dataIsEqual)
            {
                small = false; // small is true and large is false
                nodeConnector (node, node.large, small);
            }

            else
                bst_delete (data, node.large);

        }

        else if (dataIsSmaller)
        {
            if (node.small != null)
                smallComparedToData = node.small.data.compareTo (data);

            if (smallComparedToData == Integer.MIN_VALUE)
                return;

            dataIsEqual = smallComparedToData == 0;

            if (dataIsEqual)
            {
                small = true; // small is true and large is false
                nodeConnector (node, node.small, small);
            }

            else
                bst_delete (data, node.small);
        }
    }

    public int bst_search (String data)
    {
        // System.out.println ("Search name? ");
        // String data = consoleReader.readLine ();

        if (root == null)                       // No root
        {
            return 0;
        }

        else
        {
            int result = bst_search (data, root);
            // System.out.println ("Returned ID from bst_search():" + result);
            return result;
        }
    }

    public int bst_search (String data, Node node)
    {
        int result = 0;
        int comparison = node.data.compareTo (data);
        if (comparison == 0)
        {
            // System.out.println ("Returned ID from bst_search (String, Node)
            // 1:" + node.id);
            return node.id;
        }
        if (comparison > 0)
        {
            // If it's less than the current node
            if (node.small == null)
            {

                // System.out.println ("(EOS) " + data + "is searched." +
                // node.data + "of small pointer is null.");
                // and the small pointer is null
                return result;

            }
            else
            {

                // Otherwise...call search() again to compare the current node
                // with the node at the small pointer
                result = bst_search (data, node.small);
            }

        }
        else
        {
            // It must be greater than the current node
            if (node.large == null)
            {
                // System.out.println ("(EOS) " + data + "is searched." +
                // node.data + "of large pointer is null.");
                return result;
            }
            else
            {

                // ...or when right node is not null
                result = bst_search (data, node.large);
                // ...call search() again at the right node
            }
        }

        return result;
    }

    public void inorder ()
    {
        bst_inorder (root);
    }

    public void bst_inorder (Node node)
    // Visit the left child, then the parent and right child

    {
        if (root == null)
        {
            return;
        }

        else if (node != null)
        {
            if (node.small != null)
            {
                bst_inorder (node.small);

            }
            System.out.println ("Node ID [" + node.id + "]\tName: " + node.data);

            if (node.large != null)
            {
                bst_inorder (node.large);
            }
        }
        else
        {
            return;
        }

    }

    public void preorder ()
    {
        bst_preorder (root);
    }

    public void bst_preorder (Node node)
    // Visit the parent first and then left and right children
    {

        if (node != null)
        {
            System.out.println ("Node ID [" + node.id + "]\tName: " + node.data);
            if (node.small != null)
            {
                bst_preorder (node.small);
            }

            if (node.large != null)
            {
                bst_preorder (node.large);
            }
        }

    }

}

/*
 * Description:
 *
 * You are responsible to implement the binary tree algorithms in Java.
 * This BST class should have bst_insert(), bst_delete() and bst_search() method
 * in addition to the default BST constructor. You need to implement the
 * bst_inorder()
 * and bst_preorder() methods to traverse the tree. After the whole tree is
 * constructed,
 * you will call both the inorder and preorder methods to display it’s content.
 * You are given 2 sample test data file that you can redirect from the command
 * line
 * when you run your program. For delete and search, you need to return the ID
 * (position)
 * of the string if found, return 0 if not found. Print out the result
 * from your p3 main() method.
 *
 *
 *
 * Additional Information:
 *
 * You data file starts with a list of names which ends when the string “NULL”
 * is detected.
 * Afterward, you will read the next character as the Action (D = Delete; S =
 * Search)
 * followed by the token string.
 *
 * You need to handle 3 different scenarios for bst_delete()
 * 1. The node you found has no children.
 * Detach itself from the tree and you are done.
 * 2. The node you found has 1 child.
 * Connect the child pointer to your parent pointer.
 * 3. The node you found has 2 children.
 * Detach and replace the current node with the smallest value node from the
 * right child node.
 * There are 3 scenarios here as well after finding the leftmost node from right
 * child:
 * a) no grandchildren
 * b) 1 grandchild
 * c) more than 1 grandchildren
 * Depending on the path, you will have to attach and detach more pointer links
 * in the tree.
 * 4. Able to handle deletion of the root node.
 *
 * Program Checklist:
 *
 * You will submit a zip file contain all your source files (e.g. p3.java,
 * BST.java, Node.java, …).
 */
