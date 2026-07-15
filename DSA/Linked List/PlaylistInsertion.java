public class PlaylistInsertion {
    public static class Node {
        int trackId;
        Node next;

        Node(int trackId) {
            this.trackId = trackId;
            this.next = null;
        }
    }

    Node head;

    // Insert a new track after the given current node
    public void insertAfter(Node current, int trackId) {
        if (current == null) {
            System.out.println("Current track not found.");
            return;
        }

        Node newNode = new Node(trackId);

        // Save the remaining queue
        newNode.next = current.next;

        // Link current node to the new node
        current.next = newNode;
    }

    // Add track at the end
    public void addTrack(int trackId) {
        Node newNode = new Node(trackId);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Display the playlist
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.trackId + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        PlaylistInsertion playlist = new PlaylistInsertion();

        playlist.addTrack(101);
        playlist.addTrack(102);
        playlist.addTrack(104);

        System.out.println("Original Playlist:");
        playlist.display();

        // Current playing track = 102
        Node current = playlist.head.next;

        // Insert track 103 after current track
        playlist.insertAfter(current, 103);

        System.out.println("Playlist After Insertion:");
        playlist.display();
    }
}