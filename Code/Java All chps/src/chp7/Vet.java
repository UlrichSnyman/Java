package chp7;

class Vet {
  public void giveShot(Animal a) {
    // do horrible things to the Animal at
    // the other end of the ‘a’ parameter
    a.makeNoise();
  }
  public void setFree (Animal a) {
    a.roam();
  }
  public void giveFood(Animal a) {
    a.eat();
  }
}



class PetOwner {
  public void start() {
    Vet vet = new Vet();
    Dog dog = new Dog();
    Hippo hippo = new Hippo();
    vet.giveShot(dog);
    vet.giveShot(hippo);
    vet.setFree(dog);
    vet.giveFood(dog);
  }
}

class main {
  public static void main(String[] args) {
    PetOwner owner = new PetOwner();
    owner.start();
  }
}