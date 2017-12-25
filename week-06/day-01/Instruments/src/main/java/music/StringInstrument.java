package main.java.music;

public abstract class StringInstrument extends Instrument{
    protected int numberOfStrings;
    protected String sound;
    protected abstract void sound();

    @Override
    public void play() {
        sound();
        System.out.println(name + ", a " + numberOfStrings + "-stringed instrument that goes " + sound);
    }
}
