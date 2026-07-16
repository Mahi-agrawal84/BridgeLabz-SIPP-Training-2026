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

public class BSTDelete {

    static Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }

        return node;
    }

    static Node delete(Node node, int sku) {

        if (node == null) {
            return null;
        }

        if (sku < node.val) {
            node.left = delete(node.left, sku);
        } else if (sku > node.val) {
            node.right = delete(node.right, sku);
        } else {

            // Case 1: Leaf node
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: One child
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            // Case 3: Two children
            Node successor = node.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            node.val = successor.val;

            node.right = delete(node.right, successor.val);
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

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int value : values) {
            root = insert(root, value);
        }

        System.out.print("Original BST: ");
        inorder(root);

        // Case 1: Delete Leaf Node
        root = delete(root, 20);
        System.out.print("\nAfter deleting leaf node (20): ");
        inorder(root);

        // Case 2: Delete Node with One Child
        root = delete(root, 30);
        System.out.print("\nAfter deleting node with one child (30): ");
        inorder(root);

        // Case 3: Delete Node with Two Children
        root = delete(root, 70);
        System.out.print("\nAfter deleting node with two children (70): ");
        inorder(root);
    }
}