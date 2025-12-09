package chp1;

public class Control {
    public static void main(String[] args) {
        // -----------------------------
        // 1. Do something (Statements)
        // -----------------------------

        System.out.println("-----1. Do something (Statements)-----");
        // Declare and assign an integer variable
        int x = 3;

        // Declare and assign a String variable
        String name = "Dirk";

        // Multiply x by 17 and update its value
        x = x * 17;

        // Print the current value of x
        System.out.println("x is " + x);

        // Generate a random double value between 0.0 and 1.0
        double d = Math.random();  // Note: We're not using this value, just testing
        System.out.println(d);
        // -----------------------------
        // 2. Do something again and again (Loops)
        // -----------------------------

        System.out.println("-----2.Do something again and again (Loops)-----");
        // WHILE loop: run as long as x is greater than 12
        // This loop will not print any output because there is no print statement inside it
        while (x > 12) {
            x = x - 1; // decrease x by 1 each time
        }

        // FOR loop: repeat 10 times, from i = 0 to i < 10
        for (int i = 0; i < 10; i = i + 1) {
            System.out.println("i is now " + i);
        }


    }
}

