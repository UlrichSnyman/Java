package chp9;

public class ReRef {
  Duck d = new Duck();

  public void go() {
    d = new Duck();
  }
}