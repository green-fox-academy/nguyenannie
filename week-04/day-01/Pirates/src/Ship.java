import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
    List<Pirate> ship;
    Pirate captain;
    int alivePirates;
    boolean win;
    int rumStorage;

    public void fillShip() {
        ship = new ArrayList<>();
        captain = new Pirate();
        ship.add(captain);
        for (int i = 0; i < new Random().nextInt(100); i++) {
            ship.add(new Pirate());
        }
    }

    public int numberofAlivePirate() {
        for (int i = 0; i < ship.size(); i++) {
            if (ship.get(i).alive) {
                alivePirates += 1;
            }
        }
        return alivePirates;
    }

    public int captainConsumedRum() {
        captain.drinkSomeRum();
        return captain.rum;
    }

    public int calculateScore(){
        int calculatedScore = alivePirates - captainConsumedRum();
        return calculatedScore;
    }

    public void captainStatus() {
        if (!captain.alive) {
            System.out.println("Captain is dead");
        } else if (captainConsumedRum() <= 4) {
            System.out.println("Captain drank " + captainConsumedRum() + " rum");
        } else {
            System.out.println("Captain passes out!");
        }

    }

    public boolean battle(Ship anotherShip) {
        if (this.calculateScore() < anotherShip.calculateScore()) {
            win = false;
            alivePirates -= new Random().nextInt();
        } else {
            win = true;
            rumStorage += new Random().nextInt();
        }
        return win;
    }

    public void getStatus(){
        System.out.println("Captain consumed " + captainConsumedRum() + " rums.");
        System.out.println("Number of alive pirates in the crew are: " + numberofAlivePirate());
    }
}
