package amit.chefling_amit2.api;

/**
 * Created by amit on 10/28/2016.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amit on 9/25/2016.
 */

public class ApiClient {
    public static final String BASE_URL = "https://query.yahooapis.com/v1/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}