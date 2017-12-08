public class Main {
    public static void main(String[] args) {
        Garden garden = new Garden();

        Tree tree1 = new Tree();
        tree1.setColor("purple");
        Tree tree2 = new Tree();
        tree2.setColor("orange");

        Flower flower1 = new Flower();
        flower1.setColor("yellow");
        Flower flower2 = new Flower();
        flower2.setColor("blue");

        garden.addPlant(flower1);
        garden.addPlant(flower2);
        garden.addPlant(tree1);
        garden.addPlant(tree2);

        garden.printStatus();
        for(int i = 0; i < garden.plants.size(); i ++) {
            if(garden.plants.get(i).needWater){
                garden.calculateDryPlants();
                garden.water(40);
                garden.printStatus();
                if(garden.plants.get(i).needWater) {
                    garden.calculateDryPlants();
                    garden.water(70);
                    garden.printStatus();
                }
            }
        }

    }
}
