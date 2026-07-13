public class MiddleServerFinder {

    static class Node {
        int serverId;
        Node next;

        Node(int serverId) {
            this.serverId = serverId;
            this.next = null;
        }
    }

    // Find the middle server
    static Node findMiddleServer(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Insert server at the end
    static Node insert(Node head, int serverId) {
        Node newNode = new Node(serverId);

        if (head == null)
            return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Display the server chain
    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.serverId + " -> ");
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
        head = insert(head, 105);

        System.out.println("Server Chain:");
        display(head);

        Node middle = findMiddleServer(head);

        System.out.println("Middle Server: " + middle.serverId);
    }
}