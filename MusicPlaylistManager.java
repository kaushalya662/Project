import java.util.*;

// 1. Service Interface
interface Service {
    double calculateTotalDuration();
}

// 2. Song Class
class Song {
    int songId;
    String songName;
    double duration; // in minutes

    // Constructor
    Song(int songId, String songName, double duration) {
        this.songId = songId;
        this.songName = songName;
        this.duration = duration;
    }

    // Display Song Details
    void displaySong() {
        System.out.println(songId + " - " + songName + " (" + duration + " mins)");
    }
}

// 3. Playlist Class
class Playlist implements Service {
    ArrayList<Song> songs = new ArrayList<>();

    // Add Song
    void addSong(Song song) {
        songs.add(song);
        System.out.println("Song added successfully!");
    }

    // Remove Song
    void removeSong(int songId) {
        boolean found = false;
        for (Song s : songs) {
            if (s.songId == songId) {
                songs.remove(s);
                System.out.println("Song removed!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Song not found!");
        }
    }

    // Display Playlist
    void displayPlaylist() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty!");
            return;
        }
        System.out.println("\n--- Playlist ---");
        for (Song s : songs) {
            s.displaySong();
        }
    }

    // Calculate Total Duration
    public double calculateTotalDuration() {
        double total = 0;
        for (Song s : songs) {
            total += s.duration;
        }
        return total;
    }
}

// 4. Main Class
public class MusicPlaylistManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist();

        int choice;

        do {
            System.out.println("\n--- Music Playlist Manager ---");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Display Playlist");
            System.out.println("4. Total Duration");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Song ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Song Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Duration (mins): ");
                    double duration = sc.nextDouble();

                    Song song = new Song(id, name, duration);
                    playlist.addSong(song);
                    break;

                case 2:
                    System.out.print("Enter Song ID to remove: ");
                    int removeId = sc.nextInt();
                    playlist.removeSong(removeId);
                    break;

                case 3:
                    playlist.displayPlaylist();
                    break;

                case 4:
                    double total = playlist.calculateTotalDuration();
                    System.out.println("Total Duration: " + total + " mins");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}