public class String2 {
    public static void main(String[] args) {
        String aString = "axbycxdyex";
        System.out.println(deleteX(aString));
    }

    public static String deleteX(String str) {
        if(str.length() == 0) {
            return "";
        }
        if(str.charAt(0) == 'x') {
            return deleteX(str.substring(1,str.length()));
        } else {
            return str.charAt(0) + deleteX(str.substring(1,str.length()));
        }
    }
}
