public class MergeLogStreams {

    static class Node {
        int timestamp;
        Node next;

        Node(int timestamp) {
            this.timestamp = timestamp;
            this.next = null;
        }
    }

    // Merge two sorted log streams
    static Node mergeLogStreams(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.timestamp <= b.timestamp) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        // Attach the remaining nodes
        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }

        return dummy.next;
    }

    // Insert node at the end
    static Node insert(Node head, int timestamp) {
        Node newNode = new Node(timestamp);

        if (head == null)
            return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    // Display the linked list
    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.timestamp + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Node stream1 = null;
        Node stream2 = null;

        // Log Stream 1
        stream1 = insert(stream1, 10);
        stream1 = insert(stream1, 20);
        stream1 = insert(stream1, 40);

        // Log Stream 2
        stream2 = insert(stream2, 15);
        stream2 = insert(stream2, 30);
        stream2 = insert(stream2, 50);

        System.out.println("Log Stream 1:");
        display(stream1);

        System.out.println("Log Stream 2:");
        display(stream2);

        Node merged = mergeLogStreams(stream1, stream2);

        System.out.println("Merged Log Stream:");
        display(merged);
    }
}