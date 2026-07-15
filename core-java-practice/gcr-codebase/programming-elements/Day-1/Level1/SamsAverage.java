package Level1;
public class SamsAverage {
    public static void main(String[] args) {
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        int subjects = 3;

        double average = (maths + physics + chemistry) / (double) subjects;

        System.out.println("Sam’s average mark in PCM is " + average);
    }
}
