package chp5;

// This class contains the main logic for playing the Simple Startup game.
public class SimpleStartupGame {
  public static void main(String[] args) {
    // Variable to track the number of guesses the user has made.
    int numOfGuesses = 0;
    // An instance of GameHelper, which provides utility methods for the game, like getting user input.
    // NOTE: GameHelper is a pre-made class for the book examples and not part of standard Java library.
    GameHelper helper = new GameHelper();

    // Create an instance of the SimpleStartup class, which represents the target.
    SimpleStartup theStartup = new SimpleStartup();
    // Generate a random number between 0 and 4. This will be the starting cell of the startup.
    int randomNum = (int) (Math.random() * 5);

    // Create an array to hold the location of the startup. It will occupy 3 consecutive cells.
    int[] locations = {randomNum, randomNum + 1, randomNum + 2};
    // Set the location of the startup.
    theStartup.setLocationCells(locations);
    // A boolean flag to track if the startup is still alive. The game continues as long as this is true.
    boolean isAlive = true;

    // The main game loop. It continues as long as the startup is alive.
    while (isAlive) {
      // Get a number from the user as their guess.
      int guess = helper.getUserInput("enter a number");
      // Ask the startup object to check the guess. The result will be "hit", "miss", or "kill".
      String result = theStartup.checkYourself(guess);
      // Increment the number of guesses made.
      numOfGuesses++;
      // Check if the result of the guess was a "kill".
      if (result.equals("kill")) {
        // If it was a "kill", the startup is no longer alive.
        isAlive = false;
        // Print the total number of guesses the user took.
        System.out.println("You took " + numOfGuesses + " guesses");
      } // close if
    } // close while
  } // close main

}
