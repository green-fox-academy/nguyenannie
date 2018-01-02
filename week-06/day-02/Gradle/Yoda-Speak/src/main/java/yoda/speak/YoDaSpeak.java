package yoda.speak;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface YoDaSpeak {
    @Headers({
            "X-Mashape-Key:MezjYC1JMGmshu6IFs7kYrx9ua3xp1QgOdHjsnQKBIMvntig1u",
            "Accept:text/plain"
    })
    @GET("https://yoda.p.mashape.com/yoda")
    Call<ResponseBody> translate(@Query("sentence") String sentence);
}
