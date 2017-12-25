package main.java.music;

public class ElectricGuitar extends StringInstrument {
    public ElectricGuitar() {
        name = "Electric Guitar";
        numberOfStrings = 6;
    }

    public ElectricGuitar(int numberOfString) {
        name = "Electric Guitar";
        this.numberOfStrings = numberOfString;
    }

    @Override
    public void sound() {
        this.sound = "Twang";
    }
}
