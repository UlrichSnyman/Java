package MusicPlayer;

import MusicPlayer.SongLoader;
import MusicPlayer.Song;
import MusicPlayer.Jukebox;
import java.util.List;

public class JukeBoxApp {
    public static void main(String[] args) {
        // 1. Load the data
        List<Song> songs = SongLoader.loadSongs();

        // 2. Create the main application object
        Jukebox jukebox = new Jukebox(songs);

        // 3. Start the application
        jukebox.play();
    }
}
