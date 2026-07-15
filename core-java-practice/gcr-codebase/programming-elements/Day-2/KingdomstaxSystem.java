public class KingdomstaxSystem {
    public static void main(String[] args) {

        double income = 45000;
        double tax;

        if (income < 10000) {
            tax = income * 0.05;
            System.out.println("Tax Bracket: 5%");
        } else if (income <= 50000) {
            tax = income * 0.15;
            System.out.println("Tax Bracket: 15%");
        } else {
            tax = income * 0.30;
            System.out.println("Tax Bracket: 30%");
        }

        System.out.println("Tax Amount: " + tax);

        double[] incomes = {
            8000, 12000, 25000, 60000, 45000,
            9000, 70000, 30000, 15000, 55000
        };

        double totalTax = 0;

        for (double inc : incomes) {
            if (inc < 10000) {
                totalTax += inc * 0.05;
            } else if (inc <= 50000) {
                totalTax += inc * 0.15;
            } else {
                totalTax += inc * 0.30;
            }
        }

        System.out.println("Total Tax Collected from 10 Citizens: " + totalTax);
    }
}