class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BSTInsert {

    static Node insert(Node node, int id) {

        if (node == null) {
            return new Node(id);
        }

        if (id < node.val) {
            node.left = insert(node.left, id);
        } else if (id > node.val) {
            node.right = insert(node.right, id);
        }

        return node;
    }

    static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = null;

        int[] ids = {50, 30, 70, 20, 40, 60, 80};

        for (int id : ids) {
            root = insert(root, id);
        }

        System.out.println("BST after initial insertion:");
        inorder(root);

        root = insert(root, 65);

        System.out.println("\n\nBST after inserting 65:");
        inorder(root);
    }
}