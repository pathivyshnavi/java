class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}
class Example {
    Node root;
    int countLeafNodes(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return countLeafNodes(node.left) + countLeafNodes(node.right);
    }
    public static void main(String args[]) {
        Example tree = new Example();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        System.out.println("The number of leaf nodes are : " + tree.countLeafNodes(tree.root));
    }
}