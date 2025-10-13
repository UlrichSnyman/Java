package MusicPlayer;

import MusicPlayer.Song;
import java.util.*;
import java.util.stream.Collectors;

public class Jukebox {
    private final List<Song> songList;

    public Jukebox(List<Song> songList) {
        this.songList = new ArrayList<>(songList); // Use a mutable list
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            String command = scanner.nextLine();

            // Using try-catch for safe integer parsing
            try {
                int choice = Integer.parseInt(command);
                switch (choice) {
                    case 1:
                        System.out.println("\n--- All Songs (Natural Order) ---");
                        Collections.sort(songList);
                        songList.forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("\n--- All Songs (Sorted by Artist) ---");
                        songList.sort((one, two) -> one.getArtist().compareTo(two.getArtist()));
                        songList.forEach(System.out::println);
                        break;
                    case 3:
                        System.out.println("\n--- Rock Songs Only ---");
                        List<Song> rockSongs = getSongsByGenre("Rock");
                        rockSongs.forEach(System.out::println);
                        break;
                    case 4:
                        System.out.println("\n--- Unique Genres ---");
                        Set<String> genres = getUniqueGenres();
                        System.out.println(genres);
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
            System.out.println("----------------------------------\n");
        }
    }

    // Using a stream with a filter operation.
    public List<Song> getSongsByGenre(String genre) {
        return songList.stream()
                .filter(song -> song.getGenre().contains(genre))
                .collect(Collectors.toList());
    }

    // Using stream with map and distinct operations.
    public Set<String> getUniqueGenres() {
        return songList.stream()
                .map(Song::getGenre) // Method reference for mapping
                .distinct()
                .collect(Collectors.toSet());
    }

    private void printMenu() {
        System.out.println("===== Jukebox Menu =====");
        System.out.println("1: List all songs (sorted by title)");
        System.out.println("2: List all songs (sorted by artist)");
        System.out.println("3: List all 'Rock' songs");
        System.out.println("4: List unique genres");
        System.out.println("5: Exit");
        System.out.print("Enter your choice: ");
    }
}