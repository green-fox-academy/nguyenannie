import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your email in this format firstName.lastName@exam.com");
        String userEmail = input.nextLine();

        NameFromEmail nameFromEmail = new NameFromEmail();
        System.out.println(nameFromEmail.nameFromEmail(userEmail));
    }
}
