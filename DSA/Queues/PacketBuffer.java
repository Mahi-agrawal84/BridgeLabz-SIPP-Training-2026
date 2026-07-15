package DSA.Queue;

public class PacketBuffer {

    private int[] data;
    private int front;
    private int count;

    // Constructor
    public PacketBuffer(int capacity) {
        data = new int[capacity];
        front = 0;
        count = 0;
    }

    // Enqueue a packet
    public boolean enqueue(int packetId) {

        if (count == data.length) {
            System.out.println("Buffer is Full. Packet Rejected.");
            return false;
        }

        int rear = (front + count) % data.length;
        data[rear] = packetId;
        count++;

        return true;
    }

    // Dequeue a packet
    public int dequeue() {

        if (count == 0) {
            throw new RuntimeException("Buffer is Empty.");
        }

        int packet = data[front];
        front = (front + 1) % data.length;
        count--;

        return packet;
    }

    // Peek the front packet
    public int peek() {

        if (count == 0) {
            throw new RuntimeException("Buffer is Empty.");
        }

        return data[front];
    }

    // Check if the buffer is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Check if the buffer is full
    public boolean isFull() {
        return count == data.length;
    }

    public static void main(String[] args) {

        PacketBuffer buffer = new PacketBuffer(5);

        System.out.println("Enqueue 101: " + buffer.enqueue(101));
        System.out.println("Enqueue 102: " + buffer.enqueue(102));
        System.out.println("Enqueue 103: " + buffer.enqueue(103));
        System.out.println("Enqueue 104: " + buffer.enqueue(104));
        System.out.println("Enqueue 105: " + buffer.enqueue(105));

        // Buffer is full
        System.out.println("Enqueue 106: " + buffer.enqueue(106));

        System.out.println("\nFront Packet: " + buffer.peek());

        System.out.println("\nProcessing Packets:");

        while (!buffer.isEmpty()) {
            System.out.println("Processed Packet: " + buffer.dequeue());
        }
    }
}