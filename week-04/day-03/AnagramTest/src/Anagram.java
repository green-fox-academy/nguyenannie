public class Anagram {
    public boolean checkAnagram(String str1, String str2) {
        boolean result;
        StringBuilder strb1 = new StringBuilder(str1);
        strb1 = strb1.reverse();
        str1 = strb1.toString();

        if(str1.equals(str2)){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
