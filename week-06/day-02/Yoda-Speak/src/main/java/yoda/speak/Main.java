package yoda.speak;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://yoda.p.mashape.com/yoda/")
                .build();
        YoDaSpeak yoDaSpeak = retrofit.create(YoDaSpeak.class);

        Call<ResponseBody> responseBodyCall =
                yoDaSpeak.translate("Rub rub is a bad ket and sonic is the same.");

        Response<ResponseBody> response = responseBodyCall.execute();

        System.out.println(response.body().string());
    }
}
