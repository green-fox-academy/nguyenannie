import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> cars;

    CarList() {
        cars = new ArrayList<>();
        for(int i = 0; i < 20; i ++) {
            Car car = new Car();
            car.setCarType(car.randomType());
            car.setColor(car.randomColor());
            cars.add(car);
        }
    }

    private int car_max = 0;
    private int color_max = 0;
    private int type_max = 0;
    private int car_index = 0;
    private int type_index = 0;
    private int color_index = 0;

    public Car findMostFrequentCar() {
        for(int i = 0; i < cars.size(); i++) {
            int counter = 0;
            for(int j = i + 1; j < cars.size() - 1; j++) {
                if (cars.get(i).getColor().equals(cars.get(j).getColor()) && cars.get(i).getCarType().equals(cars.get(j).getCarType())) {
                    counter++;
                }
            }
            if(counter > car_max) {
                car_max = counter;
                car_index = i;
            }
        }
        return cars.get(car_index);
    }

    public Car findMostFrequentColor() {
        for(int i = 0; i < cars.size(); i++) {
            int colorCounter = 0;
            for (int j = i + 1; j < cars.size() - 1; j++) {
                if (cars.get(i).getColor().equals(cars.get(j).getColor())) {
                    colorCounter++;
                }
            }
            if (colorCounter > color_max) {
                color_max = colorCounter;
                color_index = i;
            }
        }
        return cars.get(color_index);
    }

    public Car findMostFrequentType() {
        for(int i = 0; i < cars.size(); i++) {
            int typeCounter = 0;
            for (int j = i + 1; j < cars.size() - 1; j++) {
                if (cars.get(i).getCarType().equals(cars.get(j).getCarType())) {
                    typeCounter++;
                }
            }
            if (typeCounter > type_max) {
                type_max = typeCounter;
                type_index = i;
            }
        }

        return cars.get(type_index);
    }

}
