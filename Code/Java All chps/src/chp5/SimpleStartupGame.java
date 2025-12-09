package chp5;

public class SimpleStartupGame {
  public static void main(String[] args) {
    int numOfGuesses = 0;
    // GameHelper for user input
    GameHelper helper = new GameHelper();

    // Create the startup object
    SimpleStartup theStartup = new SimpleStartup();
    // Generate a random starting cell
    int randomNum = (int) (Math.random() * 5);

    // Create and set the startup's location
    int[] locations = {randomNum, randomNum + 1, randomNum + 2};
    theStartup.setLocationCells(locations);
    boolean isAlive = true;

    // Main game loop
    while (isAlive) {
      int guess = helper.getUserInput("enter a number");
      // Check the user's guess
      String result = theStartup.checkYourself(guess);
      numOfGuesses++;
      // Check for a "kill" result to end the game
      if (result.equals("kill")) {
        isAlive = false;
        System.out.println("You took " + numOfGuesses + " guesses");
      }
    }
  }

}
