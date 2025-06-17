class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class Postorder {
    Node root;

    // Recursive Postorder Traversal
    void postorderTraversal(Node node) {
        if (node == null)
            return;

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Postorder tree = new Postorder();

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

        System.out.print("Postorder traversal: ");
        tree.postorderTraversal(tree.root);  // Output: 4 5 2 3 1
    }
}
