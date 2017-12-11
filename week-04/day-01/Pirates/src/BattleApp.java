public class BattleApp {
    public static void main(String[] args) {
        Ship ship1 = new Ship();
        Ship ship2 = new Ship();

        ship1.fillShip();
        ship2.fillShip();

        ship1.captainConsumedRum();
        ship2.captainConsumedRum();

        ship1.getStatus();
        ship2.getStatus();

        ship1.battle(ship2);

        ship1.getStatus();
        ship2.getStatus();
    }
}
