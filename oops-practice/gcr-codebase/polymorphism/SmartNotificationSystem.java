// Superclass
class Notification {
    String recipientName;
    String message;

    Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    void sendNotification() {
        System.out.println("Sending notification...");
    }
}

// Email Notification
class EmailNotification extends Notification {

    EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {
        System.out.println("Email sent to " + recipientName +
                " : " + message);
    }
}

// SMS Notification
class SMSNotification extends Notification {

    SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {
        System.out.println("SMS sent to " + recipientName +
                " : " + message);
    }
}

// Push Notification
class PushNotification extends Notification {

    PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {
        System.out.println("Push Notification sent to " +
                recipientName + " : " + message);
    }
}

// Main Class
public class SmartNotificationSystem {

    public static void main(String[] args) {

        // Notification array storing different objects
        Notification[] notifications = {
                new EmailNotification("Mahi", "Your order has been shipped."),
                new SMSNotification("Rahul", "Your OTP is 123456."),
                new PushNotification("Anjali", "You have a new friend request."),
                new EmailNotification("Aman", "Welcome to our service!")
        };

        System.out.println(" Sent Notifications ");

        // Dynamic Method Dispatch
        for (Notification n : notifications) {
            n.sendNotification();
        }
    }
}