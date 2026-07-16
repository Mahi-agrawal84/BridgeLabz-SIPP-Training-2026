package DSA.Trees;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class FamilyTree {

    Node root;

    // Recursive Inorder
    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Recursive Preorder
    void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Recursive Postorder
    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Iterative Inorder
    void inorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    // Iterative Preorder
    void preorderIterative(Node root) {

        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node temp = stack.pop();

            System.out.print(temp.data + " ");

            if (temp.right != null)
                stack.push(temp.right);

            if (temp.left != null)
                stack.push(temp.left);
        }
    }

    // Iterative Postorder
    void postorderIterative(Node root) {

        if (root == null)
            return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {

            Node temp = s1.pop();
            s2.push(temp);

            if (temp.left != null)
                s1.push(temp.left);

            if (temp.right != null)
                s1.push(temp.right);
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    // Level Order Traversal
    void levelOrder(Node root) {

        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node temp = queue.poll();

            System.out.print(temp.data + " ");

            if (temp.left != null)
                queue.add(temp.left);

            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    // Height
    int height(Node root) {

        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Count Nodes at Each Level
    void countNodesEachLevel(Node root) {

        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            System.out.println("Level " + level + " : " + size + " node(s)");

            for (int i = 0; i < size; i++) {

                Node temp = queue.poll();

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);
            }

            level++;
        }
    }

    // Diameter
    int diameter(Node root) {

        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(leftHeight + rightHeight + 1,
                Math.max(leftDiameter, rightDiameter));
    }

    // Check Balanced
    boolean isBalanced(Node root) {

        if (root == null)
            return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {

        FamilyTree tree = new FamilyTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.print("Recursive Inorder: ");
        tree.inorder(tree.root);

        System.out.println();

        System.out.print("Recursive Preorder: ");
        tree.preorder(tree.root);

        System.out.println();

        System.out.print("Recursive Postorder: ");
        tree.postorder(tree.root);

        System.out.println();

        System.out.print("Iterative Inorder: ");
        tree.inorderIterative(tree.root);

        System.out.println();

        System.out.print("Iterative Preorder: ");
        tree.preorderIterative(tree.root);

        System.out.println();

        System.out.print("Iterative Postorder: ");
        tree.postorderIterative(tree.root);

        System.out.println();

        System.out.print("Level Order: ");
        tree.levelOrder(tree.root);

        System.out.println();

        System.out.println("Height: " + tree.height(tree.root));

        System.out.println("\nNodes at Each Level:");
        tree.countNodesEachLevel(tree.root);

        System.out.println("\nDiameter: " + tree.diameter(tree.root));

        System.out.println("Balanced: " + tree.isBalanced(tree.root));
    }
}