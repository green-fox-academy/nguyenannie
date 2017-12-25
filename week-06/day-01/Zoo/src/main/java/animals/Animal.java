package main.java.animals;

public abstract class Animal {
    protected String name;
    protected int age;
    protected String breedMethod;
    protected String gender;
    protected int sleepingHours;
    protected String foodType;
    protected String livingEnvironment;

    public String getName() {
        return this.name;
    }

    public String breed() {
        return this.breedMethod;
    }

    public String eat() {
        return this.foodType;
    }

    public abstract void move();

    public int sleep() {
        return this.sleepingHours;
    }

    public String liveIn() {
        return this.livingEnvironment;
    }
}
