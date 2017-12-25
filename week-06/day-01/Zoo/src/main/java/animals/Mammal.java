package main.java.animals;

public class Mammal extends Animal {
    public Mammal(String name) {
        this.name = name;
        this.breedMethod = "pushing miniature versions out";
        this.foodType = "plant or other animal or both";
        this.sleepingHours = 8;
        this.livingEnvironment = "various places";
    }
    @Override
    public void move() {
    }
}
