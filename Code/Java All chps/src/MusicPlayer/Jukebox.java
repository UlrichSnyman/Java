package MusicPlayer;

import MusicPlayer.Song;
import java.util.*;
import java.util.stream.Collectors;

public class Jukebox {
    private final List<Song> songList;

    public Jukebox(List<Song> songList) {
        // We use ArrayList to ensure the list is mutable (can be sorted).
        this.songList = new ArrayList<>(songList);
    }

    public List<Song> getAllSongs() {
        return new ArrayList<>(songList); // Return a copy
    }

    // Method to sort by the "natural order" (title)
    public List<Song> sortSongsByTitle() {
        Collections.sort(songList);
        return new ArrayList<>(songList);
    }

    // Method to sort using a custom lambda (by artist)
    public List<Song> sortSongsByArtist() {
        songList.sort((one, two) -> one.getArtist().compareTo(two.getArtist()));
        return new ArrayList<>(songList);
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
                .map(Song::getGenre)
                .distinct()
                .collect(Collectors.toSet());
    }
}