import java.util.LinkedList;
import java.util.Scanner;

public class MusicPlaylistRecommendationEngine {

    // LinkedList to store recently played songs
    private final LinkedList<String> playlist = new LinkedList<>();

    // Play a Song
    public void playSong(String song) {

        // Remove if already exists to avoid duplicates
        if (playlist.contains(song)) {
            playlist.remove(song);
        }

        // Add song at the beginning
        playlist.addFirst(song);

        // Keep only latest 10 songs
        if (playlist.size() > 10) {
            String removedSong = playlist.removeLast();
            System.out.println("Oldest song removed: " + removedSong);
        }

        System.out.println("Now Playing: " + song);
    }

    // Search Song
    public void searchSong(String song) {
        if (playlist.contains(song)) {
            System.out.println(song + " is in the Recently Played list.");
        } else {
            System.out.println(song + " is not in the Recently Played list.");
        }
    }

    // Display Playlist
    public void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Recently Played list is empty.");
        } else {
            System.out.println("\n Recently Played Songs ");
            int i = 1;
            for (String song : playlist) {
                System.out.println(i + ". " + song);
                i++;
            }
        }
    }

    public static void main(String[] args) {

        MusicPlaylistRecommendationEngine player =
                new MusicPlaylistRecommendationEngine();

        int choice;

        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("\n Music Playlist Recommendation Engine ");
                System.out.println("1. Play Song");
                System.out.println("2. Search Song");
                System.out.println("3. Display Recently Played");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Song Name: ");
                        String song = sc.nextLine();
                        player.playSong(song);
                    }
                    case 2 -> {
                        System.out.print("Enter Song Name to Search: ");
                        String song = sc.nextLine();
                        player.searchSong(song);
                    }
                    case 3 -> player.displayPlaylist();
                    case 4 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid Choice!");
                }

            } while (choice != 4);
        }
    }
}