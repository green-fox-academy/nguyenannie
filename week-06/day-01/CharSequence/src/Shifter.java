public class Shifter implements CharSequence {
    private String str;
    private int shift;

    Shifter(String str, int shift) {
        this.str = str;
        this.shift = shift;
    }

    String getStr() {
        return this.str;
    }

    int getShift() {
        return this.shift;
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        return str.charAt(index + shift);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return str.subSequence(start, end);
    }

    public static void main(String[] args) {
        Shifter shifter = new Shifter("example", 2);
        System.out.println(shifter.charAt(0));
    }
}
