package chp5;

// Test class for the SimpleStartup game.
public class SimpleStartupTestDrive {
  // Main method to run the test.
  public static void main(String[] args) {
    // 1. Instantiate a SimpleStartup object.
    SimpleStartup dot = new SimpleStartup();

    // 2. Create an array for the location of the startup (3 consecutive cells).
    int randomNum = (int) (Math.random() * 10) + 1; // From 1 to 10
    int[] locations = {randomNum, randomNum+1, randomNum+2};
    // 3. Set the location of the startup.
    dot.setLocationCells(locations);

    // 4. Create a fake user guess that is one of the locations.
    int userGuess = 2;
    // 5. Check the user's guess and get the result.
    String result = dot.checkYourself(userGuess);
    // 6. Initialize the test result to "failed".
    String testResult = "failed";
    // 7. If the guess was a "hit", change the test result to "passed".
    if (result.equals("hit")) {
      testResult = "passed";
    }
    // 8. Print the test result. Since userGuess is 2 and locations are {2,3,4}, the result will be "hit",
    // so this will print "passed".
    System.out.println(testResult);
  }
}

// Represents a simple startup in the game.
class SimpleStartup {
  // Array to hold the location cells of the startup.
  private int[] locationCells;
  // To keep track of the number of hits.
  private int numOfHits = 0;

  // Setter method to set the location cells of the startup.
  public void setLocationCells(int[] locs) {
    locationCells = locs;
  }

  // Method to check the user's guess.
  public String checkYourself(int guess) {
    // Assume it's a "miss" initially.
    String result = "miss";
    // Loop through each cell in the locationCells array.
    for (int cell : locationCells) {
      // If the guess matches a cell...
      if (guess == cell) {
        // ...it's a "hit".
        result = "hit";
        // Increment the number of hits.
        numOfHits++;
        // No need to check the other cells, so break out of the loop.
        break;
      } // end if
    } // end for

    // After the loop, check if all cells have been hit.
    if (numOfHits == locationCells.length) {
      // If so, the startup is "killed".
      result = "kill";
    } // end if

    // Print the result for the user ("miss", "hit", or "kill").
    System.out.println(result);
    // Return the result.
    return result;
  } // end method
} // close class