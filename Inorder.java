class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class Inorder {
    Node root;

    // Recursive Inorder Traversal
    void inorderTraversal(Node node) {
        if (node == null)
            return;

        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        Inorder tree = new Inorder();

        /* Constructed binary tree:
                 1
               /   \
              2     3
             / \   
            4   5
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Inorder traversal: ");
        tree.inorderTraversal(tree.root);  // Output: 4 2 5 1 3
    }
}
