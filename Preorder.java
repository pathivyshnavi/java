class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class Preorder {
    Node root;

    // Recursive Preorder Traversal
    void preorderTraversal(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public static void main(String[] args) {
        Preorder tree = new Preorder();

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

        System.out.print("Preorder traversal: ");
        tree.preorderTraversal(tree.root);  // Output: 1 2 4 5 3
    }
}
