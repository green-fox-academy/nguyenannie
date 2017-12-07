public class FleetOfThings {
    public static void main(String[] args) {
        Fleet fleet = new Fleet();
        // Create a fleet of things to have this output:
        // 1. [ ] Get milk
        // 2. [ ] Remove the obstacles
        // 3. [x] Stand up
        // 4. [x] Eat lunch
        Thing thing1 = new Thing("Get milk");
        fleet.add(thing1);
        Thing thing2 = new Thing("Remove the obstacles");
        fleet.add(thing2);
        Thing thing3 = new Thing("Stand up");
        thing3.complete();
        fleet.add(thing3);
        Thing thing4 = new Thing("Eat lunch");
        thing4.complete();
        fleet.add(thing4);
        fleet.toString();
        System.out.println(fleet);

    }
}
