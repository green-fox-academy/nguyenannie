public class Reverse {
    public static void main(String[] args) {
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
        StringBuilder newBuilder = new StringBuilder(reversed).reverse();
        String newString = newBuilder.toString();
        System.out.print(newString);


        /*reversed = reversed.substring(5);
        System.out.print(reversed);
        */

        /* for (int i = 0; i < reversed.length(); i++) {
        reversed = reversed.substring(1, reversed.length() - i) + reversed.charAt(0) + reversed.substring(reversed.length() - i);
        }

        System.out.print(reversed);
        */
        }


    }

