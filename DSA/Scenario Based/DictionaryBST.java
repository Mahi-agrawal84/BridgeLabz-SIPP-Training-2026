class Node {
    String word;
    Node left;
    Node right;

    Node(String word) {
        this.word = word;
        left = null;
        right = null;
    }
}

public class DictionaryBST {

    static int count = 0;
    static String kthWord = null;

    static Node insert(Node root, String word) {
        if (root == null) {
            return new Node(word);
        }

        if (word.compareTo(root.word) < 0) {
            root.left = insert(root.left, word);
        } else if (word.compareTo(root.word) > 0) {
            root.right = insert(root.right, word);
        }

        return root;
    }

    static boolean search(Node root, String word) {
        if (root == null) {
            return false;
        }

        if (word.equals(root.word)) {
            return true;
        }

        if (word.compareTo(root.word) < 0) {
            return search(root.left, word);
        }

        return search(root.right, word);
    }

    static Node delete(Node root, String word) {
        if (root == null) {
            return null;
        }

        if (word.compareTo(root.word) < 0) {
            root.left = delete(root.left, word);
        } else if (word.compareTo(root.word) > 0) {
            root.right = delete(root.right, word);
        } else {

            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            Node successor = findMin(root.right);
            root.word = successor.word;
            root.right = delete(root.right, successor.word);
        }

        return root;
    }

    static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.word + " ");
        inorder(root.right);
    }

    static void kthSmallest(Node root, int k) {
        if (root == null) {
            return;
        }

        kthSmallest(root.left, k);

        count++;
        if (count == k) {
            kthWord = root.word;
            return;
        }

        kthSmallest(root.right, k);
    }

    static boolean validateBST(Node root, String min, String max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.word.compareTo(min) <= 0) {
            return false;
        }

        if (max != null && root.word.compareTo(max) >= 0) {
            return false;
        }

        return validateBST(root.left, min, root.word)
                && validateBST(root.right, root.word, max);
    }

    static Node lca(Node root, String w1, String w2) {

        if (root == null) {
            return null;
        }

        if (w1.compareTo(root.word) < 0 && w2.compareTo(root.word) < 0) {
            return lca(root.left, w1, w2);
        }

        if (w1.compareTo(root.word) > 0 && w2.compareTo(root.word) > 0) {
            return lca(root.right, w1, w2);
        }

        return root;
    }

    public static void main(String[] args) {

        Node root = null;

        String[] words = {
                "Mango", "Apple", "Banana", "Orange", "Grapes",
                "Peach", "Cherry", "Kiwi", "Lemon", "Papaya",
                "Guava", "Pear", "Plum", "Fig", "Date",
                "Coconut", "Apricot", "Berry", "Melon", "Avocado"
        };

        for (String word : words) {
            root = insert(root, word);
        }

        System.out.println("Inorder Traversal:");
        inorder(root);

        System.out.println("\n\nSearch Apple: " + search(root, "Apple"));
        System.out.println("Search Watermelon: " + search(root, "Watermelon"));

        root = delete(root, "Berry");     // Leaf node
        root = delete(root, "Fig");       // One child
        root = delete(root, "Orange");    // Two children

        System.out.println("\nAfter Deletion:");
        inorder(root);

        int k = 5;
        count = 0;
        kthWord = null;
        kthSmallest(root, k);

        System.out.println("\n\n" + k + "th Alphabetical Word: " + kthWord);

        System.out.println("\nIs Valid BST: " + validateBST(root, null, null));

        Node ans = lca(root, "Apple", "Cherry");

        if (ans != null) {
            System.out.println("LCA of Apple and Cherry: " + ans.word);
        }
    }
}