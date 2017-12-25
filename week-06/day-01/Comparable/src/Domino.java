public class Domino implements Comparable<Domino>{
    private final int[] values;

    public Domino(int valueA, int valueB) {
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
    public int compareTo(Domino compareDomino) {
        int compareDomino0 = compareDomino.getValues()[0];
        int compareDomino1 = compareDomino.getValues()[1];
        if(this.getValues()[0] != compareDomino0) {
            return this.getValues()[0] - compareDomino0;
        } else {
            return this.getValues()[1] - compareDomino1;
        }
    }
}
