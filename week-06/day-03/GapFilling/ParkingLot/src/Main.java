public class Main {
    public static void main(String[] args) {
        CarList carList = new CarList();

        System.out.println("Most frequent car based on car type: \n" + carList.findMostFrequentType() + "\n");
        System.out.println("Most frequent car based on color: \n" + carList.findMostFrequentColor() + "\n");
        System.out.println("Most frequent car based on both type and color: \n" + carList.findMostFrequentCar());
    }
}
