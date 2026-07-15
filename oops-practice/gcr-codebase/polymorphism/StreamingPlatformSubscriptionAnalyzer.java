// Superclass
class Subscription {
    String subscriberName;
    String subscriptionId;

    Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    double calculateMonthlyCharge() {
        return 0;
    }

    void displayDetails() {
        System.out.println("Subscriber Name : " + subscriberName);
        System.out.println("Subscription ID : " + subscriptionId);
    }
}

// Basic Plan
class BasicPlan extends Subscription {

    BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    double calculateMonthlyCharge() {
        return 199.0;
    }
}

// Premium Plan
class PremiumPlan extends Subscription {

    PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    double calculateMonthlyCharge() {
        return 499.0;
    }
}

// Family Plan
class FamilyPlan extends Subscription {

    FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    double calculateMonthlyCharge() {
        return 799.0;
    }
}

// Main Class
public class StreamingPlatformSubscriptionAnalyzer {

    // Search by Subscription ID
    private static void searchById(Subscription[] subscriptions,
                                    String subscriptionId) {

        boolean found = false;

        for (Subscription s : subscriptions) {
            if (s.subscriptionId.equalsIgnoreCase(subscriptionId)) {
                System.out.println("\nSubscription Found:");
                s.displayDetails();
                System.out.println("Monthly Charge : ₹"
                        + s.calculateMonthlyCharge());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nNo subscription found with ID: "
                    + subscriptionId);
        }
    }

    // Display Subscribers Starting with a Particular Letter
    private static void displaySubscribersByLetter(
                                                   Subscription[] subscriptions, char letter) {

        System.out.println("\nSubscribers starting with '" + letter + "':");

        boolean found = false;

        for (Subscription s : subscriptions) {
            if (Character.toUpperCase(s.subscriberName.charAt(0))
                    == Character.toUpperCase(letter)) {

                s.displayDetails();
                System.out.println(" ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No subscribers found.");
        }
    }

    // Calculate Total Monthly Revenue
    private static double calculateTotalRevenue(
                                                Subscription[] subscriptions) {

        double totalRevenue = 0;

        for (Subscription s : subscriptions) {
            totalRevenue += s.calculateMonthlyCharge();
        }

        return totalRevenue;
    }

    public static void main(String[] args) {

        Subscription[] subscriptions = {
                new BasicPlan("Mahi", "B101"),
                new PremiumPlan("Rahul", "P201"),
                new FamilyPlan("Anjali", "F301"),
                new PremiumPlan("Aman", "P202"),
                new BasicPlan("Akash", "B102")
        };

        System.out.println(" Subscription Details ");

        Subscription mostExpensive = subscriptions[0];

        for (Subscription s : subscriptions) {

            s.displayDetails();
            System.out.println("Monthly Charge : ₹"
                    + s.calculateMonthlyCharge());
            System.out.println(" ");

            // Find Most Expensive Subscription
            if (s.calculateMonthlyCharge()
                    > mostExpensive.calculateMonthlyCharge()) {
                mostExpensive = s;
            }
        }

        // Total Revenue
        System.out.println("\nTotal Monthly Revenue : ₹"
                + calculateTotalRevenue(subscriptions));

        // Search by Subscription ID
        searchById(subscriptions, "P201");

        // Display Subscribers by Starting Letter
        displaySubscribersByLetter(subscriptions, 'A');

        // Most Expensive Subscription
        System.out.println("\n Most Expensive Subscription ");
        mostExpensive.displayDetails();
        System.out.println("Monthly Charge : ₹"
                + mostExpensive.calculateMonthlyCharge());
    }
}