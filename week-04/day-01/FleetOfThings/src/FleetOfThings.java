public class FleetOfThings {
    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        // Create a fleet of things to have this output:
        // 1. [ ] Get milk
        // 2. [ ] Remove the obstacles
        // 3. [x] Stand up
        // 4. [x] Eat lunch
        ToDo thing1 = new ToDo("Get milk");
        fleet.add(thing1);
        ToDo thing2 = new ToDo("Remove the obstacles");
        fleet.add(thing2);
        ToDo thing3 = new ToDo("Stand up");
        thing3.complete();
        fleet.add(thing3);
        ToDo thing4 = new ToDo("Eat lunch");
        thing4.complete();
        fleet.add(thing4);
        fleet.toString();
        System.out.println(fleet);

    }
}
