public class UrlFixer {
    public static void main(String[] args) {
        String url = "https//www.reddit.com/r/nevertellmethebots";
        String replacedString = url.replace("bots","odds");
        //substring way
        String newString = replacedString.substring(0,5) + ":" +replacedString.substring(5,url.length());

        System.out.println(newString);

        //replace
        //String newString = replacedString.replace("https", "https:");
    }
}
