public class TodoPrint {
    public static void main(String[] args) {

        String todoText = " - Buy milk\n";
        // Add " - Download games" to the end of the todoText
        // Add " - Diablo" to the end of the todoText but with indention

        // Expected outpt:

        //  - Buy milk
        //  - Download games
        //      - Diablo

        String todoText1 = "My todo:\n" + todoText;
        String todoText2 = todoText1 + " - Download games \n";
        String todoText3 = todoText2 + "       - Diablo \n";

        System.out.print(todoText3);
    }
    }

