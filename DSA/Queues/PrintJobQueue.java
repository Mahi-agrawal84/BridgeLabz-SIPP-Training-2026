package DSA.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintJobQueue {

    private final Deque<Integer> printQueue;

    // Constructor
    public PrintJobQueue() {
        printQueue = new ArrayDeque<>();
    }

    // Add a normal print job to the back
    public void submitJob(int jobId) {
        printQueue.addLast(jobId);
        System.out.println("Normal Job Submitted: " + jobId);
    }

    // Add an urgent print job to the front
    public void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId);
        System.out.println("Urgent Job Submitted: " + jobId);
    }

    // Print the next job
    public int printNextJob() {

        if (printQueue.isEmpty()) {
            throw new RuntimeException("No print jobs available.");
        }

        return printQueue.removeFirst();
    }

    // View the next job
    public int peekNextJob() {

        if (printQueue.isEmpty()) {
            throw new RuntimeException("Print queue is empty.");
        }

        return printQueue.peekFirst();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return printQueue.isEmpty();
    }

    public static void main(String[] args) {

        PrintJobQueue queue = new PrintJobQueue();

        queue.submitJob(101);
        queue.submitJob(102);
        queue.submitJob(103);

        queue.submitUrgentJob(201);
        queue.submitUrgentJob(202);

        System.out.println("\nNext Job: " + queue.peekNextJob());

        System.out.println("\nPrinting Jobs:");

        while (!queue.isEmpty()) {
            System.out.println("Printed Job: " + queue.printNextJob());
        }
    }
}