package DSA.BST;

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

public class LowestCommonAncestorBST {

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

    static Node lowestCommonAncestor(Node root, int p, int q) {

        Node current = root;

        while (current != null) {

            if (p < current.val && q < current.val) {
                current = current.left;
            } else if (p > current.val && q > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Node root = null;

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int value : values) {
            root = insert(root, value);
        }

        int p = 20;
        int q = 40;

        Node lca = lowestCommonAncestor(root, p, q);

        if (lca != null) {
            System.out.println("Lowest Common Ancestor of " + p + " and " + q + " is: " + lca.val);
        } else {
            System.out.println("LCA not found.");
        }
    }
}