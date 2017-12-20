public class FavouriteAnimals {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("java FavouriteAnimals [animal] [animal]");
        }

        Model model = new Model();
        try {
            model.addAnimal(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
