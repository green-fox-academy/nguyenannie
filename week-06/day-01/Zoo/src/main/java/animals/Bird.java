package main.java.animals;

public class Bird extends Animal {
    public Bird(String name) {
        this.name = name;
        this.breedMethod = "laying eggs";
        this.foodType = "seed";
        this.sleepingHours = 12;
        this.livingEnvironment = "tree";
    }

    @Override
    public void move() {

    }
}
