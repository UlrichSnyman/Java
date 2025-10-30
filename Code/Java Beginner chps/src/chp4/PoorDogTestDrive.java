package chp4;

// Defines the PoorDog class
class PoorDog {
  // private instance variable to store the size of the dog.
  // It's an int, so it will have a default value of 0 if not initialized.
  private int size;
  // private instance variable to store the name of the dog.
  // It's a String, so it will have a default value of null if not initialized.
  private String name;

  // Getter method to access the private 'size' variable.
  public int getSize() {
    return size;
  }

  // Getter method to access the private 'name' variable.
  public String getName() {
    return name;
  }
}

// This is the matchTest class for the PoorDog class.
public class PoorDogTestDrive {
  // The main method, where the program execution begins.
  public static void main(String[] args) {
    // Create an instance of the PoorDog class.
    PoorDog one = new PoorDog();
    // Calls the getSize() method on the 'one' object and prints the result.
    // The output will be "Dog size is 0" because the 'size' instance variable was not explicitly set.
    System.out.println("Dog size is " + one.getSize());
    // Calls the getName() method on the 'one' object and prints the result.
    // The output will be "Dog name is null" because the 'name' instance variable was not explicitly set.
    System.out.println("Dog name is " + one.getName());
  }
}