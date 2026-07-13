public class BrowserHistoryReverse {

    static class Node {
        int pageId;
        Node next;

        Node(int pageId) {
            this.pageId = pageId;
            this.next = null;
        }
    }

    // Reverse the browser history
    static Node reverseHistory(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Insert page at the end
    static Node insert(Node head, int pageId) {
        Node newNode = new Node(pageId);

        if (head == null)
            return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Display browser history
    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.pageId + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Node head = null;

        head = insert(head, 101);
        head = insert(head, 102);
        head = insert(head, 103);
        head = insert(head, 104);

        System.out.println("Original Browser History:");
        display(head);

        head = reverseHistory(head);

        System.out.println("Reversed Browser History:");
        display(head);
    }
}