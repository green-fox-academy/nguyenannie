package main.java.music;

public class Violin extends StringInstrument {
    public Violin() {
        name = "Violin";
        numberOfStrings = 4;
    }

    public Violin(int numberOfStrings) {
        name = "Bass Guitar";
        this.numberOfStrings = numberOfStrings;
    }
    @Override
    public void sound() {
        this.sound = "Screech";
    }
}
