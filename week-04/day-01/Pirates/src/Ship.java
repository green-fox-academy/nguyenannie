import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
    List<Pirate> ship;
    Pirate captain = new Pirate();
    int alivePirates;
    boolean win;
    int calculatedScore = alivePirates - captainConsumedRum();
    int rumStorage;

    public Ship() {
        ship = new ArrayList<>();
    }

    public void fillShip() {
        ship.add(captain);
        for (int i = 0; i < new Random().nextInt(100); i++) {
            ship.add(new Pirate());
        }
    }

    public void numberofAlivePirate() {
        for (int i = 0; i < ship.size(); i++) {
            if (ship.get(i).alive) {
                alivePirates += 1;
            }
        }
        System.out.println("Number of alive pirates are: " + alivePirates);
    }

    public int captainConsumedRum() {
        captain.drinkSomeRum();
        return captain.rum;
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
        if (this.calculatedScore < anotherShip.calculatedScore) {
            win = false;
            alivePirates -= new Random().nextInt();
        } else {
            win = true;
            rumStorage += new Random().nextInt();
        }
        return win;
    }
}
