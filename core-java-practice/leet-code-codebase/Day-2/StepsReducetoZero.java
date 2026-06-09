public class StepsReducetoZero {
    public static void main(String[] args) {
        int num = 14; 
        int steps = numberOfSteps(num);
        System.out.println("Number of steps to reduce " + num + " to zero: " + steps);
    }

    public static int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1; 
            }
            steps++;
        }
        return steps;
    }
}
