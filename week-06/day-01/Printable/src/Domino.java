public class Domino implements Printable{
    private final int[] values;

    Domino(int valueA, int valueB) {
        this.values = new int[]{valueA, valueB};
    }

    public int[] getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "[" + values[0] + ", " + values[1] + "]";
    }

    @Override
    public void printAllField() {
        System.out.print(toString());
    }
}

