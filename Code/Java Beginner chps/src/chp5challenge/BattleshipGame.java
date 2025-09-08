package chp5challenge;

import java.util.ArrayList;

public class BattleshipGame {

    private GameHelper helper = new GameHelper();
    private ArrayList<Ship> ships = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        // Create the three ships
        Ship ship1 = new Ship();
        ship1.setName("Submarine");
        Ship ship2 = new Ship();
        ship2.setName("Cruiser");
        Ship ship3 = new Ship();
        ship3.setName("Battleship");

        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);

        System.out.println("Your goal is to sink three ships.");
        System.out.println("Submarine, Cruiser, Battleship");

        // Ask the helper to place each ship and set its location
        for (Ship shipToSet : ships) {
            ArrayList<String> newLocation = helper.placeShip(3);
            shipToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!ships.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess (e.g., a1, b2)");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (int i = 0; i < ships.size(); i++) {
            Ship shipToTest = ships.get(i);
            result = shipToTest.checkYourself(userGuess);

            if (result.equals("hit")) {
                break; // No need to check other ships
            }
            if (result.equals("kill")) {
                ships.remove(i); // Remove the sunk ship
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All ships are sunk! Your stock is now worthless.");
        System.out.println("It only took you " + numOfGuesses + " guesses.");
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.setUpGame();
        game.startPlaying();
    }
}