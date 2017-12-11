import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
    List<Pirate> pirates;
    Pirate captain;
    int rumStorage;

    public Ship(){
        pirates = new ArrayList<>();
    }

    public void fillShip() {
        captain = new Pirate();
        pirates.add(captain);
        for (int i = 0; i < new Random().nextInt(100); i++) {
            pirates.add(new Pirate());
        }
    }

    public int numberofAlivePirates() {
        int alivePirates = 0;
        for (int i = 0; i < pirates.size(); i++) {
            if (pirates.get(i).getAlive()) {
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
        return numberofAlivePirates() - captain.rum; //captainConsumedRum()
    }

    public void captainStatus() {
        if (!captain.getAlive()) {
            System.out.println("Captain is dead");
        } else if (captain.rum > 4) {
            System.out.println("Captain consumed " + captain.rum + " rums.");
            System.out.println("Captain passes out!");
        } else {
            System.out.println("Captain consumed " + captain.rum + " rums.");
        }

    }

    public void loser(){
        for(int i = 0; i < pirates.size(); i++){
            if(pirates.get(i).getAlive() && Math.random() < 0.3 ) {
                pirates.get(i).die();
            }
        }
    }

    public void winner(){
        rumStorage += new Random().nextInt(50);
    }

    public boolean battle(Ship anotherShip) {
        boolean win;
        if (this.calculateScore() < anotherShip.calculateScore()) {
            this.loser();
            anotherShip.winner();
            win = false;
        } else {
            anotherShip.loser();
            this.winner();
            win = true;
        }
        return win;
    }

    public void getStatus(){
        System.out.println("Total number of crew is: " + pirates.size());
        captainStatus();
        System.out.println("Number of alive pirates in the crew are: " + numberofAlivePirates());
        System.out.println("Total rum storage is: " + rumStorage);
        System.out.println();
    }
}
