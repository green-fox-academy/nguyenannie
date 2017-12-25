package main.java.music;

public class BassGuitar extends StringInstrument {
    public BassGuitar() {
        name = "Bass Guitar";
        numberOfStrings = 4;
    }

    public BassGuitar(int numberOfStrings) {
        name = "Bass Guitar";
        this.numberOfStrings = numberOfStrings;
    }
    @Override
    public void sound() {
        this.sound = "Duum-duum-duum";
    }
}
