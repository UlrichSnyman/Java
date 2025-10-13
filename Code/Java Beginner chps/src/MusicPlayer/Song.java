package MusicPlayer;

import java.util.Objects;

// Implements Comparable to define the "natural order" for sorting (by title).
public class Song implements Comparable<Song> {

    private final String title;
    private final String artist;
    private final String genre;
    private final int year;
    private final int timesPlayed;

    public Song(String title, String artist, String genre, int year, int timesPlayed) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.timesPlayed = timesPlayed;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    // Overriding toString() for readable output.
    @Override
    public String toString() {
        return title + " by " + artist;
    }

    // Implementing the compareTo method from the Comparable interface.
    @Override
    public int compareTo(Song other) {
        return this.title.compareTo(other.title);
    }

    // Overriding equals() and hashCode() is crucial for Set operations.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) &&
                Objects.equals(artist, song.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist);
    }
}
