public class WarApp {
    public static void main(String[] args) {
        Armada armada1 = new Armada();
        Armada armada2 = new Armada();

        Ship ship1 = new Ship();
        Ship ship2 = new Ship();

        ship1.fillShip();
        ship2.fillShip();

        armada1.ships.add(ship1);
        armada1.ships.add(ship2);

        Ship ship3 = new Ship();
        Ship ship4 = new Ship();

        ship3.fillShip();
        ship4.fillShip();
        armada2.ships.add(ship3);
        armada2.ships.add(ship4);

        ship1.captainConsumedRum();
        ship2.captainConsumedRum();
        ship3.captainConsumedRum();
        ship4.captainConsumedRum();

        if(armada1.war(armada2)) {
            System.out.println("armada 1 wins");
        } else {
            System.out.println("armada 2 wins");
        };



    }
}
