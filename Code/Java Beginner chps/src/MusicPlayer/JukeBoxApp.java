package MusicPlayer;

import MusicPlayer.SongLoader;
import MusicPlayer.Song;
import MusicPlayer.Jukebox;
import java.util.List;

import MusicPlayer.JukeboxGui;

public class JukeBoxApp {
    public static void main(String[] args) {
        // Create an instance of the GUI and run it
        new JukeboxGui().buildGui();
    }
}
