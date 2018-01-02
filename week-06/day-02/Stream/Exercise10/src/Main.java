public class Main {
    public static void main(String[] args) {
        Foxes foxes = new Foxes();

        System.out.println("-----------------foxes with green color-----------------");
        foxes.getFoxes().stream()
                .filter(f -> f.getColor().equals("Green"))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("---------foxes with green color and of type Pallida---------");
        foxes.getFoxes().stream()
                .filter(f -> f.getColor().equals("Green") && f.getType().equals("Pallida"))
                .forEach(System.out::println);
    }
}
