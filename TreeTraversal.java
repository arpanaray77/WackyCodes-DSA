class Node2
{
    int key;
    Node2 left, right;
    public Node2(int item)
    {
        key = item;
        left = right = null;
    }
}
class TreeTraversal
{
    // Root of Binary Tree
    Node2 root;
    TreeTraversal()
    {
        root = null;
    }
    //preorder
    void printPreorder(Node2 node)
    {
        if (node == null)
            return;
        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left subtree */
        printPreorder(node.left);
        /* now recur on right subtree */
        printPreorder(node.right);
    }
    void printPreorder()
    {
        printPreorder(root);
    }

    // Add your method here
    //preorder
    void printPostorder(Node2 node)
    {
        if (node == null)
            return;
        /*first recur on left subtree */
        printPostorder(node.left);

        /* then recur on right subtree */
        printPostorder(node.right);

        /* lastly print data of node */
        System.out.print(node.key + " ");
    }
    void printPostorder()
    {
        printPostorder(root);
    }

    //inorder
    void printInorder(Node2 node)
    {
        if (node == null)
            return;
        /*first recur on left subtree */
        printInorder(node.left);

        /* then print data of node */
        System.out.print(node.key + " ");

        /* at the end of recur on right subtree */
        printInorder(node.right);
    }

    void printInorder()
    {
        printInorder(root);
    }

    //main method
    public static void main(String[] args)
    {System.out.println(" ");
        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node2(1);
        tree.root.left = new Node2(2);
        tree.root.right = new Node2(3);
        tree.root.left.left = new Node2(4);
        tree.root.left.right = new Node2(5);
          //displaying result
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();
        System.out.println(" ");

        System.out.println("Postorder traversal of binary tree is ");
        tree.printPostorder();
        System.out.println(" ");

        System.out.println("Inorder traversal of binary tree is ");
        tree.printInorder();

    }
}




