package DSA.Queue;

import java.util.PriorityQueue;

public class HospitalTriageSystem {

    static class Patient implements Comparable<Patient> {

        String name;
        int urgency;

        public Patient(String name, int urgency) {
            this.name = name;
            this.urgency = urgency;
        }

        @Override
        public int compareTo(Patient other) {
            return other.urgency - this.urgency;
        }
    }

    public static void main(String[] args) {

        PriorityQueue<Patient> queue = new PriorityQueue<>();

        queue.offer(new Patient("Aman", 2));
        queue.offer(new Patient("Rahul", 5));
        queue.offer(new Patient("Priya", 3));
        queue.offer(new Patient("Neha", 4));

        System.out.println("Patients treated in priority order:");

        while (!queue.isEmpty()) {
            Patient patient = queue.poll();
            System.out.println(patient.name + " - Urgency: " + patient.urgency);
        }
    }
}