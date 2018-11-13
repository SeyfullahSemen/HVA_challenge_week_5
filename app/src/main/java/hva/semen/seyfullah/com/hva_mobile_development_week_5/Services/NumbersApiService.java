package hva.semen.seyfullah.com.hva_mobile_development_week_5.Services;


import hva.semen.seyfullah.com.hva_mobile_development_week_5.Retrofit.TriviaJson;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/*
 * Created by Seyfullah Semen on 12-11-2018.
 */
public interface NumbersApiService {

    String BASE_URL = "http://numbersapi.com/";

    /**
     * Create a retrofit client.
     */

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    /**
     * This get will get a random trivia output.
     */
    @GET("/random/?json&max=999")
    Call<TriviaJson> getRandomQuote();


}
