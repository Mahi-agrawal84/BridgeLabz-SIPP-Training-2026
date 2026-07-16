class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class DeleteFolderTree {

    static void deleteFolderTree(Node node) {
        if (node == null) {
            return;
        }

        deleteFolderTree(node.left);
        deleteFolderTree(node.right);

        // Simulate deleting the node
        System.out.println("Deleting Node: " + node.data);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        deleteFolderTree(root);
    }
}