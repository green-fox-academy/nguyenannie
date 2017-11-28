public class TakesLonger {
    public static void main(String[] args) {
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";
        int index = quote.indexOf("you");
        String newQuote = quote.substring(0,index) + "always takes longer than " + quote.substring(index,quote.length());

        System.out.println(index);
        System.out.print(newQuote);
    }
}
