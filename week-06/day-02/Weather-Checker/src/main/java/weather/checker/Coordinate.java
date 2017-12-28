package weather.checker;

public class Coordinate {
    String[] coordinate;
    String lat;
    String lng;

    Coordinate(String[] coordinate) {
        this.coordinate = coordinate;
        lat = coordinate[0];
        lng = coordinate[1];
    }

}
