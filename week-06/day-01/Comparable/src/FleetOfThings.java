import java.util.Collections;

class FleetOfThings {
    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        ToDo thing1 = new ToDo("Get milk");
        fleet.add(thing1);

        ToDo thing2 = new ToDo("Clean the house");
        fleet.add(thing2);

        ToDo thing3 = new ToDo("Shopping");
        thing3.complete();
        fleet.add(thing3);

        ToDo thing4 = new ToDo("Prepare lunch");
        thing4.complete();
        fleet.add(thing4);

        ToDo thing5 = new ToDo("Feed Rubble and Sonic");
        fleet.add(thing5);
        ToDo thing6 = new ToDo("Buy gloves");
        thing6.complete();
        fleet.add(thing6);

        Collections.sort(fleet.getThings());
        System.out.println(fleet.toString());

    }
}