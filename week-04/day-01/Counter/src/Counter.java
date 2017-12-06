public class Counter {
    int initialValue;
    int savedValue;

    public Counter() {
        this.initialValue = 0;
    }
    public Counter(int inputValue) {
        this.initialValue = inputValue;
        savedValue = inputValue;
    }
    public void add(int number){
        initialValue += number;
    }
    public void add(){
        initialValue += 1;
    }
    public int get() {
        return initialValue;
    }
    public  void reset() {
        initialValue = savedValue;
    }
}


