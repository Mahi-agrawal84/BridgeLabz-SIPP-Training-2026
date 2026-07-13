public class TaskQueueDeletion {

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public TaskQueueDeletion() {}

    
    
    
    

    // Remove a task from the linked list
    public static Node removeTask(Node head, int taskId) {

        if (head == null)
            return null;

        // If the first node contains the task
        if (head.val == taskId)
            return head.next;

        Node prev = head;
        Node curr = head.next;

        // Search for the task
        while (curr != null && curr.val != taskId) {
            prev = curr;
            curr = curr.next;
        }

        // Remove the node if found
        if (curr != null) {
            prev.next = curr.next;
        }

        return head;
    }

    // Insert node at the end
    public static Node insert(Node head, int val) {
        Node newNode = new Node(val);

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
    public static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
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

        System.out.println("Original Task Queue:");
        display(head);

        head = removeTask(head, 103);

        System.out.println("After Removing Task 103:");
        display(head);
    }
}