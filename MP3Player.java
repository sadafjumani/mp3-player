import java.util.ArrayList;
import java.util.Scanner;

class MusicPlayer {
    private ArrayList<String> playlist;
    private int currentSongIndex;
    private boolean isPlaying;
    private boolean isPaused;

    // Constructor to initialize playlist
    public MusicPlayer(ArrayList<String> playlist) {
        this.playlist = playlist;
        this.currentSongIndex = 0;
        this.isPlaying = false;
        this.isPaused = false;
    }

    // Play the current song
    public void play() {
        if (isPaused) {
            System.out.println("Resuming: " + playlist.get(currentSongIndex));
            isPaused = false;
        } else {
            System.out.println("Playing: " + playlist.get(currentSongIndex));
        }
        isPlaying = true;
    }

    // Pause the current song
    public void pause() {
        if (isPlaying) {
            System.out.println("Music paused.");
            isPaused = true;
            isPlaying = false;
        } else {
            System.out.println("No music is currently playing.");
        }
    }

    // Stop the current song
    public void stop() {
        if (isPlaying || isPaused) {
            System.out.println("Stopping: " + playlist.get(currentSongIndex));
            isPlaying = false;
            isPaused = false;
        } else {
            System.out.println("No music is currently playing.");
        }
    }

    // Play the next song in the playlist
    public void next() {
        if (currentSongIndex < playlist.size() - 1) {
            currentSongIndex++;
        } else {
            currentSongIndex = 0; // Loop back to the first song
        }
        play();
    }

    // Play the previous song in the playlist
    public void previous() {
        if (currentSongIndex > 0) {
            currentSongIndex--;
        } else {
            currentSongIndex = playlist.size() - 1; // Loop back to the last song
        }
        play();
    }

    // Replay the current song
    public void replay() {
        System.out.println("Replaying: " + playlist.get(currentSongIndex));
        play();
    }

    // Show the list of all songs
    public void showPlaylist() {
        System.out.println("Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
    }

    // Get the current song
    public String getCurrentSong() {
        return playlist.get(currentSongIndex);
    }
}

public class MP3Player {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize playlist with some songs
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("Song 1 - Imagine Dragons");
        playlist.add("Song 2 - Coldplay");
        playlist.add("Song 3 - Ed Sheeran");
        playlist.add("Song 4 - Billie Eilish");
        playlist.add("Song 5 - The Weeknd");

        MusicPlayer player = new MusicPlayer(playlist);

        int choice;
        do {
            System.out.println("\n--- MP3 Player Menu ---");
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Stop");
            System.out.println("4. Next Song");
            System.out.println("5. Previous Song");
            System.out.println("6. Replay Current Song");
            System.out.println("7. Show Playlist");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    player.play();
                    break;
                case 2:
                    player.pause();
                    break;
                case 3:
                    player.stop();
                    break;
                case 4:
                    player.next();
                    break;
                case 5:
                    player.previous();
                    break;
                case 6:
                    player.replay();
                    break;
                case 7:
                    player.showPlaylist();
                    break;
                case 8:
                    System.out.println("Exiting MP3 Player...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
