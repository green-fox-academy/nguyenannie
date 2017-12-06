public class Station {
    int gasAmount;

    public void refill(Car car) {
        gasAmount -= car.gasAmount;
        car.gasAmount += gasAmount;
    }
}
