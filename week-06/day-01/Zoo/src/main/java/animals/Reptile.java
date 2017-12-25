package main.java.animals;

public class Reptile extends Animal {
    public Reptile(String name) {
        this.name = name;
        this.breedMethod = "laying eggs";
        this.foodType = "earthworm";
        this.sleepingHours = 14;
        this.livingEnvironment = "tropical place";
    }
    @Override
    public void move() {

    }
}
