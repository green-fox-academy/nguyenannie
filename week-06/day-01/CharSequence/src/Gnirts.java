public class Gnirts implements CharSequence {
    private String str;

    Gnirts(String str) {
        this.str = str;
    }

    public String getStr() {
        return this.str;
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        return str.charAt(str.length() - index - 1);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return str.subSequence(str.length() - end, str.length() - start);
    }

    public static void main(String[] args) {
        Gnirts gnirts = new Gnirts("example");
        System.out.println(gnirts.charAt(3));
        System.out.println(gnirts.subSequence(1,3));
    }
}
