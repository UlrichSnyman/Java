package chp13;

import java.util.Random;

public class Laundry {
  public void doLaundry() throws ClothingException {
      Random rand = new Random();
      int problem = rand.nextInt(3); // 0, 1, or 2

      System.out.println("Starting laundry...");

      if (problem == 0) {
          throw new TeeShirtException("Tee-shirt got stuck in the washer!");
      } else if (problem == 1) {
          throw new LingerieException("Delicate lingerie got torn!");
      } else {
          throw new ClothingException("Generic clothing issue occurred.");
      }
  }
}