package chp5challenge;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameHelper {

    private static final String ALPHABET = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize]; // A grid to track used locations
    private int comCount = 0; // Ship count

    public String getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    public ArrayList<String> placeShip(int shipSize) {
        ArrayList<String> alphaCells = new ArrayList<>(); // Holds the generated coordinates like "a1", "b2"
        String temp; // Temporary string for concatenation
        int[] coords = new int[shipSize]; // Current candidate coordinates
        int attempts = 0; // Current number of attempts
        boolean success = false; // Flag to see if we found a valid location
        int location; // Current starting location

        comCount++; // Increment ship count for horizontal/vertical placement logic
        int incr = 1; // Set horizontal increment by default
        if ((comCount % 2) == 1) { // If it's an odd-numbered ship (1st, 3rd, etc.)
            incr = gridLength; // Set vertical increment
        }

        while (!success & attempts++ < 200) { // Main search loop
            location = (int) (Math.random() * gridSize); // Get a random starting point 0-48

            int x = 0; // Nth position in the ship to be placed
            success = true; // Assume success
            while (success && x < shipSize) { // Look for adjacent unused spots
                if (grid[location] == 0) { // If the spot is not already used
                    coords[x++] = location; // Save location
                    location += incr; // Try next adjacent spot
                    if (location >= gridSize) { // Out of bounds on the bottom
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0)) { // Out of bounds on the right edge
                        success = false;
                    }
                } else { // Found a location that's already used
                    success = false;
                }
            }
        }

        // Convert the valid integer locations to "a1"-style alphanumeric coordinates
        int x = 0;
        int row;
        int column;
        while (x < shipSize) {
            grid[coords[x]] = 1; // Mark these grid points as 'used'
            row = coords[x] / gridLength; // Get the row value
            column = coords[x] % gridLength; // Get the numeric column value
            temp = String.valueOf(ALPHABET.charAt(column)); // Convert to letter
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }
        return alphaCells;
    }
}