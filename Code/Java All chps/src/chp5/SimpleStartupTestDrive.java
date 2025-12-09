package chp5;

// Test class for SimpleStartup.
public class SimpleStartupTestDrive {
  public static void main(String[] args) {
    SimpleStartup dot = new SimpleStartup();

    // Create a matchTest location for the startup.
    int[] locations = {2, 3, 4};
    dot.setLocationCells(locations);

    // Fake a user guess.
    int userGuess = 2;
    String result = dot.checkYourself(userGuess);

    String testResult = "failed";
    // If it's a "hit", the matchTest passed.
    if (result.equals("hit")) {
      testResult = "passed";
    }
    // Print the matchTest result.
    System.out.println(testResult);
  }
}

// Represents a startup in the game.
class SimpleStartup {
  private int[] locationCells;
  private int numOfHits = 0;

  public void setLocationCells(int[] locs) {
    locationCells = locs;
  }

  // Checks the user's guess and returns "miss", "hit", or "kill".
  public String checkYourself(int guess) {
    String result = "miss"; // Assume a miss

    // Loop through cells to check for a hit.
    for (int cell : locationCells) {
      if (guess == cell) {
        result = "hit";
        numOfHits++;
        break; // No need to check further
      }
    }

    if (numOfHits == locationCells.length) {
      result = "kill"; // It's a kill.
    }

    System.out.println(result);
    return result;
  }
}