package chp13;

// Main class to run the laundry and handle exceptions
public class WashingMachine {
    public static void main(String[] args) {
        Laundry laundry = new Laundry();

        try {
            laundry.doLaundry();
        } catch (TeeShirtException tex) {
            System.out.println("Caught TeeShirtException: " + tex.getMessage());
        } catch (LingerieException lex) {
            System.out.println("Caught LingerieException: " + lex.getMessage());
        } catch (ClothingException cex) {
            System.out.println("Caught ClothingException: " + cex.getMessage());
        }

        System.out.println("Laundry process complete.");
    }
}
