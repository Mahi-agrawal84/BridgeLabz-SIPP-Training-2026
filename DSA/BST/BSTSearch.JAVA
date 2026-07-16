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

public class BSTSearch {

    static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    static boolean search(Node root, int target) {
        Node current = root;

        while (current != null) {

            if (target == current.val) {
                return true;
            }

            if (target < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node root = null;

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int value : values) {
            root = insert(root, value);
        }

        int target = 60;

        if (search(root, target)) {
            System.out.println(target + " found in BST.");
        } else {
            System.out.println(target + " not found in BST.");
        }
    }
}