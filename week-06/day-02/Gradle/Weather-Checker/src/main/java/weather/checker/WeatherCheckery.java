package weather.checker;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface WeatherCheckery {
    @Headers({
            "X-Mashape-Key:MezjYC1JMGmshu6IFs7kYrx9ua3xp1QgOdHjsnQKBIMvntig1u",
            "Accept:text/plain"
    })

    @GET("https://simple-weather.p.mashape.com/weather")
    Call<ResponseBody> findWeatherInfo(@Query("lat") String lat,
                                            @Query("lng")String lng);
}

