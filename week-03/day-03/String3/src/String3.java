public class String3 {
    public static void main(String[] args) {
        String aString = "Annie";
        System.out.println(separator(aString));

    }
    public static String separator(String str) {
        if(str.length() == 0) {
            return "";
        }
        if(str.length() == 1) {
            return str;
        } else {
            return str.charAt(0) + "*" + separator(str.substring(1,str.length()));
        }
    }
}
