public class Main {
    public static void main(String[] args) {
        Ship ship1 = new Ship();
        Ship ship2 = new Ship();

        ship1.fillShip();
        ship2.fillShip();

        ship1.battle(ship2);
        if(ship1.win){
            System.out.println("Ship1 wins");
        } else {
            System.out.println("Ship2 wins");
        }

        System.out.println(ship1.alivePirates);
        System.out.println(ship2.alivePirates);

    }

}
