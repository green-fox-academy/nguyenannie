import java.util.Scanner;

public class PartyIndicator {
    public static void main(String[] args) {
        Scanner partyPeople = new Scanner(System.in);

        System.out.println("Please enter the number of girls: ");
        int girlNum = partyPeople.nextInt();

        System.out.println("Please enter the number of boys: ");
        int boyNum = partyPeople.nextInt();

        int sumPeople = girlNum + boyNum;

        if (girlNum == boyNum && sumPeople >= 20) {
            System.out.println("The party is excellent!");
        } else if (girlNum != boyNum && sumPeople >= 20) {
            System.out.println("Quite cool party!");
        } else if (sumPeople < 20) {
            System.out.println("Average party...");
        } else if (girlNum == 0) {
            System.out.println("Sausage party");
        }
    }
}
