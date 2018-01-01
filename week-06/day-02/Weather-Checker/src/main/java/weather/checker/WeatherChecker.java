package weather.checker;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

public class WeatherChecker {
    public static final String INPUT_FILE = "data.csv";

    public static void main(String[] args) {
        Coordinate coordinate;
        WeatherResponse weatherResponse = new WeatherResponse();
        CoordinateReader coordinateReader = new CoordinateReader(INPUT_FILE);

        OptionParser optionParser = new OptionParser();
        optionParser.accepts("c").withRequiredArg();
        optionParser.accepts("compare").withRequiredArg();
        OptionSet options = optionParser.parse(args);

        String countryCode1 = (String) options.valueOf("c");

        coordinate = coordinateReader.findCoordinate(countryCode1);

        String response1 = weatherResponse.getResponse(coordinate.lat, coordinate.lng);

        if(options.has("c") && options.has("compare")) {
            String countryCode2 = (String) options.valueOf("compare");
            coordinate = coordinateReader.findCoordinate(countryCode2);
            String response2 = weatherResponse.getResponse(coordinate.lat, coordinate.lng);
            int temperatureDiff = getTemperature(response1) - getTemperature(response2);
            System.out.println(temperatureDiff + "C");
        } else if( options.has("c")) {
            System.out.println(response1);
        }

    }

    public static int getTemperature(String response) {
        String[] weatherArray = response.split(" ");
        return Integer.parseInt(weatherArray[0]);
    }
}
