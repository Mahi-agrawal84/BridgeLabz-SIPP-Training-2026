package DSA.Queue;

import java.util.PriorityQueue;

public class HospitalERTriage {

    // Patient class
    static class Patient {

        int priority;
        String name;

        public Patient(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }
    }

    // Min-Heap based Priority Queue
    private PriorityQueue<Patient> triageQueue;

    // Constructor
    public HospitalERTriage() {
        triageQueue = new PriorityQueue<>((a, b) -> a.priority - b.priority);
    }

    // Admit a new patient
    public void admitPatient(Patient patient) {
        triageQueue.offer(patient);
        System.out.println(patient.name + " admitted with Priority " + patient.priority);
    }

    // Call the most urgent patient
    public Patient callNextPatient() {

        if (triageQueue.isEmpty()) {
            throw new RuntimeException("No patients waiting.");
        }

        return triageQueue.poll();
    }

    // View the most urgent patient
    public Patient peekNextPatient() {

        if (triageQueue.isEmpty()) {
            throw new RuntimeException("No patients waiting.");
        }

        return triageQueue.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return triageQueue.isEmpty();
    }

    public static void main(String[] args) {

        HospitalERTriage hospital = new HospitalERTriage();

        hospital.admitPatient(new Patient(3, "Rahul"));
        hospital.admitPatient(new Patient(1, "Priya"));
        hospital.admitPatient(new Patient(4, "Amit"));
        hospital.admitPatient(new Patient(2, "Neha"));

        Patient next = hospital.peekNextPatient();
        System.out.println("\nNext Patient: " + next.name + " (Priority " + next.priority + ")");

        System.out.println("\nCalling Patients:");

        while (!hospital.isEmpty()) {
            Patient patient = hospital.callNextPatient();
            System.out.println(patient.name + " (Priority " + patient.priority + ")");
        }
    }
}