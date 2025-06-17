class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class NonLeafCounter {
    static int countNonLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        return 1 + countNonLeafNodes(root.left) + countNonLeafNodes(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int nonLeafCount = countNonLeafNodes(root);
        System.out.println("Number of non-leaf nodes: " + nonLeafCount);
    }
}
