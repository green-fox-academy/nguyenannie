public class String1 {
    public static void main(String[] args) {
        System.out.println(replace("abxabxx"));

    }

    public static String replace(String str) {

        if (str.length() == 0) {
            return "";
        }
        if (str.charAt(0) == 'x') {
            return "y" + replace(str.substring(1, str.length()));
        } else {
            return str.charAt(0) + replace(str.substring(1, str.length()));
        }
    }
}
