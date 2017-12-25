import main.java.animals.*;

public class Zoo {
    public static void main(String[] args) {

        Reptile reptile = new Reptile("Crocodile");
        Mammal mammal = new Mammal("Koala");
        Bird bird = new Bird("Parrot");

        System.out.println("Short introduce about yourself ?!");
        System.out.println("A " + reptile.getName() + " is breeding by " + reptile.breed()
                + ". It lives in " + reptile.liveIn() + " and sleeps around " + reptile.sleep() + " hours per day.");
        System.out.println("A " + mammal.getName() + " is breeding by " + mammal.breed()
                + ". It lives in " + mammal.liveIn() + " and sleeps around " + mammal.sleep() + " hours per day.");
        System.out.println("A " + bird.getName() + " is breeding by " + bird.breed() + ". It lives in "
                + mammal.liveIn() + " and sleeps around " + mammal.sleep() + " hours per day.");
    }
}
