// Interface 1
interface StreamingService {

    void streamMovie(); // Abstract Method

    default void showSubscriptionDetails() {
        System.out.println("Streaming Service Subscription Active.");
    }
}

// Interface 2
interface GamingService {

    void playGame(); // Abstract Method

    default void showSubscriptionDetails() {
        System.out.println("Gaming Service Subscription Active.");
    }
}

// Class implementing both interfaces
class SmartTV implements StreamingService, GamingService {

    private final String[] movies;
    private final String[] games;

    public SmartTV(String[] movies, String[] games) {
        this.movies = movies;
        this.games = games;
    }

    @Override
    public void streamMovie() {
        System.out.println("Streaming movies on Smart TV.");
    }

    @Override
    public void playGame() {
        System.out.println("Playing games on Smart TV.");
    }

    // Resolving default method conflict
    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public void displayContent() {

        System.out.println("\nAvailable Movies:");
        for (String movie : movies) {
            System.out.println("- " + movie);
        }

        System.out.println("\nAvailable Games:");
        for (String game : games) {
            System.out.println("- " + game);
        }
    }
}

// Main Class
public class MultiServiceSmartTV {
    public static void main(String[] args) {

        String[] movies = {
                "Avengers: Endgame",
                "Inception",
                "Interstellar"
        };

        String[] games = {
                "FIFA 25",
                "Minecraft",
                "Need for Speed"
        };

        SmartTV tv = new SmartTV(movies, games);

        tv.streamMovie();
        tv.playGame();

        System.out.println("\nSubscription Details:");
        tv.showSubscriptionDetails();

        tv.displayContent();
    }
}