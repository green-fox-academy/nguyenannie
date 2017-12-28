package weather.checker;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import java.io.IOException;

public class Main {
    public static final String INPUT_FILE = "data.csv";

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://simple-weather.p.mashape.com/weather/")
                .build();
        WeatherCheckery weatherInfo = retrofit.create(WeatherCheckery.class);
        WeatherReader weatherReader = new WeatherReader(INPUT_FILE);

        OptionParser optionParser = new OptionParser();
        optionParser.accepts("c").withRequiredArg();
        optionParser.accepts("compare").withRequiredArg();
        OptionSet options = optionParser.parse(args);

        String countryCode1 = (String) options.valueOf("c");

        String[] coordinate1 = weatherReader.findCoordinate(countryCode1);
        String lat1 = coordinate1[0];
        String lng1 = coordinate1[1];

        Call<ResponseBody> responseBodyCall1 = weatherInfo.findWeatherInfo(lat1, lng1);
        String response1 = responseBodyCall1.execute().body().string();
        System.out.println(response1);
        if(options.has("c") && options.has("compare")) {
            String countryCode2 = (String) options.valueOf("compare");
            String[] coordinate2 = weatherReader.findCoordinate(countryCode2);
            String lat2 = coordinate2[0];
            String lng2 = coordinate2[1];
            Call<ResponseBody> responseBodyCall2 = weatherInfo.findWeatherInfo(lat2, lng2);
            String response2 = responseBodyCall2.execute().body().string();
            int temperatureDiff = Integer.parseInt(getTemperature(response1)) - Integer.parseInt(getTemperature(response2));
            System.out.println(temperatureDiff + "C");
        } else if( options.has("c")) {
            System.out.println(response1);
        }

    }

    public static String getTemperature(String response) {
        String[] weatherArray = response.split(" ");
        return weatherArray[0];
    }
}
