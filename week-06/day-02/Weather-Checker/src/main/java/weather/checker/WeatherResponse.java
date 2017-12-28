package weather.checker;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class WeatherResponse {
    private WeatherCheckery weatherInfo;
    private static final String BASE_URL = "https://simple-weather.p.mashape.com/weather/";

    WeatherResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
        weatherInfo = retrofit.create(WeatherCheckery.class);
    }

    public String getResponse(String lat, String lng) throws IOException {
        Call<ResponseBody> responseBodyCall1 = weatherInfo.findWeatherInfo(lat, lng);
        return responseBodyCall1.execute().body().string();
    }
}