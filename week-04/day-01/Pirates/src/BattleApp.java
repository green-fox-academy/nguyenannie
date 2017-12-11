public class BattleApp {
    public static void main(String[] args) {
        Ship ship1 = new Ship();
        Ship ship2 = new Ship();

        ship1.fillShip();
        ship2.fillShip();

        System.out.println(ship1.ship.size());
        System.out.println(ship2.ship.size());

        ship1.getStatus();
        ship2.getStatus();
    }
}
