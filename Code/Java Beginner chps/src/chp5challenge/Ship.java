package chp5challenge;

import java.util.ArrayList;

public class Ship {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        // Check if the user's guess is in our list of locations.
        int index = locationCells.indexOf(userInput);

        // If 'indexOf' returns a value greater than or equal to 0, it was a hit.
        if (index >= 0) {
            // A hit! Remove the hit location from the list.
            locationCells.remove(index);

            // If the list of locations is now empty, the ship is sunk.
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " :(");
            } else {
                result = "hit";
            }
        }
        return result;
    }
}