import java.util.Random;

public class Car {
    private CarType carType;
    private Color color;
    private Random random;

    public Car() {
        random = new Random();
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public CarType getCarType() {
        return carType;
    }

    public CarType randomType() {
        int r = random.nextInt(6);
        CarType carType = null;
        switch (r) {
            case 0:
                carType = CarType.MPV;
                break;
            case 1:
                carType = CarType.SUV;
                break;
            case 2:
                carType = CarType.COUPLE;
                break;
            case 3:
                carType = CarType.CONVERTIBLE;
                break;
            case 4:
                carType = CarType.HATCHBACK;
                break;
            case 5:
                carType = CarType.SEDAN;
                break;
        }
        return carType;
    }

    public Color randomColor() {
        int r = random.nextInt(5);
        Color color = null;
        switch (r) {
            case 0:
                color = Color.BLACK;
                break;
            case 1:
                color = Color.BLUE;
                break;
            case 2:
                color = Color.RED;
                break;
            case 3:
                color = Color.SILVER;
                break;
            case 4:
                color = Color.WHITE;
                break;
        }
        return color;
    }

    @Override
    public String toString() {
        return "Car is of type " + carType + " and its color is " + color;
    }


}
