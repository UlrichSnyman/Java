package chp15;

import javax.swing.*;
import java.awt.*;


public class Button1 {
    public static void main(String[] args) {
        Button1 gui = new Button1();  // Create an instance of the Button1 class
        gui.go();                    // Call the go method to set up the GUI
    }

    public void go() {
        JFrame frame = new JFrame();                      // Create a window (frame)

        JButton button = new JButton("There is no spoon...");
        Font bigFont = new Font("serif", Font.BOLD, 28);
        button.setFont(bigFont);
        frame.getContentPane().add(BorderLayout.NORTH, button);

        frame.setSize(200, 200);    // Set the window size to 200x200 pixels
        frame.setVisible(true);                 // Make the window visible on the screen
    }
}


//public class Button1 {
//  public static void main(String[] args) {
//    Button1 gui = new Button1();
//    gui.go();
//  }
//
//  public void go() {
//    JFrame frame = new JFrame();
//
//    JButton east = new JButton("East");
//    JButton west = new JButton("West");
//    JButton north = new JButton("North");
//    JButton south = new JButton("South");
//    JButton center = new JButton("Center");
//
//    frame.getContentPane().add(BorderLayout.EAST, east);
//    frame.getContentPane().add(BorderLayout.WEST, west);
//    frame.getContentPane().add(BorderLayout.NORTH, north);
//    frame.getContentPane().add(BorderLayout.SOUTH, south);
//    frame.getContentPane().add(BorderLayout.CENTER, center);
//
//    frame.setSize(300, 300);
//    frame.setVisible(true);
//  }
//}
