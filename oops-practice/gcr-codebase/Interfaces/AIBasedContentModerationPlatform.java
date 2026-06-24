// Interface 1
interface TextModeration {

    void checkOffensiveContent(String post);

    default void displayModerationPolicy() {
        System.out.println("Policy: Offensive or abusive content is not allowed.");
    }

    static boolean containsRestrictedWords(String post) {
        String[] restrictedWords = {"hate", "abuse", "offensive"};

        post = post.toLowerCase();

        for (String word : restrictedWords) {
            if (post.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

// Interface 2
interface SpamDetection {

    void checkSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Policy: Spam or promotional content is not allowed.");
    }
}

// Class implementing both interfaces
class ContentModerator implements TextModeration, SpamDetection {

    @Override
    public void checkOffensiveContent(String post) {
        if (TextModeration.containsRestrictedWords(post)) {
            System.out.println("Offensive Post: " + post);
        }
    }

    @Override
    public void checkSpam(String post) {
        String lowerPost = post.toLowerCase();

        if (lowerPost.contains("buy now")
                || lowerPost.contains("click here")
                || lowerPost.contains("free offer")) {
            System.out.println("Spam Post: " + post);
        }
    }

    // Resolve default method conflict
    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public void moderatePost(String post) {

        boolean isSpam = post.toLowerCase().contains("buy now")
                || post.toLowerCase().contains("click here")
                || post.toLowerCase().contains("free offer");

        boolean isOffensive =
                TextModeration.containsRestrictedWords(post);

        if (isSpam) {
            System.out.println("Spam Post: " + post);
        } else if (isOffensive) {
            System.out.println("Offensive Post: " + post);
        } else {
            System.out.println("Valid Post: " + post);
        }
    }
}

// Main Class
public class AIBasedContentModerationPlatform {

    public static void main(String[] args) {

        String[] posts = {
                "Welcome to our community!",
                "Buy now and get 50% discount!",
                "I hate this product.",
                "Click here to win a free offer.",
                "Have a great day everyone!"
        };

        ContentModerator moderator = new ContentModerator();

        System.out.println("Moderation Policies:");
        moderator.displayModerationPolicy();

        System.out.println("\nPost Analysis:");
        for (String post : posts) {
            moderator.moderatePost(post);
        }
    }
}