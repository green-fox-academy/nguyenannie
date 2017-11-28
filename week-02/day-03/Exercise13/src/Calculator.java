import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        // Create a simple calculator application which reads the parameters from the prompt
        // and prints the result to the prompt.
        // It should support the following operations:
        // +, -, *, /, % and it should support two operands.
        // The format of the expressions must be: {operation} {operand} {operand}.
        // Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)

        // You can use the Scanner class
        // It should work like this:

        // Start the program
        // It prints: "Please type in the expression:"
        // Waits for the user input
        // Print the result to the prompt
        // Exit

        Scanner input = new Scanner(System.in);

        System.out.println("Please type in the expression:");
        String userExpression = input.nextLine();

        ArrayList<String> arrayListExpression = turntoArrayList(userExpression);
        System.out.print(calculator(arrayListExpression));
    }

    public static ArrayList<String> turntoArrayList(String userExpression){

            ArrayList<String> inputString = new ArrayList<String>();
            String operation = userExpression.substring(0, 1);
            inputString.add(operation);

            int k = 0;
            int g = 0;
            for (int i = 0; i < userExpression.length(); i++) {
                if (userExpression.substring(i, i + 1).equals(" ")) {
                    k = i;
                    break;
                }
            }
            for (int i = 0; i < userExpression.length(); i++) {
                if (userExpression.substring(i, i + 1).equals(" ")) {
                    g = i;
                }
            }


            String number1 = userExpression.substring(k + 1, g);
            String number2 = userExpression.substring(g + 1);

            inputString.add(number1);
            inputString.add(number2);

            return inputString;
        }

    public static int calculator(ArrayList<String> anArray){
        int number1 = Integer.parseInt(anArray.get(1));
        int number2 = Integer.parseInt(anArray.get(2));
        int result = 0;

        if(anArray.get(0).equals("*")) {
            result = number1 * number2;
        }

        if(anArray.get(0).equals("+")) {
            result = number1 + number2;
        }
        if(anArray.get(0).equals("-")) {
            result = number1 - number2;
        }
        if(anArray.get(0).equals("/")) {
            result = number1 / number2;
        }
        if(anArray.get(0).equals("%")) {
            result = number1 % number2;
        }

        return result;
    }


}

