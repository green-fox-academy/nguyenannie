public class Main {
    public static void main(String[] args) {
        Pirate pirate1 = new Pirate();
        Pirate pirate2 = new Pirate();

        pirate1.brawl(pirate2);
        System.out.println(pirate1.alive);
        System.out.println(pirate2.alive);

    }

}
