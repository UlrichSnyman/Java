package chp1;

public class DooBee {
    public static void main(String[] args) {
        int x = 1;
        while (x < 4 ) {
            if (x == 1) {
                System.out.printf("Doo");
                System.out.println("Bee");
                x = x + 1;
            }
            else {
                System.out.printf("Doo");
                System.out.printf("Bee");
                x = x + 1;
            }
        }
        if (x == 4) {
            System.out.print("Do");
        }
    }
}