package yoda.speak;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class YodaResponse {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://yoda.p.mashape.com/yoda/")
                .build();
        YoDaSpeak yoDaSpeak = retrofit.create(YoDaSpeak.class);

        Call<ResponseBody> responseBodyCall =
                yoDaSpeak.translate("Rub rub is a bad ket and sonic is the same.");

        Response<ResponseBody> response = null;
        try {
            response = responseBodyCall.execute();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(response.body().string());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
