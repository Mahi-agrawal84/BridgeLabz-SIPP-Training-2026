class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Add Coach
    public void addCoach(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Remove Coach
    public void removeCoach(int key) {
        if (head == null)
            return;

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Reverse Train
    public void reverseTrain() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // Detect Circular Route (Cycle)
    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    // Find Middle Coach
    public Node findMiddle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Display Train
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Merge Two Sorted Lists
    public static Node mergeSorted(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null)
            tail.next = l1;

        if (l2 != null)
            tail.next = l2;

        return dummy.next;
    }

    // Print any linked list
    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}

public class TrainManagementSystem {
    public static void main(String[] args) {

        LinkedList train = new LinkedList();

        train.addCoach(10);
        train.addCoach(20);
        train.addCoach(30);
        train.addCoach(40);
        train.addCoach(50);

        System.out.println("Train Coaches:");
        train.display();

        train.removeCoach(30);
        System.out.println("After Removing Coach 30:");
        train.display();

        train.reverseTrain();
        System.out.println("After Reversing Train:");
        train.display();

        Node middle = train.findMiddle();
        System.out.println("Middle Coach: " + middle.data);

        System.out.println("Cycle Present: " + train.hasCycle());

        LinkedList schedule1 = new LinkedList();
        schedule1.addCoach(1);
        schedule1.addCoach(3);
        schedule1.addCoach(5);

        LinkedList schedule2 = new LinkedList();
        schedule2.addCoach(2);
        schedule2.addCoach(4);
        schedule2.addCoach(6);

        Node merged = LinkedList.mergeSorted(schedule1.head, schedule2.head);

        System.out.println("Merged Sorted Train Schedule:");
        LinkedList.printList(merged);
    }
}