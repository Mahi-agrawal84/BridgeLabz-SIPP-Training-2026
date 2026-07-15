package DSA.Queue;

public class CircularQueueScheduler {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueueScheduler(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enqueue(int processId) {

        if (size == capacity) {
            System.out.println("Queue is Full");
            return false;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = processId;
        size++;

        return true;
    }

    public int dequeue() {

        if (size == 0) {
            throw new RuntimeException("Queue is Empty");
        }

        int process = queue[front];
        front = (front + 1) % capacity;
        size--;

        return process;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        CircularQueueScheduler scheduler = new CircularQueueScheduler(5);

        scheduler.enqueue(101);
        scheduler.enqueue(102);
        scheduler.enqueue(103);
        scheduler.enqueue(104);

        System.out.println("Executing Processes:");

        while (!scheduler.isEmpty()) {
            System.out.println("Process " + scheduler.dequeue());
        }
    }
}