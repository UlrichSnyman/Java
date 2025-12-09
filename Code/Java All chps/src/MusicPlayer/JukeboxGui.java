package MusicPlayer;

import MusicPlayer.SongLoader;
import MusicPlayer.Song;
import MusicPlayer.Jukebox;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Set;
import java.awt.event.*;

public class JukeboxGui {

    private JFrame frame;
    private JTextArea songDisplayArea;
    private Jukebox jukebox;

    public JukeboxGui() {
        // Initialize the backend Jukebox service
        jukebox = new Jukebox(SongLoader.loadSongs());
    }

    public void buildGui() {
        // 1. Create the main frame
        frame = new JFrame("My Music Jukebox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 2. Create the display area
        songDisplayArea = new JTextArea(15, 40);
        songDisplayArea.setEditable(false);
        JScrollPane scroller = new JScrollPane(songDisplayArea);
        frame.getContentPane().add(BorderLayout.CENTER, scroller);

        // 3. Create a panel for the buttons
        JPanel buttonPanel = new JPanel();

        // 4. Create the buttons and add listeners
        JButton sortByTitleButton = new JButton("Sort by Title");
        // Using a LAMBDA for the event listener
        sortByTitleButton.addActionListener(event -> {
            List<Song> sortedSongs = jukebox.sortSongsByTitle();
            updateSongDisplay(sortedSongs);
        });

        JButton sortByArtistButton = new JButton("Sort by Artist");
        // Using an INNER CLASS for the event listener
        sortByArtistButton.addActionListener(new ArtistSortListener());

        JButton showRockButton = new JButton("Show Rock Songs");
        showRockButton.addActionListener(event -> {
            List<Song> rockSongs = jukebox.getSongsByGenre("Rock");
            updateSongDisplay(rockSongs);
        });

        JButton showGenresButton = new JButton("Show Unique Genres");
        showGenresButton.addActionListener(event -> {
            Set<String> genres = jukebox.getUniqueGenres();
            songDisplayArea.setText("Available Genres:\n");
            genres.forEach(genre -> songDisplayArea.append(genre + "\n"));
        });

        // 5. Add buttons to the panel
        buttonPanel.add(sortByTitleButton);
        buttonPanel.add(sortByArtistButton);
        buttonPanel.add(showRockButton);
        buttonPanel.add(showGenresButton);

        // 6. Create a custom drawing panel for a banner
        BannerPanel banner = new BannerPanel();
        frame.getContentPane().add(BorderLayout.NORTH, banner);

        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

        // 7. Display the initial list of songs
        updateSongDisplay(jukebox.getAllSongs());

        // 8. Pack and display the frame
        frame.pack();
        frame.setVisible(true);
    }

    // Helper method to update the text area with a list of songs
    private void updateSongDisplay(List<Song> songs) {
        songDisplayArea.setText(""); // Clear the text area
        songs.forEach(song -> songDisplayArea.append(song.toString() + "\n"));
    }

    // --- Inner Classes for Event Handling and Custom Painting ---

    // An INNER CLASS that implements ActionListener
    class ArtistSortListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            List<Song> sortedSongs = jukebox.sortSongsByArtist();
            updateSongDisplay(sortedSongs);
        }
    }

    // An INNER CLASS that extends JPanel for custom graphics
    class BannerPanel extends JPanel {
        public void paintComponent(Graphics g) {
            // Cast to Graphics2D to use gradients
            Graphics2D g2d = (Graphics2D) g;

            // Create a gradient paint
            GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

            // Set font and color for text
            g2d.setColor(Color.white);
            g2d.setFont(new Font("Serif", Font.BOLD, 24));
            g2d.drawString("Personal Jukebox", 110, 35);
        }
    }
}